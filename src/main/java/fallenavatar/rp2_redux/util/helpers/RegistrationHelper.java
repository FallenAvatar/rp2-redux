package fallenavatar.rp2_redux.util.helpers;

// Ripped straight from https://github.com/KingLemming/1.16/blob/master/ThermalCore/src/main/java/cofh/thermal/core/util/RegistrationHelper.java
// Atleast until Lemming gets CofhCore ready for use

import com.google.common.base.Supplier;

import io.netty.util.BooleanSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;
import static fallenavatar.rp2_redux.common.RP2ItemTiers.*;

import static fallenavatar.rp2_redux.util.constants.Constants.*;

import static fallenavatar.rp2_redux.RP2ReduxMod.BLOCKS;
import static fallenavatar.rp2_redux.RP2ReduxMod.ITEMS;

public class RegistrationHelper {
	private RegistrationHelper() {}

	 // region BLOCKS
	 public static void registerBlock(String name, Supplier<Block> sup) {
        registerBlock(name, sup, RP2_BLOCKS, Rarity.COMMON);
    }

    public static void registerBlock(String name, Supplier<Block> sup, Rarity rarity) {
        registerBlock(name, sup, RP2_BLOCKS, rarity);
    }

	public static void registerBlock(String name, Supplier<Block> sup, ItemGroup group) {
        registerBlock(name, sup, group, Rarity.COMMON);
    }

    public static void registerBlock(String name, Supplier<Block> sup, ItemGroup group, Rarity rarity) {
        registerBlockAndItem(name, sup, () -> new BlockItem(BLOCKS.get(name), new Item.Properties().tab(group).rarity(rarity)));
    }

    public static void registerBlockOnly(String name, Supplier<Block> sup) {
        BLOCKS.register(name, sup);
    }

    public static void registerBlockAndItem(String name, Supplier<Block> blockSup, Supplier<Item> itemSup) {
        BLOCKS.register(name, blockSup);
        ITEMS.register(name, itemSup);
    }
    // endregion

    // region ITEMS
	public static RegistryObject<Item> registerItem(String name) {
        return registerItem(name, RP2_ITEMS, Rarity.COMMON);
    }

    public static RegistryObject<Item> registerItem(String name, ItemGroup group) {
        return registerItem(name, group, Rarity.COMMON);
    }

    public static RegistryObject<Item> registerItem(String name, ItemGroup group, Rarity rarity) {
        return registerItem(name, () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
    }

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> sup) {
        return ITEMS.register(name, sup);
    }
    // endregion

    // region METAL SETS
	public static void registerMetalSet(String prefix) {
        registerMetalSet(prefix, RP2_ITEMS, Rarity.COMMON, false);
    }

    public static void registerMetalSet(String prefix, ItemGroup group) {
        registerMetalSet(prefix, group, Rarity.COMMON, false);
    }

	public static void registerMetalSet(String prefix, ItemGroup group, Rarity rarity) {
        registerMetalSet(prefix, group, rarity, false);
    }

    public static void registerMetalSet(String prefix, ItemGroup group, Rarity rarity, boolean vanilla) {

        if (!vanilla) {
            ITEMS.register(prefix + "_ingot", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
            ITEMS.register(prefix + "_nugget", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        }
        ITEMS.register(prefix + "_dust", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        ITEMS.register(prefix + "_gear", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        ITEMS.register(prefix + "_plate", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));

		ITEMS.register(prefix + "_block", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
    }
    // endregion

    // region GEM SETS
    public static void registerGemSet(String prefix) {
        registerGemSet(prefix, RP2_ITEMS, Rarity.COMMON, false);
    }

    public static void registerGemSet(String prefix, ItemGroup group) {
        registerGemSet(prefix, group, Rarity.COMMON, false);
    }

	public static void registerGemSet(String prefix, ItemGroup group, Rarity rarity) {
        registerGemSet(prefix, group, rarity, false);
    }

    public static void registerGemSet(String prefix, ItemGroup group, Rarity rarity, boolean vanilla) {
        if (!vanilla) {
            ITEMS.register(prefix, () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        }
        // ITEMS.register(prefix + "_nugget", () -> new ItemCoFH(new Item.Properties().tab(group).rarity(rarity)));
        ITEMS.register(prefix + "_dust", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        ITEMS.register(prefix + "_gear", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
        // ITEMS.register(prefix + "_plate", () -> new CountedItem(new Item.Properties().tab(group).rarity(rarity)));
        // ITEMS.register(prefix + "_coin", () -> new CoinItem(new Item.Properties().tab(group).rarity(rarity)));

		ITEMS.register(prefix + "_block", () -> new Item(new Item.Properties().tab(group).rarity(rarity)));
    }
    // endregion

    // region TOOL SETS
	public static void registerStandardToolSet(String prefix, IItemTier tier) {
		registerStandardToolSet(prefix, tier, true, false);
	}

	public static void registerStandardToolSet(String prefix, IItemTier tier, Boolean handsaw) {
		registerStandardToolSet(prefix, tier, handsaw, false);
	}

	public static void registerStandardToolSet(String prefix, IItemTier tier, Boolean handsaw, Boolean vanilla) {
		registerStandardToolSet(prefix, tier, RP2_TOOLS, RP2_COMBAT, handsaw, vanilla);
	}

    public static void registerStandardToolSet(String prefix, IItemTier tier, ItemGroup toolGroup, ItemGroup combatGroup, Boolean handsaw, Boolean vanilla) {
		if( !vanilla ) {
			ITEMS.register(prefix + "_shovel", () -> new ShovelItem(tier, 1.5F, -3.0F, new Item.Properties().tab(toolGroup)));
			ITEMS.register(prefix + "_pickaxe", () -> new PickaxeItem(tier, 1, -2.8F, new Item.Properties().tab(toolGroup)));
			ITEMS.register(prefix + "_axe", () -> new AxeItem(tier, tier.getAttackDamageBonus() > 0 ? 8.0F - tier.getAttackDamageBonus() : 6.0F, MathHelper.clamp(-3.7F + tier.getSpeed() / 10, -3.2F, -3.0F), new Item.Properties().tab(toolGroup)));
			ITEMS.register(prefix + "_hoe", () -> new HoeItem(tier, -tier.getLevel(), Math.min(-3.0F + tier.getLevel(), 0.0F), new Item.Properties().tab(toolGroup)));

			ITEMS.register(prefix + "_sword", () -> new SwordItem(tier, 3, -2.4F, new Item.Properties().tab(combatGroup)));
		}

		if( handsaw )
			ITEMS.register(prefix + "_handsaw", () -> new ShovelItem(tier, 3, -2.4F, new Item.Properties().tab(toolGroup)));

		ITEMS.register(prefix + "_sickle", () -> new ShovelItem(tier, 1.5F, -3.0F, new Item.Properties().tab(toolGroup)));
    }

    /* public static void registerExtraToolSet(String prefix, IItemTier tier, ItemGroup toolGroup) {

        ITEMS.register(prefix + "_excavator", () -> new ExcavatorItem(tier, new Item.Properties().tab(toolGroup)));
        ITEMS.register(prefix + "_hammer", () -> new HammerItem(tier, new Item.Properties().tab(toolGroup)));
        ITEMS.register(prefix + "_sickle", () -> new SickleItem(tier, new Item.Properties().tab(toolGroup)));
    }

    public static void registerSpecial(String prefix, IItemTier tier, ItemGroup toolGroup) {

        ITEMS.register(prefix + "_shears", () -> new ShearsItemCoFH(tier, new Item.Properties().tab(toolGroup)));
        ITEMS.register(prefix + "_bow", () -> new BowItemCoFH(tier, new Item.Properties().tab(toolGroup)));
        ITEMS.register(prefix + "_fishing_rod", () -> new FishingRodItemCoFH(tier, new Item.Properties().tab(toolGroup)));
    } */
    // endregion
}
