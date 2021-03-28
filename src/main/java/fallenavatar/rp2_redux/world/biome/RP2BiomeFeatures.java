package fallenavatar.rp2_redux.world.biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import static fallenavatar.rp2_redux.world.gen.feature.RP2Features.*;

public class RP2BiomeFeatures {
	private RP2BiomeFeatures() {}

	public static void addOreGeneration(BiomeLoadingEvent event) {

        BiomeGenerationSettingsBuilder generationSettingsBuilder = event.getGeneration();
        Biome.Category category = event.getCategory();

        if (isOverworldBiome(category)) {
            withCopperOre(generationSettingsBuilder);
			withTinOre(generationSettingsBuilder);
			withSilverOre(generationSettingsBuilder);
			withTungstenOre(generationSettingsBuilder);
			withNikoliteOre(generationSettingsBuilder);

			withGreenSapphireOre(generationSettingsBuilder);
			withRubyOre(generationSettingsBuilder);
			withSapphireOre(generationSettingsBuilder);
        }
    }

    // region ORES
    public static void withCopperOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_COPPER);
    }

	public static void withTinOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_TIN);
    }

	public static void withSilverOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_SILVER);
    }

	public static void withTungstenOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_TUNGSTEN);
    }

	public static void withNikoliteOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_NIKOLITE);
    }

	public static void withGreenSapphireOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_GREEN_SAPPHIRE);
    }

	public static void withRubyOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_RUBY);
    }

	public static void withSapphireOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_SAPPHIRE);
    }
    // endregion

    // region HELPERS
    public static boolean isOverworldBiome(Biome.Category category) {

        return category != Biome.Category.NONE && category != Biome.Category.THEEND && category != Biome.Category.NETHER;
    }

    public static boolean isNetherBiome(Biome.Category category) {

        return category == Biome.Category.NETHER;
    }
    // endregion
}
