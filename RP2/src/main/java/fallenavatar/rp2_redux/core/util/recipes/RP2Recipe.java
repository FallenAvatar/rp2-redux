package fallenavatar.rp2_redux.core.util.recipes;


import cofh.lib.util.recipes.SerializableRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public abstract class RP2Recipe extends SerializableRecipe {

    protected final List<Ingredient> inputItems = new ArrayList<>();
    protected final List<ItemStack> outputItems = new ArrayList<>();

    protected float xp;
	protected int energy;

    protected RP2Recipe(ResourceLocation recipeId, float xp, int energy, List<Ingredient> inputItems, List<ItemStack> outputItems) {
        super(recipeId);

        this.xp = Math.max(0.0F, xp);
		this.energy = energy;

        if (inputItems != null) {
            this.inputItems.addAll(inputItems);
        }
        if (outputItems != null) {
            this.outputItems.addAll(outputItems);
        }
        trim();
    }

    private void trim() {

        ((ArrayList<Ingredient>) this.inputItems).trimToSize();
        ((ArrayList<ItemStack>) this.outputItems).trimToSize();
    }

    // region GETTERS
	public int getEnergy() {

        return energy;
    }

    public List<Ingredient> getInputItems() {

        return inputItems;
    }

    public List<ItemStack> getOutputItems() {

        return outputItems;
    }

    public float getXp() {

        return xp;
    }
    // endregion
}
