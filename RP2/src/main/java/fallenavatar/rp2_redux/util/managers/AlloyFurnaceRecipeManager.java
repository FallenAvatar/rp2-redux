package fallenavatar.rp2_redux.util.managers;

import cofh.lib.inventory.FalseIInventory;
import cofh.lib.inventory.IItemStackAccess;
import cofh.lib.util.ComparableItemStack;
import fallenavatar.rp2_redux.init.RP2RecipeTypes;
import fallenavatar.rp2_redux.util.recipes.IRP2Inventory;
import fallenavatar.rp2_redux.util.recipes.RP2Recipe;
import fallenavatar.rp2_redux.util.recipes.internal.BaseMachineRecipe;
import fallenavatar.rp2_redux.util.recipes.internal.IMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.*;

import static java.util.Arrays.asList;

public class AlloyFurnaceRecipeManager extends AbstractManager implements IRecipeManager {

    private static final AlloyFurnaceRecipeManager INSTANCE = new AlloyFurnaceRecipeManager();
    protected static final int DEFAULT_ENERGY = 3200;

    protected Object2ObjectOpenHashMap<AlloyFurnaceMapWrapper, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxInputItems;
    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static AlloyFurnaceRecipeManager instance() {

        return INSTANCE;
    }

    private AlloyFurnaceRecipeManager() {
        super();
        this.maxInputItems = 9;
        this.maxOutputItems = 1;
    }

    public void addRecipe(RP2Recipe recipe, BaseMachineRecipe.RecipeType type) {

        switch (recipe.getInputItems().size()) {
            case 1:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    addRecipe(recipe.getXp(), Collections.singletonList(firstInput), recipe.getOutputItems(), type);
                }
                return;
            case 2:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
                        addRecipe(recipe.getXp(), asList(firstInput, secondInput), recipe.getOutputItems(), type);
                    }
                }
                return;
            case 3:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
                        for (ItemStack thirdInput : recipe.getInputItems().get(2).getMatchingStacks()) {
                            addRecipe(recipe.getXp(), asList(firstInput, secondInput, thirdInput), recipe.getOutputItems(), type);
                        }
                    }
                }
                return;
            default:
        }
    }

    public boolean validItem(ItemStack item) {
        return validItems.contains(convert(item));
    }

    protected void clear() {
        recipeMap.clear();
        validItems.clear();
    }

    // region RECIPES
    protected IMachineRecipe getRecipe(List<? extends IItemStackAccess> inputSlots) {

        if (inputSlots.isEmpty()) {
            return null;
        }
        List<ComparableItemStack> convertedItems = new ArrayList<>(maxInputItems);
        for (int i = 0; i < maxInputItems; ++i) {
            if (!inputSlots.get(i).isEmpty()) {
                ComparableItemStack compStack = convert(inputSlots.get(i).getItemStack());
                convertedItems.add(compStack);
            }
        }
        if (convertedItems.isEmpty()) {
            return null;
        }
        return recipeMap.get(new AlloyFurnaceMapWrapper(convertedItems));
    }

    protected IMachineRecipe addRecipe(float experience, List<ItemStack> inputItems,List<ItemStack> outputItems, BaseMachineRecipe.RecipeType type) {

        if (inputItems.isEmpty() || outputItems.isEmpty() || outputItems.size() > maxOutputItems) {
            return null;
        }
        for (ItemStack stack : inputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }

        List<ComparableItemStack> convertedItems = new ArrayList<>(inputItems.size());
        for (ItemStack stack : inputItems) {
            if (!inputItems.isEmpty()) {
                ComparableItemStack compStack = convert(stack);
                validItems.add(compStack);
                convertedItems.add(compStack);
            }
        }
        IMachineRecipe recipe = new BaseMachineRecipe(experience, inputItems, outputItems);
        recipeMap.put(new AlloyFurnaceMapWrapper(convertedItems), recipe);
        return recipe;
    }
    // endregion

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IRP2Inventory inventory) {

        return getRecipe(inventory.inputSlots());
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {

        return new ArrayList<>(recipeMap.values());
    }
    // endregion

    // region IManager
    @Override
    public void config() {

    }

    @Override
    public void refresh(RecipeManager recipeManager) {
        clear();
        Map<ResourceLocation, IRecipe<FalseIInventory>> recipes = recipeManager.getRecipes(RP2RecipeTypes.RECIPE_ALLOY_FURNACE);
        for (Map.Entry<ResourceLocation, IRecipe<FalseIInventory>> entry : recipes.entrySet()) {
            addRecipe((RP2Recipe) entry.getValue(), BaseMachineRecipe.RecipeType.STANDARD);
        }
    }
    // endregion

    // region WRAPPER CLASS
    protected static class AlloyFurnaceMapWrapper {

        Set<Integer> itemHashes;
        int hashCode;

        AlloyFurnaceMapWrapper(List<ComparableItemStack> itemStacks) {

            this.itemHashes = new ObjectOpenHashSet<>(itemStacks.size());
            for (ComparableItemStack itemStack : itemStacks) {
                if (itemStack.hashCode() != 0) {
                    this.itemHashes.add(itemStack.hashCode());
                    hashCode += itemStack.hashCode();
                }
            }
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            AlloyFurnaceMapWrapper that = (AlloyFurnaceMapWrapper) o;
            return itemHashes.size() == that.itemHashes.size() && itemHashes.containsAll(that.itemHashes);
        }

        @Override
        public int hashCode() {

            return hashCode;
        }

    }
    // endregion
}