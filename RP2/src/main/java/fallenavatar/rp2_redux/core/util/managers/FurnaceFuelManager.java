package fallenavatar.rp2_redux.core.util.managers;

import cofh.lib.inventory.FalseIInventory;
import cofh.thermal.lib.util.managers.SingleItemFuelManager;
import cofh.thermal.lib.util.recipes.ThermalFuel;
import cofh.thermal.lib.util.recipes.internal.IDynamoFuel;
import fallenavatar.rp2_redux.core.init.RP2RecipeTypes;
import fallenavatar.rp2_redux.core.util.recipes.FurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;
import static cofh.lib.util.constants.Constants.RF_PER_FURNACE_UNIT;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class FurnaceFuelManager extends SingleItemFuelManager {

    private static final FurnaceFuelManager INSTANCE = new FurnaceFuelManager();
    protected static int DEFAULT_ENERGY = 16000;

    public static FurnaceFuelManager instance() {

        return INSTANCE;
    }

    private FurnaceFuelManager() {

        super(DEFAULT_ENERGY);
    }

    @Override
    public boolean validFuel(ItemStack input) {

        if (input.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).isPresent()) {
            return false;
        }
        return getEnergy(input) > 0;
    }

    @Override
    protected void clear() {

        fuelMap.clear();
        convertedFuels.clear();
    }

    public int getEnergy(ItemStack stack) {

        IDynamoFuel fuel = getFuel(stack);
        return fuel != null ? fuel.getEnergy() : getEnergyFurnaceFuel(stack);
    }

    public int getEnergyFurnaceFuel(ItemStack stack) {

        if (stack.isEmpty()) {
            return 0;
        }
        if (stack.getItem().hasContainerItem(stack)) {
            return 0;
        }
        int energy = ForgeHooks.getBurnTime(stack) * RF_PER_FURNACE_UNIT;
        return energy >= MIN_ENERGY ? energy : 0;
    }

    // region IManager
    @Override
    public void config() {

    }

    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        Map<ResourceLocation, IRecipe<FalseIInventory>> recipes = recipeManager.getRecipes(RP2RecipeTypes.FUEL_FURNACE);
        for (Map.Entry<ResourceLocation, IRecipe<FalseIInventory>> entry : recipes.entrySet()) {
            addFuel((ThermalFuel) entry.getValue());
        }
        createConvertedRecipes(recipeManager);
    }
    // endregion

    // region CONVERSION
    protected List<FurnaceFuel> convertedFuels = new ArrayList<>();

    public List<FurnaceFuel> getConvertedFuels() {

        return convertedFuels;
    }

    protected void createConvertedRecipes(RecipeManager recipeManager) {

        ItemStack query;
        for (Item item : ForgeRegistries.ITEMS) {
            query = new ItemStack(item);
            if (getFuel(query) == null && validFuel(query)) {
                convertedFuels.add(convert(query, getEnergy(query)));
            }
        }
    }

    protected FurnaceFuel convert(ItemStack item, int energy) {

        return new FurnaceFuel(new ResourceLocation(ID_RP2_REDUX, "fuel_" + item.getItem().getRegistryName().getPath()), energy, singletonList(Ingredient.fromStacks(item)), emptyList());
    }
    // endregion
}