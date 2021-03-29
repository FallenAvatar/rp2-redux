package fallenavatar.rp2_redux.world.gen.feature;

// https://github.com/KingLemming/1.16/blob/dev/ThermalCore/src/main/java/cofh/thermal/core/world/gen/feature/ThermalFeatures.java

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

import static fallenavatar.rp2_redux.common.Constants.*;
import static fallenavatar.rp2_redux.common.RP2IDs.*;

import static fallenavatar.rp2_redux.RP2ReduxMod.BLOCKS;

public class RP2Features {
	private RP2Features() {
	}

	public static void setup() {
		ORE_COPPER = register("ore_copper", Feature.ORE.configure(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BLOCKS.get(ID_COPPER + "_ore").defaultBlockState(), 16))
								.decorated(Placement.DEPTH_AVERAGE.configure(depthRange(32, 20))).squared().count(12));

		ORE_TIN = register("ore_tin",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_TIN + "_ore").defaultBlockState(), 8))
										.decorated(Placement.DEPTH_AVERAGE.configure(depthRange(40, 14))).squared()
										.count(4));

		ORE_SILVER = register("ore_silver",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_SILVER + "_ore").defaultBlockState(), 6))
										.decorated(Placement.DEPTH_AVERAGE.configure(depthRange(16, 16))).squared()
										.count(2));

		ORE_TUNGSTEN = register("ore_tungsten",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_TUNGSTEN + "_ore").defaultBlockState(), 2))
										.decorated(Placement.DEPTH_AVERAGE.configured(depthRange(8, 8))).squared()
										.count(1));

		ORE_NIKOLITE = register("ore_nikolite",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_NIKOLITE + "_ore").defaultBlockState(), 6))
										.decorated(Placement.DEPTH_AVERAGE.configured(depthRange(10, 8))).squared()
										.count(4));

		ORE_GREEN_SAPPHIRE = register("ore_green_sapphire",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_GREEN_SAPPHIRE + "_ore").defaultBlockState(), 6))
										.decorated(Placement.DEPTH_AVERAGE.configured(depthRange(10, 8))).squared()
										.count(1));

		ORE_RUBY = register("ore_ruby",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_RUBY + "_ore").defaultBlockState(), 3))
										.decorated(Placement.DEPTH_AVERAGE.configured(depthRange(8, 8))).squared()
										.count(3));

		ORE_SAPPHIRE = register("ore_sapphire",
				new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BLOCKS.get(ID_SAPPHIRE + "_ore").defaultBlockState(), 3))
										.decorated(Placement.DEPTH_AVERAGE.configured(depthRange(14, 8))).squared()
										.count(2));

	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(ID_RP2_REDUX, key), configuredFeature);
	}

	private static DepthAverageConfig depthRange(int base, int spread) {
		return new DepthAverageConfig(base, spread);
	}

	private static TopSolidRangeConfig topRange(int min, int max) {
		return new TopSolidRangeConfig(min, min, max);
	}

	public static ConfiguredFeature<?, ?> ORE_COPPER;
	public static ConfiguredFeature<?, ?> ORE_TIN;
	public static ConfiguredFeature<?, ?> ORE_SILVER;
	public static ConfiguredFeature<?, ?> ORE_TUNGSTEN;
	public static ConfiguredFeature<?, ?> ORE_NIKOLITE;

	public static ConfiguredFeature<?, ?> ORE_GREEN_SAPPHIRE;
	public static ConfiguredFeature<?, ?> ORE_RUBY;
	public static ConfiguredFeature<?, ?> ORE_SAPPHIRE;
}
