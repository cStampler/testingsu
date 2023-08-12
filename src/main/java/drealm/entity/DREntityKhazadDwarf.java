package drealm.entity;

import drealm.database.*;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class DREntityKhazadDwarf extends LOTREntityDwarf {
	public DREntityKhazadDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = DREntityKhazadDwarf.class;
		familyInfo.marriageAchievement = DRAchievement.marry_khazad_dwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuestFactory.KHAZAD.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuestFactory.KHAZAD;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return DRFoods.RED_DWARF;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return LOTRMod.dwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFaction.KHAZAD;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return DRChestContents.KHAZAD_DWARF_HOUSE_LARDER;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return DRAchievement.kill_khazad_dwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return DRChestContents.KHAZAD_DWARF_HOUSE_LARDER;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "khazadDwarf/dwarf/hired";
			}
			return isChild() ? "khazadDwarf/child/friendly" : "khazadDwarf/dwarf/friendly";
		}
		return isChild() ? "khazadDwarf/child/hostile" : "khazadDwarf/dwarf/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.dagger_khazad_dwarven));
		npcItemsInv.setIdleItem(null);
		return data;
	}
}
