package drealm.entity;

import drealm.database.*;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.*;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityKhazadDwarfCommander extends DREntityKhazadDwarfWarrior implements LOTRUnitTradeable {
	public static final LOTRUnitTradeEntries RED_DWARF_COMMANDER = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityKhazadDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityKhazadDwarfWarrior.class, 30, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityKhazadDwarfAxeThrower.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityKhazadDwarfWarrior.class, LOTREntityWildBoar.class, "KhazadDwarfWarrior_Boar", 50, 150.0f).setMountArmor(LOTRMod.boarArmorDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityKhazadDwarfAxeThrower.class, LOTREntityWildBoar.class, "KhazadDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(LOTRMod.boarArmorDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityKhazadDwarfBannerBearer.class, 50, 200.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF));

	public DREntityKhazadDwarfCommander(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 200.0f && isFriendly(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public EntityAIBase getDwarfAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, false);
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "khazadDwarf/commander/friendly";
			}
			return "khazadDwarf/commander/neutral";
		}
		return "khazadDwarf/dwarf/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return RED_DWARF_COMMANDER;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return DRInvasions.RED_MOUNTAINS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammer_khazad_dwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.boots_khazad_dwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legs_khazad_dwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.body_khazad_dwarven));
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_khazad_dwarf_commander);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}
