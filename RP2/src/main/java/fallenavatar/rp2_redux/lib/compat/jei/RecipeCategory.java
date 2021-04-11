package fallenavatar.rp2_redux.lib.compat.jei;

import fallenavatar.rp2_redux.core.util.recipes.RP2Recipe;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class RecipeCategory<T extends RP2Recipe> implements IRecipeCategory<T> {

    protected final int EXP_X = 20;
    protected final int EXP_Y = 10;

    protected final ResourceLocation uid;
    protected IDrawable background;
    protected IDrawable icon;
    protected ITextComponent name;

    protected IDrawableStatic progressBackground;
    protected IDrawableStatic speedBackground;

    protected IDrawableAnimated progress;
    protected IDrawableAnimated speed;

    public RecipeCategory(IGuiHelper guiHelper, ItemStack icon, ResourceLocation uid) {
        this.uid = uid;
        this.icon = guiHelper.createDrawableIngredient(icon);
    }

    protected void addDefaultItemTooltipCallback(IGuiItemStackGroup group, List<Float> chances, int indexOffset) {
        group.addTooltipCallback((slotIndex, input, ingredient, tooltip) -> {
            
        });
    }

    // region IRecipeCategory
    @Override
    public ResourceLocation getUid() {
        return uid;
    }

    @Override
    public String getTitle() {
        return name.getString();
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(T recipe, MatrixStack matrixStack, double mouseX, double mouseY) {

    }

    @Override
    public List<ITextComponent> getTooltipStrings(T recipe, double mouseX, double mouseY) {
        List<ITextComponent> tooltip = new ArrayList<>();

        return tooltip;
    }
    // endregion
}