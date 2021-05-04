package fallenavatar.rp2_redux.core.data.gen;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

public class LootTables extends LootTableProvider {
	private final DataGenerator generator;

	public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);

        generator = dataGeneratorIn;
    }

	@Override
    // Entry point
    public void act(DirectoryCache cache) {
        //addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());
        }
        //writeTables(cache, tables);
    }

	@Override
    public String getName() {
        return "MyTutorial LootTables";
    }
}
