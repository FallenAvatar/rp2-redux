package fallenavatar.rp2_redux.lib.data.gen.server;


import java.util.function.Consumer;


import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;


public abstract class BaseRecipeGen extends RecipeProvider {
	public BaseRecipeGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		// https://wiki.mcjty.eu/modding/index.php?title=Tut14_Ep7#Recipes
		// https://github.com/MinecraftForge/MinecraftForge/blob/1.14.x/src/test/java/net/minecraftforge/debug/DataGeneratorTest.java
    }
}
