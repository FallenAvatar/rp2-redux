package fallenavatar.rp2_redux.compat.jei.machine;

import cofh.thermal.lib.compat.jei.ThermalRecipeCategory;
import fallenavatar.rp2_redux.client.gui.AlloyFurnaceScreen;
import fallenavatar.rp2_redux.util.recipes.AlloyFurnaceRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static fallenavatar.rp2_redux.init.RP2References.ALLOY_FURNACE;

public class AlloyFurnaceRecipeCategory extends ThermalRecipeCategory<AlloyFurnaceRecipe> {

    public AlloyFurnaceRecipeCategory(IGuiHelper guiHelper, ItemStack icon, ResourceLocation uid) {

        super(guiHelper, icon, uid);

        background = guiHelper.drawableBuilder(AlloyFurnaceScreen.TEXTURE, 26, 11, 140, 62)
                .addPadding(0, 0, 16, 8)
                .build();
        name = getTextComponent(ALLOY_FURNACE.getTranslationKey());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLAME);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW), 200, IDrawableAnimated.StartDirection.LEFT, false);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLAME), 400, IDrawableAnimated.StartDirection.TOP, true);
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

        

		/* addSlot(new SlotCoFH(tileInv, 0, 17, 42));
		addSlot(new SlotRemoveOnly(tileInv, 1, 142, 36));

		for( int i=0; i<9; i++ ) {
			addSlot(new SlotCoFH(tileInv, 2+i, 48+((i%3)*18), 17+((i/3)*18)));
		} */

		guiItemStacks.init(0, true, 17, 42);
		guiItemStacks.init(1, false, 142, 36);

		for( int i=0; i<9; i++ ) {
			guiItemStacks.init(2+i, true, 48+((i%3)*18), 17+((i/3)*18));
		}

		guiItemStacks.set(0, inputs.get(0));
		guiItemStacks.set(1, outputs.get(i));
        for (int i = 0; i < inputs.size(); ++i) {
            guiItemStacks.set(2+i, inputs.get(i+1));
        }
		
        //addCatalyzedItemTooltipCallback(guiItemStacks, recipe.getOutputItemChances(), 4);
    }

    @Override
    public void draw(AlloyFurnaceRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {

        super.draw(recipe, matrixStack, mouseX, mouseY);

        progressBackground.draw(matrixStack, 84, 23);
        speedBackground.draw(matrixStack, 43, 24);

        progress.draw(matrixStack, 84, 23);
        speed.draw(matrixStack, 43, 24);
    }

}
