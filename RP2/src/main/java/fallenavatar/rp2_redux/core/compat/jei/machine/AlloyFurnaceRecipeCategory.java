package fallenavatar.rp2_redux.core.compat.jei.machine;

import cofh.thermal.lib.compat.jei.Drawables;
import fallenavatar.rp2_redux.core.client.gui.AlloyFurnaceScreen;
import fallenavatar.rp2_redux.lib.compat.jei.RecipeCategory;
import fallenavatar.rp2_redux.core.util.recipes.AlloyFurnaceRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static fallenavatar.rp2_redux.core.init.RP2References.ALLOY_FURNACE;

public class AlloyFurnaceRecipeCategory extends RecipeCategory<AlloyFurnaceRecipe> {

    public AlloyFurnaceRecipeCategory(IGuiHelper guiHelper, ItemStack icon, ResourceLocation uid) {
        super(guiHelper, icon, uid);

        background = guiHelper.drawableBuilder(AlloyFurnaceScreen.TEXTURE, 36, 11, 130, 62)
                .addPadding(0, 0, 26, 8)
                .build();
        name = getTextComponent(ALLOY_FURNACE.getTranslationKey());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLAME);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW), 200, IDrawableAnimated.StartDirection.LEFT, false);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLAME), 250, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public Class<? extends AlloyFurnaceRecipe> getRecipeClass() {
        return AlloyFurnaceRecipe.class;
    }

    @Override
    public void setIngredients(AlloyFurnaceRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getInputItems());
        ingredients.setOutputs(VanillaTypes.ITEM, recipe.getOutputItems());
    }

    @Override
    public void setRecipe(IRecipeLayout layout, AlloyFurnaceRecipe recipe, IIngredients ingredients) {
        List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
        List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);
        IGuiItemStackGroup guiItemStacks = layout.getItemStacks();

		for( int i=0; i<9; i++ ) {
			guiItemStacks.init(i, true, 37+((i%3)*18), 5+((i/3)*18));
		}

		guiItemStacks.init(10, false, 130, 22);

        for (int i = 0; i < inputs.size(); ++i) {
            guiItemStacks.set(i, inputs.get(i));
        }

		guiItemStacks.set(10, outputs.get(0));
    }

    @Override
    public void draw(AlloyFurnaceRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        super.draw(recipe, matrixStack, mouseX, mouseY);

        progressBackground.draw(matrixStack, 96, 23);
        speedBackground.draw(matrixStack, 8, 30);

        progress.draw(matrixStack, 96, 23);
        speed.draw(matrixStack, 8, 30);
    }

}
