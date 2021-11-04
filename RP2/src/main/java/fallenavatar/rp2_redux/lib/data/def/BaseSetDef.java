package fallenavatar.rp2_redux.lib.data.def;

import fallenavatar.rp2_redux.lib.BaseModInfo;

public abstract class BaseSetDef {
	protected BaseModInfo modInfo;
	public BaseModInfo getModInfo() { return modInfo; }

	protected BaseSetDef(BaseModInfo mi) {
		modInfo = mi;
	}

	public abstract void Register();
}
