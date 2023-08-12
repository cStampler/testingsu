package drealm.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drealm.database.DRCreativeTabs;
import drealm.database.DRRegistry;
import lotr.common.block.LOTRBlockStairs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class DRBlockStair extends LOTRBlockStairs {
    public DRBlockStair(Block block, int metadata) {
        super(block, metadata);
        setCreativeTab(DRCreativeTabs.tabBlocks);
        useNeighborBrightness = true;
    }
}