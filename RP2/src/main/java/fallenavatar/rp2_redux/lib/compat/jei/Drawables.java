package fallenavatar.rp2_redux.lib.compat.jei;

import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

import static fallenavatar.rp2_redux.core.common.Constants.ID_RP2_REDUX;

public class Drawables {
	@Nullable
    private static Drawables instance;

    public static Drawables getDrawables(IGuiHelper guiHelper) {
        if (instance == null) {
            instance = new Drawables(guiHelper);
        }
        return instance;
    }

    public static final int SLOT = 0;
    public static final int SLOT_OUTPUT = 1;
    public static final int SLOT_DOUBLE = 2;

    public static final int PROGRESS_ARROW = 0;
    public static final int PROGRESS_ARROW_FLUID = 1;
    public static final int PROGRESS_DROP = 2;

    public static final int SCALE_ALCHEMY = 0;
    public static final int SCALE_BUBBLE = 1;
    public static final int SCALE_COMPACT = 2;
    public static final int SCALE_CRUSH = 3;
    public static final int SCALE_FLAME = 4;
    public static final int SCALE_FLAME_GREEN = 5;
    public static final int SCALE_FLUX = 6;
    public static final int SCALE_SAW = 7;
    public static final int SCALE_SPIN = 8;
    public static final int SCALE_SUN = 9;
    public static final int SCALE_SNOWFLAKE = 10;
    public static final int SCALE_BOOK = 11;

    public static final ResourceLocation JEI_TEXTURE = new ResourceLocation(ID_RP2_REDUX + ":textures/gui/jei_handler.png");

    private final IDrawableStatic[] slot = new IDrawableStatic[3];

    private final IDrawableStatic[] progressRight = new IDrawableStatic[3];
    private final IDrawableStatic[] progressRightFill = new IDrawableStatic[3];

    private final IDrawableStatic[] progressLeft = new IDrawableStatic[3];
    private final IDrawableStatic[] progressLeftFill = new IDrawableStatic[3];

    private final IDrawableStatic[] scale = new IDrawableStatic[12];
    private final IDrawableStatic[] scaleFill = new IDrawableStatic[12];

    private Drawables(IGuiHelper guiHelper) {
        slot[SLOT] = guiHelper.createDrawable(JEI_TEXTURE, 0, 96, 18, 18);
        slot[SLOT_OUTPUT] = guiHelper.createDrawable(JEI_TEXTURE, 32, 96, 26, 26);
        slot[SLOT_DOUBLE] = guiHelper.createDrawable(JEI_TEXTURE, 64, 96, 44, 26);

        for (int i = 0; i < 3; ++i) {
            progressLeft[i] = guiHelper.createDrawable(JEI_TEXTURE, 176, 32 * i, 24, 16);
            progressLeftFill[i] = guiHelper.createDrawable(JEI_TEXTURE, 200, 32 * i, 24, 16);

            progressRight[i] = guiHelper.createDrawable(JEI_TEXTURE, 176, 16 + 32 * i, 24, 16);
            progressRightFill[i] = guiHelper.createDrawable(JEI_TEXTURE, 200, 16 + 32 * i, 24, 16);
        }
        for (int i = 0; i < scale.length; ++i) {
            scale[i] = guiHelper.createDrawable(JEI_TEXTURE, 224, i * 16, 16, 16);
            scaleFill[i] = guiHelper.createDrawable(JEI_TEXTURE, 240, i * 16, 16, 16);
        }
    }

    public IDrawableStatic getSlot(int type) {
        return slot[type];
    }

    public IDrawableStatic getProgress(int type) {
        return progressRight[type];
    }

    public IDrawableStatic getProgressFill(int type) {
        return progressRightFill[type];
    }

    public IDrawableStatic getProgressLeft(int type) {
        return progressLeft[type];
    }

    public IDrawableStatic getProgressLeftFill(int type) {
        return progressLeftFill[type];
    }

    public IDrawableStatic getScale(int type) {
        return scale[type];
    }

    public IDrawableStatic getScaleFill(int type) {
        return scaleFill[type];
    }
}
