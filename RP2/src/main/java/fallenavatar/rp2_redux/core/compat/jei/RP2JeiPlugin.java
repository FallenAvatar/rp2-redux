package fallenavatar.rp2_redux.core.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;
import static fallenavatar.rp2_redux.core.init.RP2RecipeTypes.ID_RECIPE_ALLOY_FURNACE;
import static fallenavatar.rp2_redux.core.init.RP2RecipeTypes.RECIPE_ALLOY_FURNACE;
import static fallenavatar.rp2_redux.core.init.RP2References.ALLOY_FURNACE;
import static fallenavatar.rp2_redux.core.init.RP2References.PROJECT_TABLE;

import fallenavatar.rp2_redux.core.client.gui.AlloyFurnaceScreen;
import fallenavatar.rp2_redux.core.compat.jei.machine.AlloyFurnaceRecipeCategory;

@JeiPlugin
public class RP2JeiPlugin implements IModPlugin {

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        RecipeManager recipeManager = getRecipeManager();
        if (recipeManager == null) {
            // TODO: Log an error.
            return;
        }

        registration.addRecipes(recipeManager.getRecipes(RECIPE_ALLOY_FURNACE).values(), ID_RECIPE_ALLOY_FURNACE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloyFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ALLOY_FURNACE), ID_RECIPE_ALLOY_FURNACE));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloyFurnaceScreen.class, 107, 34, 24, 16, ID_RECIPE_ALLOY_FURNACE);
    }

	@Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ALLOY_FURNACE), ID_RECIPE_ALLOY_FURNACE);
		registration.addRecipeCatalyst(new ItemStack(PROJECT_TABLE), VanillaRecipeCategoryUid.CRAFTING);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ID_RP2_REDUX, "jei");
    }

    // region HELPERS
    private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
        ClientWorld world = Minecraft.getInstance().world;
        if (world != null) {
            recipeManager = world.getRecipeManager();
        }
        return recipeManager;
    }
    // endregion
}
