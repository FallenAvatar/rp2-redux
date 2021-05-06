package fallenavatar.rp2_redux.core.data.gen.server;

import java.util.HashMap;
import java.util.Map;

import fallenavatar.rp2_redux.lib.data.gen.server.BaseLootTableGen;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

public class LootTableGen extends BaseLootTableGen {
	public LootTableGen(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

	@Override
	protected void addTables() {
		
		
	}

	@Override
    public String getName() {
        return "RP2 Redux LootTables";
    }
}
