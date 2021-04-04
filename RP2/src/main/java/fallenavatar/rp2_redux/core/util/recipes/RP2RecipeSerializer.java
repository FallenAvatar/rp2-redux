package fallenavatar.rp2_redux.core.util.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static cofh.lib.util.recipes.RecipeJsonUtils.*;

public class RP2RecipeSerializer<T extends RP2Recipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
    protected final IFactory<T> factory;

    public RP2RecipeSerializer(IFactory<T> factory) {

        this.factory = factory;
    }

    @Override
    public T read(ResourceLocation recipeId, JsonObject json) {

        float experience = 0.0F;

        ArrayList<Ingredient> inputItems = new ArrayList<>();
        ArrayList<FluidStack> inputFluids = new ArrayList<>();
        ArrayList<ItemStack> outputItems = new ArrayList<>();
        ArrayList<Float> outputItemChances = new ArrayList<>();
        ArrayList<FluidStack> outputFluids = new ArrayList<>();

        /* INPUT */
        if (json.has(INGREDIENT)) {
            parseInputs(inputItems, inputFluids, json.get(INGREDIENT));
        } else if (json.has(INGREDIENTS)) {
            parseInputs(inputItems, inputFluids, json.get(INGREDIENTS));
        } else if (json.has(INPUT)) {
            parseInputs(inputItems, inputFluids, json.get(INPUT));
        } else if (json.has(INPUTS)) {
            parseInputs(inputItems, inputFluids, json.get(INPUTS));
        }

        /* OUTPUT */
        if (json.has(RESULT)) {
            parseOutputs(outputItems, outputItemChances, outputFluids, json.get(RESULT));
        } else if (json.has(RESULTS)) {
            parseOutputs(outputItems, outputItemChances, outputFluids, json.get(RESULTS));
        } else if (json.has(OUTPUT)) {
            parseOutputs(outputItems, outputItemChances, outputFluids, json.get(OUTPUT));
        } else if (json.has(OUTPUTS)) {
            parseOutputs(outputItems, outputItemChances, outputFluids, json.get(OUTPUTS));
        }

        /* XP */
        if (json.has(EXPERIENCE)) {
            experience = json.get(EXPERIENCE).getAsFloat();
        } else if (json.has(XP)) {
            experience = json.get(XP).getAsFloat();
        }
        return factory.create(recipeId, experience, inputItems, outputItems);
    }

    @Nullable
    @Override
    public T read(ResourceLocation recipeId, PacketBuffer buffer) {

        float experience = buffer.readFloat();

        int numInputItems = buffer.readVarInt();
        ArrayList<Ingredient> inputItems = new ArrayList<>(numInputItems);
        for (int i = 0; i < numInputItems; ++i) {
            inputItems.add(Ingredient.read(buffer));
        }

        int numOutputItems = buffer.readVarInt();
        ArrayList<ItemStack> outputItems = new ArrayList<>(numOutputItems);
        for (int i = 0; i < numOutputItems; ++i) {
            outputItems.add(buffer.readItemStack());
        }

        return factory.create(recipeId, experience, inputItems, outputItems);
    }

    @Override
    public void write(PacketBuffer buffer, T recipe) {
        buffer.writeFloat(recipe.xp);

        int numInputItems = recipe.inputItems.size();
        buffer.writeVarInt(numInputItems);
        for (int i = 0; i < numInputItems; ++i) {
            recipe.inputItems.get(i).write(buffer);
        }
        int numOutputItems = recipe.outputItems.size();
        buffer.writeVarInt(numOutputItems);
        for (int i = 0; i < numOutputItems; ++i) {
            buffer.writeItemStack(recipe.outputItems.get(i));
        }
    }

    public interface IFactory<T extends RP2Recipe> {

        T create(ResourceLocation recipeId, float experience, List<Ingredient> inputItems, List<ItemStack> outputItems);

    }

}
