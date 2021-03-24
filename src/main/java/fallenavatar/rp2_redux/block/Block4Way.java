package fallenavatar.rp2_redux.block;

// Ripped straight from https://github.com/KingLemming/1.16/blob/master/CoFHCore/src/main/java/cofh/core/block/Block4Way.java
// Atleast until Lemming gets CofhCore ready for use

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

import javax.annotation.Nullable;

import static fallenavatar.rp2_redux.util.constants.Constants.FACING_HORIZONTAL;

public class Block4Way extends Block {

    public Block4Way(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING_HORIZONTAL);
        super.createBlockStateDefinition(builder);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).setValue(FACING_HORIZONTAL, context.getPlayer() != null ? context.getPlayer().getDirection().getOpposite() : Direction.NORTH);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING_HORIZONTAL, rot.rotate(state.getValue(FACING_HORIZONTAL)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.setValue(FACING_HORIZONTAL, mirrorIn.mirror(state.getValue(FACING_HORIZONTAL)));
    }

}