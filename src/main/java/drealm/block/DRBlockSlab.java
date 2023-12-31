package drealm.block;

import cpw.mods.fml.relauncher.*;
import drealm.database.DRRegistry;
import lotr.common.block.LOTRBlockSlabBase;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.IIcon;

public class DRBlockSlab extends LOTRBlockSlabBase {
	public DRBlockSlab(boolean flag) {
		super(flag, Material.rock, 4);
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return DRRegistry.brick.getIcon(i, 0);
		}
		if (j == 1) {
			return DRRegistry.brick.getIcon(i, 2);
		}
		if (j == 2) {
			return DRRegistry.brick.getIcon(i, 4);
		}
		if (j == 3) {
			return DRRegistry.brick.getIcon(i, 5);
		}

		return super.getIcon(i, j);
	}

	public static class SlabExDouble extends ItemSlab {
		public SlabExDouble(Block block) {
			super(block, (BlockSlab) DRRegistry.slab_single, (BlockSlab) DRRegistry.slab_double, true);
		}
	}

	public static class SlabExSingle extends ItemSlab {
		public SlabExSingle(Block block) {
			super(block, (BlockSlab) DRRegistry.slab_single, (BlockSlab) DRRegistry.slab_double, false);
		}
	}
}
