package fallenavatar.rp2_redux.core.init;



import java.util.AbstractMap.SimpleEntry;
import java.util.Map;



import fallenavatar.rp2_redux.lib.data.def.BaseThingyDef;
import fallenavatar.rp2_redux.lib.data.def.BaseItemDef;
import fallenavatar.rp2_redux.lib.data.def.BaseSetDef;
import fallenavatar.rp2_redux.lib.data.def.BaseBlockDef;
import fallenavatar.rp2_redux.core.RP2ReduxMod;
import fallenavatar.rp2_redux.core.data.def.block.*;
import fallenavatar.rp2_redux.core.data.def.set.Ruby;



public class RP2Thingys {
	private RP2Thingys() {}



	public static final Map<String, BaseBlockDef> Blocks = Map.ofEntries(
		makeEntry(Basalt.class),
		makeEntry(Marble.class)
	);

	public static final Map<String, BaseItemDef> Items = Map.ofEntries(
	);

	public static final Map<String, BaseSetDef> Set = Map.ofEntries(
		makeSimpleEntry(Ruby.class)
	);



	public static void register() {
		for(Map.Entry<String, BaseSetDef> e : Set.entrySet()) {
			e.getValue().Register();
		}

		register(Items);
		register(Blocks);
	}

	private static <A extends BaseThingyDef> void register(final Map<String, A> map) {
		for(Map.Entry<String, A> e : map.entrySet()) {
			e.getValue().Register();
		}
	}

	private static <A extends BaseThingyDef> Map.Entry<String, A> makeEntry(Class<?> clazz) {
		A b = null;

		try {
			b = ((A)clazz.getConstructor().newInstance());
		} catch( Exception e ) {
			RP2ReduxMod.LOG.error("Error instantiating Thingy ["+clazz.getName()+"]. Expecting a parameter-less constructor. Exception says "+e.getMessage());
		}

		return new SimpleEntry<>(clazz.getName(), b);
	}

	private static <A> Map.Entry<String, A> makeSimpleEntry(Class<?> clazz) {
		A b = null;

		try {
			b = ((A)clazz.getConstructor().newInstance());
		} catch( Exception e ) {
			RP2ReduxMod.LOG.error("Error instantiating Thingy ["+clazz.getName()+"]. Expecting a parameter-less constructor. Exception says "+e.getMessage());
		}

		return new SimpleEntry<>(clazz.getName(), b);
	}
}
