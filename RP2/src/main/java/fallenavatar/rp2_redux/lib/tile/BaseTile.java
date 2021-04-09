package fallenavatar.rp2_redux.lib.tile;

import java.util.Random;

import javax.annotation.Nullable;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.tileentity.ITileCallback;
import cofh.lib.tileentity.ITilePacketHandler;
import cofh.lib.util.IConveyableData;
import fallenavatar.rp2_redux.lib.network.packet.client.TileGuiPacket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class BaseTile extends TileEntity implements ITileCallback, ITilePacketHandler, IConveyableData {
	// region Fields
	protected int numPlayersUsing;
	public int getPlayersUsing() { return numPlayersUsing; }
    public void addPlayerUsing() { ++numPlayersUsing; }
    public void removePlayerUsing() { --numPlayersUsing; }
	// endregion

	public BaseTile(TileEntityType<?> teType) {
        super(teType);
    }

    public void receiveGuiNetworkData(int id, int data) {}

    public void sendGuiNetworkData(Container container, IContainerListener player) {
        if (hasGuiPacket() && player instanceof ServerPlayerEntity && (!(player instanceof FakePlayer))) {
            TileGuiPacket.sendToClient(this, (ServerPlayerEntity) player);
        }
    }

	// region HELPERS
    public BaseTile worldContext(BlockState state, IBlockReader world) { return this; }

    public boolean onActivatedDelegate(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        return getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).map(handler -> FluidHelper.interactWithHandler(player.getHeldItem(hand), handler, player, hand)).orElse(false);
    }

    public boolean hasClientUpdate() { return false; }

    public boolean hasGuiPacket() { return true; }

    public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {}

    protected Object getSound() { return null; }
    // endregion

	// region NETWORK
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 0, getUpdateTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        read(this.cachedBlockState, pkt.getNbtCompound());
    }
    // endregion

	// region ITileCallback
    @Override
    public Block block() {
        return getBlockState().getBlock();
    }

    @Override
    public BlockState state() {
        return getBlockState();
    }

    @Override
    public BlockPos pos() {
        return pos;
    }

    @Override
    public World world() {
        return world;
    }
    // endregion
}
