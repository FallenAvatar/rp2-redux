package fallenavatar.rp2_redux.core.world.biome;

import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_COPPER;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_GREEN_SAPPHIRE;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_NIKOLITE;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_RUBY;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_SAPPHIRE;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_SILVER;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_TIN;
import static fallenavatar.rp2_redux.core.world.gen.feature.RP2Features.ORE_TUNGSTEN;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

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
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_COPPER);
    }

	public static void withTinOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_TIN);
    }

	public static void withSilverOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_SILVER);
    }

	public static void withTungstenOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_TUNGSTEN);
    }

	public static void withNikoliteOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_NIKOLITE);
    }

	public static void withGreenSapphireOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_GREEN_SAPPHIRE);
    }

	public static void withRubyOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_RUBY);
    }

	public static void withSapphireOre(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_SAPPHIRE);
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
