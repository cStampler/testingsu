package drealm.block;

import cpw.mods.fml.relauncher.*;
import drealm.database.DRRegistry;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockWallBase;
import net.minecraft.util.IIcon;

public class DRBlockWall extends LOTRBlockWallBase {
	public DRBlockWall() {
		super(LOTRMod.brick, 2);
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return DRRegistry.brick.getIcon(i, 0);
		}	if (j == 1) {
			return DRRegistry.brick.getIcon(i, 2);
		}
		return super.getIcon(i, j);
	}
}
