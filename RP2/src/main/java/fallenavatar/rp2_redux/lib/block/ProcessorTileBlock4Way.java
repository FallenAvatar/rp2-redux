package fallenavatar.rp2_redux.lib.block;

import javax.annotation.Nullable;

import com.google.common.base.Supplier;

import fallenavatar.rp2_redux.lib.common.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public abstract class ProcessorTileBlock4Way<T extends TileEntity> extends TileBlock4Way<T> {
	public static final BooleanProperty ACTIVE = Props.ACTIVE;

	public ProcessorTileBlock4Way(Properties properties, Supplier<T> tileSup) {
		super(properties, tileSup);
		this.setDefaultState(this.getDefaultState().with(ACTIVE, false));
	}

	@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(ACTIVE);
        super.fillStateContainer(builder);
    }

	@Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(ACTIVE, false);
    }

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent(this.getBlock().getTranslationKey());
	}
}
