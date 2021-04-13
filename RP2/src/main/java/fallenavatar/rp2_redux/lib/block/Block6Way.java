package fallenavatar.rp2_redux.lib.block;

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

import static fallenavatar.rp2_redux.lib.util.Constants.FACING_ALL;

public class Block6Way extends Block {

    public Block6Way(Properties properties) {
        super(properties);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
		builder.add(FACING_ALL);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING_ALL, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING_ALL, rot.rotate(state.get(FACING_ALL)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING_ALL)));
    }

}