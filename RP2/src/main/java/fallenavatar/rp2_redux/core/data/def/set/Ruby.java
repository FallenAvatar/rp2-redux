package fallenavatar.rp2_redux.core.data.def.set;

import fallenavatar.rp2_redux.core.RP2ReduxMod;
import fallenavatar.rp2_redux.lib.data.def.GemSetDef;

public class Ruby extends GemSetDef {
	public static final String CATEGORY = "world";
	public static final String BASE_ID = "ruby";
	public static final String BASE_NAME = "Ruby";

	public Ruby() {
		super(RP2ReduxMod.ModInfo, CATEGORY, BASE_ID, BASE_NAME);
	}
}
