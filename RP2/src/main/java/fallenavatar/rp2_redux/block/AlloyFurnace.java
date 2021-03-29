package fallenavatar.rp2_redux.block;

import javax.annotation.Nullable;

import fallenavatar.rp2_redux.tileentity.AlloyFurnaceTile;

// Ripped straight from https://github.com/KingLemming/1.16/blob/master/CoFHCore/src/main/java/cofh/core/block/Block4Way.java
// Atleast until Lemming gets CofhCore ready for use

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class AlloyFurnace extends Block4Way {

	public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public AlloyFurnace(Properties properties) {
        super(properties);
		this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LIT);
        super.fillStateContainer(builder);
    }

	@Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(LIT, false);
    }

	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

	@Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new AlloyFurnaceTile();
    }
}