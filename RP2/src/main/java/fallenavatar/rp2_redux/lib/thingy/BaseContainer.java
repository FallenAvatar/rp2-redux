package fallenavatar.rp2_redux.lib.thingy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fallenavatar.rp2_redux.lib.data.def.BaseBlockDef;
import fallenavatar.rp2_redux.lib.data.def.BaseThingyDef;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public abstract class BaseContainer {
	private static final Logger LOGGER = LogManager.getLogger();
	
	private final Map<String, BaseThingyDef> thingys = new HashMap<>();
	private Map<?, Supplier<RegistryBuilder<?>>> registryFactorys = new HashMap<>();

	protected BaseContainer() {}

	protected <T extends BaseThingyDef> void addThingy(Supplier<T> sup) {
		BaseThingyDef t = sup.get();

		thingys.put(t.getName(), t);
	}

	public void register(IEventBus bus) {
        bus.register(new BaseContainer.EventDispatcher(this));
    }

	public static class EventDispatcher {
        private final BaseContainer c;

        public EventDispatcher(final BaseContainer bc) {
            this.c = bc;
        }

        @SubscribeEvent
        public void handleEvent(RegistryEvent.Register<?> e) {
            c.addEntries(e);
        }
    }

	private void addEntries(RegistryEvent.Register<?> event) {
        /* if (this.type != null && event.getGenericType() == this.type.getRegistrySuperType()) {
            // this.seenRegisterEvent = true;
            @SuppressWarnings("unchecked")
            IForgeRegistry<T> reg = (IForgeRegistry<T>) event.getRegistry();
            for (Map.Entry<RegistryObject<T>, Supplier<? extends T>> e : entries.entrySet()) {
                reg.register(e.getValue().get());
                e.getKey().updateReference(reg);
            }
        } */
    }
}