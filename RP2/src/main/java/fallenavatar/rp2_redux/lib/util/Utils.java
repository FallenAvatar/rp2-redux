package fallenavatar.rp2_redux.lib.util;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.ModList;

public class Utils {
	private Utils() {}

	public static boolean isModLoaded(String modid) { return ModList.get().isLoaded(modid); }
    public static boolean isClientWorld(World world) { return world.isRemote; }
    public static boolean isServerWorld(World world) { return !world.isRemote; }
    public static boolean isFakePlayer(Entity entity) { return entity instanceof FakePlayer; }
}
