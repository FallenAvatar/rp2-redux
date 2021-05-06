package fallenavatar.rp2_redux.lib.data.gen.client;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import static net.minecraft.block.AbstractBlock.Properties.from;


import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import fallenavatar.rp2_redux.lib.data.def.BaseBlockDef;


public abstract class BaseBlockStateGen extends BlockStateProvider {
	public BaseBlockStateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ID_RP2_REDUX, exFileHelper);
    }

	public void genBlock(BaseBlockDef block) {
		block.GenData(this);
	}
}
