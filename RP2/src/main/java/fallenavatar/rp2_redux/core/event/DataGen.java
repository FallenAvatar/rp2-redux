package fallenavatar.rp2_redux.core.event;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod; 
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import fallenavatar.rp2_redux.core.data.gen.Recipes;


@Mod.EventBusSubscriber(modid = ID_RP2_REDUX, bus = Bus.MOD)
public class DataGen {
	@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new Recipes(generator));
        generator.addProvider(new LootTables(generator));
    }
}
