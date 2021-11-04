package fallenavatar.rp2_redux.lib.data.def;

import com.google.common.base.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;

public class BlockVariant {
	private String name;
	public String getName() { return name; }

	protected Properties props;
	public Properties getBlockProperties() { return props; }

	protected Supplier<Block> asBlock() { return () -> new Block(props); }

	public BlockVariant(String name, Properties props) {
		this.name = name;
		this.props = props;
	}
}
