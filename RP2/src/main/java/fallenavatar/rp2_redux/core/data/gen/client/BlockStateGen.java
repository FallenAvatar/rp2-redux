package fallenavatar.rp2_redux.core.data.gen.client;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import fallenavatar.rp2_redux.core.init.RP2Thingys;
import fallenavatar.rp2_redux.lib.data.gen.client.BaseBlockStateGen;


public class BlockStateGen extends BaseBlockStateGen {
	public BlockStateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, exFileHelper);
    }

	@Override
    protected void registerStatesAndModels() {
        //genBlockState(RP2Thingys.Blocks.Basalt);
    }
}