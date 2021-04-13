package fallenavatar.rp2_redux.lib.util;

// Ripped straight from https://github.com/KingLemming/1.16/blob/master/CoFHCore/src/main/java/cofh/core/util/constants/Constants.java
// Atleast until Lemming gets CofhCore ready for use

import java.util.UUID;
import com.google.common.base.Supplier;

import io.netty.util.BooleanSupplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Plane;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;

import static net.minecraft.inventory.EquipmentSlotType.*;

public class Constants {
	private Constants() {}

	// region MOD IDS
	public static final String ID_MINECRAFT = "minecraft";
    public static final String ID_FORGE = "forge";

    public static final String ID_COFH_CORE = "cofh_core";
	
	public static final String ID_RP2_REDUX = "rp2_redux";
	// endregion

	// region BLOCKSTATE PROPERTIES
    public static final DirectionProperty FACING_ALL = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
    public static final DirectionProperty FACING_HORIZONTAL = DirectionProperty.create("facing", Plane.HORIZONTAL);
	public static final DirectionProperty TWIST = DirectionProperty.create("twist", Plane.HORIZONTAL);
    // endregion

	// region GLOBALS
    public static final int AOE_BREAK_FACTOR = 8;
    public static final int BOTTLE_VOLUME = FluidAttributes.BUCKET_VOLUME / 4;
    public static final int BUCKET_VOLUME = FluidAttributes.BUCKET_VOLUME;
    public static final int ENTITY_TRACKING_DISTANCE = 64;
    public static final int ITEM_TIMER_DURATION = 40;
    public static final int MAX_CAPACITY = Integer.MAX_VALUE;
    public static final int MB_PER_XP = 20;
    public static final int NETWORK_UPDATE_DISTANCE = 192;
    public static final int RF_PER_FURNACE_UNIT = 10;

    public static final float BASE_CHANCE = 1.0F;
    public static final float BASE_CHANCE_LOCKED = -1.0F;

    public static final int TANK_SMALL = BUCKET_VOLUME * 4;
    public static final int TANK_MEDIUM = BUCKET_VOLUME * 8;
    public static final int TANK_LARGE = BUCKET_VOLUME * 16;

    public static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{HEAD, CHEST, LEGS, FEET};
    public static final Direction[] DIRECTIONS = Direction.values();
    // endregion

	// region CONSTANTS
    public static final BooleanSupplier TRUE = () -> true;
    public static final BooleanSupplier FALSE = () -> false;

    public static final Supplier<FluidStack> EMPTY_FLUID = () -> FluidStack.EMPTY;

    public static final String DAMAGE_ARROW = "arrow";
    public static final String DAMAGE_PLAYER = "player";

    public static final UUID UUID_ARMOR_TOUGHNESS = UUID.fromString("D1ADBCE5-95CE-470C-BF99-6C59843084A2");
    // endregion

    // region TEXTURES
    public static final String PATH_GFX = ID_RP2_REDUX + ":textures/";
    public static final String PATH_GUI = PATH_GFX + "gui/";
    public static final String PATH_ELEMENTS = PATH_GUI + "elements/";
    // endregion
}
