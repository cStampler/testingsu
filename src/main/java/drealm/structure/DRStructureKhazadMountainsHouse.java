package drealm.structure;

import java.util.Random;

import drealm.database.*;
import drealm.entity.DREntityKhazadDwarf;
import drealm.entity.DREntityRedDwarf;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DRStructureKhazadMountainsHouse extends LOTRWorldGenDwarfHouse {
	public DRStructureKhazadMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	public LOTREntityDwarf createDwarf(World world) {
		return new DREntityKhazadDwarf(world);
	}

	@Override
	public ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = { new ItemStack(DRRegistry.helmet_khazad_dwarven), new ItemStack(DRRegistry.body_khazad_dwarven), new ItemStack(DRRegistry.legs_khazad_dwarven), new ItemStack(DRRegistry.boots_khazad_dwarven), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.mithrilNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = { new ItemStack(DRRegistry.sword_khazad_dwarven), new ItemStack(DRRegistry.dagger_khazad_dwarven), new ItemStack(DRRegistry.hammer_khazad_dwarven), new ItemStack(DRRegistry.battleaxe_khazad_dwarven), new ItemStack(DRRegistry.pickaxe_khazad_dwarven), new ItemStack(DRRegistry.mattock_khazad_dwarven), new ItemStack(DRRegistry.throwing_axe_khazad_dwarven), new ItemStack(DRRegistry.pike_khazad_dwarven) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		stoneBlock = Blocks.stone;
		stoneMeta = 0;
		fillerBlock = Blocks.stone;
		fillerMeta = 0;
		topBlock = Blocks.stone;
		topMeta = 0;
		brick2Block = DRRegistry.brick;
		brick2Meta = 2;
		pillarBlock = DRRegistry.pillar;
		pillarMeta = 1;
		chandelierBlock = LOTRMod.chandelier;
		chandelierMeta = 8;
		brickStairBlock=DRRegistry.khazad_stairs;
		tableBlock = DRRegistry.khazad_dwarven_table;
		barsBlock = DRRegistry.khazad_bars;
		larderContents = DRChestContents.KHAZAD_DWARF_HOUSE_LARDER;
		personalContents = DRChestContents.KHAZAD_MOUNTAINS_STRONGHOLD;
		plateFoods = DRFoods.RED_DWARF;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}
