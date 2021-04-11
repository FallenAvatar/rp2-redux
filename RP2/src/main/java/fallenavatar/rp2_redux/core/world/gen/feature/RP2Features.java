package fallenavatar.rp2_redux.core.world.gen.feature;

import static fallenavatar.rp2_redux.core.RP2ReduxMod.BLOCKS;
import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_COPPER;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_GREEN_SAPPHIRE;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_NIKOLITE;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_RUBY;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_SAPPHIRE;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_SILVER;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_TIN;
import static fallenavatar.rp2_redux.core.common.RP2IDs.ID_TUNGSTEN;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;

public class RP2Features {
	private RP2Features() {
	}

	private static ConfiguredFeature<?,?> registerOre(String name, int size, int depth_start, int depth_range, int count) {
		return register("ore_"+name, new ConfiguredFeature<>(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLOCKS.get(name + "_ore").getDefaultState(), size))
								.withPlacement(Placement.DEPTH_AVERAGE.configure(depthRange(depth_start, depth_range))).square().func_242731_b(count));
	}

	public static void setup() {
		ORE_COPPER = registerOre(ID_COPPER, 16, 32, 20, 12);
		ORE_TIN = registerOre(ID_TIN, 8, 40, 14, 4);
		ORE_SILVER = registerOre(ID_SILVER, 6, 16, 16, 2);
		ORE_TUNGSTEN = registerOre(ID_TUNGSTEN, 2, 8, 8, 1);
		ORE_NIKOLITE = registerOre(ID_NIKOLITE, 6, 10, 8, 4);
		ORE_GREEN_SAPPHIRE = registerOre(ID_GREEN_SAPPHIRE, 6, 10, 8, 1);
		ORE_RUBY = registerOre(ID_RUBY, 3, 8, 8, 3);
		ORE_SAPPHIRE = registerOre(ID_SAPPHIRE, 3, 14, 8, 2);
	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(ID_RP2_REDUX, key), configuredFeature);
	}

	private static DepthAverageConfig depthRange(int base, int spread) {
		return new DepthAverageConfig(base, spread);
	}

	/*private static TopSolidRangeConfig topRange(int min, int max) {
		return new TopSolidRangeConfig(min, min, max);
	}*/

	public static ConfiguredFeature<?, ?> ORE_COPPER;
	public static ConfiguredFeature<?, ?> ORE_TIN;
	public static ConfiguredFeature<?, ?> ORE_SILVER;
	public static ConfiguredFeature<?, ?> ORE_TUNGSTEN;
	public static ConfiguredFeature<?, ?> ORE_NIKOLITE;

	public static ConfiguredFeature<?, ?> ORE_GREEN_SAPPHIRE;
	public static ConfiguredFeature<?, ?> ORE_RUBY;
	public static ConfiguredFeature<?, ?> ORE_SAPPHIRE;
}
