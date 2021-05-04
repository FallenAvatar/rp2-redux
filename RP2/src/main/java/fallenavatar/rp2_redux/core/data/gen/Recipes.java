package fallenavatar.rp2_redux.core.data.gen;

import java.util.function.Consumer;

import fallenavatar.rp2_redux.core.init.RP2Blocks;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		// https://wiki.mcjty.eu/modding/index.php?title=Tut14_Ep7#Recipes
		// https://github.com/MinecraftForge/MinecraftForge/blob/1.14.x/src/test/java/net/minecraftforge/debug/DataGeneratorTest.java
    }
}
