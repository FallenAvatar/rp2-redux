package fallenavatar.rp2_redux.lib.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

import javax.annotation.Nullable;

import com.google.common.base.Supplier;

import static fallenavatar.rp2_redux.core.util.constants.Constants.FACING_HORIZONTAL;

public class TileBlock4Way<T extends TileEntity> extends TileBlock<T> {
	public TileBlock4Way(Properties properties, Supplier<T> tileSup) {
		super(properties, tileSup);
	}
	
	@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
		builder.add(FACING_HORIZONTAL);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(FACING_HORIZONTAL, context.getPlayer() != null ? context.getPlayer().getAdjustedHorizontalFacing().getOpposite() : Direction.NORTH);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING_HORIZONTAL, rot.rotate(state.get(FACING_HORIZONTAL)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING_HORIZONTAL)));
    }
}
