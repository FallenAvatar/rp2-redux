package fallenavatar.rp2_redux.core.event;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod; 
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.common.data.ExistingFileHelper;


import fallenavatar.rp2_redux.core.data.gen.client.BlockStateGen;
import fallenavatar.rp2_redux.core.data.gen.client.ItemModelGen;
import fallenavatar.rp2_redux.core.data.gen.client.LangGen;
import fallenavatar.rp2_redux.core.data.gen.server.BlockTagGen;
import fallenavatar.rp2_redux.core.data.gen.server.ItemTagGen;
import fallenavatar.rp2_redux.core.data.gen.server.LootTableGen;
import fallenavatar.rp2_redux.core.data.gen.server.RecipeGen;


import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;


@Mod.EventBusSubscriber(modid = ID_RP2_REDUX, bus = Bus.MOD)
public class DataGen {
	@SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
		ExistingFileHelper efh = e.getExistingFileHelper();

        if( e.includeServer() )
			gatherServerData(gen, efh);
		if( e.includeClient() )
			gatherClientData(gen, efh);
    }

	protected static void gatherServerData(DataGenerator gen, ExistingFileHelper efh) {
		BlockTagGen btg = new BlockTagGen(gen, efh);
		gen.addProvider(btg);
		gen.addProvider(new ItemTagGen(gen, efh, btg));

		gen.addProvider(new RecipeGen(gen));
        gen.addProvider(new LootTableGen(gen));
	}

	protected static void gatherClientData(DataGenerator gen, ExistingFileHelper efh) {
		gen.addProvider(new BlockStateGen(gen, efh));
		gen.addProvider(new ItemModelGen(gen, efh));

		gen.addProvider(new LangGen(gen));
	}
}
