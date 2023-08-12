package drealm.structure;

import drealm.database.*;
import drealm.entity.DREntityKhazadDwarfSmith;
import drealm.entity.DREntityRedDwarfSmith;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class DRStructureKhazadMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public DRStructureKhazadMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = DRRegistry.brick;
		baseBrickMeta = 2;
		brickBlock=DRRegistry.brick;
		brickMeta=2;
		brickSlabBlock=DRRegistry.slab_single;
		brickSlabMeta=1;
		carvedBrickBlock = DRRegistry.brick;
		carvedBrickMeta = 3;
		pillarBlock = DRRegistry.pillar;
		pillarMeta = 1;
		tableBlock = DRRegistry.khazad_dwarven_table;
		barsBlock = DRRegistry.khazad_bars;
		brickStairBlock=DRRegistry.khazad_stairs;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new DREntityKhazadDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return DRChestContents.KHAZAD_MOUNTAINS_SMITHY;
	}
}
