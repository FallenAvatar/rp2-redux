package fallenavatar.rp2_redux.common;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import static fallenavatar.rp2_redux.RP2ReduxMod.ITEMS;
import static fallenavatar.rp2_redux.common.RP2IDs.*;

public class RP2ItemTiers {
	private RP2ItemTiers() {}

	public static final IItemTier MATERIAL_RUBY = new IItemTier() {
        @Override
        public int getMaxUses() { return 800; }

        @Override
        public float getEfficiency() { return 7F; }

        @Override
        public float getAttackDamage() { return 1.0F; }

        @Override
        public int getHarvestLevel() { return 3; }

        @Override
        public int getEnchantability() { return 16; }

        @Override
        public Ingredient getRepairMaterial() { return Ingredient.fromItems(ITEMS.get(ID_RUBY)); }
    };

	public static final IItemTier MATERIAL_GREEN_SAPPHIRE = new IItemTier() {
        @Override
        public int getMaxUses() { return 800; }

        @Override
        public float getEfficiency() { return 7F; }

        @Override
        public float getAttackDamage() { return 1.0F; }

        @Override
        public int getHarvestLevel() { return 3; }

        @Override
        public int getEnchantability() { return 16; }

        @Override
        public Ingredient getRepairMaterial() { return Ingredient.fromItems(ITEMS.get(ID_GREEN_SAPPHIRE)); }
    };

	public static final IItemTier MATERIAL_SAPPHIRE = new IItemTier() {
        @Override
        public int getMaxUses() { return 800; }

        @Override
        public float getEfficiency() { return 7F; }

        @Override
        public float getAttackDamage() { return 1.0F; }

        @Override
        public int getHarvestLevel() { return 3; }

        @Override
        public int getEnchantability() { return 16; }

        @Override
        public Ingredient getRepairMaterial() { return Ingredient.fromItems(ITEMS.get(ID_SAPPHIRE)); }
    };
}
