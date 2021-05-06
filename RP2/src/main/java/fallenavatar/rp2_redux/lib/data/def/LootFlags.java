package fallenavatar.rp2_redux.lib.data.def;

import java.util.EnumSet;

public enum LootFlags {
	ExplosionResistant, FortuneAffected, SilkTouchRequired;

	public static final EnumSet<LootFlags> None = EnumSet.noneOf(LootFlags.class);
	public static final EnumSet<LootFlags> All = EnumSet.allOf(LootFlags.class);
}
