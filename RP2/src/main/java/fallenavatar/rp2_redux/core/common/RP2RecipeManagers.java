package fallenavatar.rp2_redux.core.common;

import net.minecraft.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;

import cofh.thermal.lib.util.managers.IManager;
import fallenavatar.rp2_redux.core.RP2ReduxMod;

public class RP2RecipeManagers {

    private static final RP2RecipeManagers INSTANCE = new RP2RecipeManagers();

    private RecipeManager serverRecipeManager;
    private final List<IManager> managers = new ArrayList<>();

    public static RP2RecipeManagers instance() {

        return INSTANCE;
    }

    public void setServerRecipeManager(RecipeManager recipeManager) {

        this.serverRecipeManager = recipeManager;
    }

    public static void registerManager(IManager manager) {

        if (!instance().managers.contains(manager)) {
            instance().managers.add(manager);
        }
    }

    public void config() {

        for (IManager sub : managers) {
            sub.config();
        }
    }

    public void refreshServer() {

        if (this.serverRecipeManager == null) {
            return;
        }
        for (IManager sub : managers) {
            sub.refresh(this.serverRecipeManager);
        }
    }

    public void refreshClient(RecipeManager recipeManager) {

        if (this.serverRecipeManager != null) {
            return;
        }
        if (recipeManager == null) {
            RP2ReduxMod.LOG.error("The client's Recipe Manager is null! This is REALLY BAD and will prevent recipes from registering. Check your modpack and configs.");
            return;
        }
        for (IManager sub : managers) {
            sub.refresh(recipeManager);
        }
    }
    // endregion
}
