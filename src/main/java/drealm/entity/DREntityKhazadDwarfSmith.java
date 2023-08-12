package drealm.entity;

import drealm.database.*;
import lotr.common.*;
import lotr.common.entity.npc.*;
import lotr.common.entity.npc.LOTRTradeEntries.TradeType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityKhazadDwarfSmith extends DREntityKhazadDwarf implements LOTRTradeable.Smith {
	public static final LOTRTradeEntries RED_DWARF_SMITH_BUY = new LOTRTradeEntries(TradeType.BUY, new LOTRTradeEntry(new ItemStack(DRRegistry.khazad_dwarven_table), 100), new LOTRTradeEntry(new ItemStack(LOTRMod.blacksmithHammer), 18), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 20), new LOTRTradeEntry(new ItemStack(DRRegistry.sword_khazad_dwarven), 16), new LOTRTradeEntry(new ItemStack(DRRegistry.spear_khazad_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.battleaxe_khazad_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.hammer_khazad_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.pike_khazad_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.dagger_khazad_dwarven), 13), new LOTRTradeEntry(new ItemStack(DRRegistry.axe_khazad_dwarven), 15), new LOTRTradeEntry(new ItemStack(DRRegistry.pickaxe_khazad_dwarven), 14), new LOTRTradeEntry(new ItemStack(DRRegistry.shovel_khazad_dwarven), 12), new LOTRTradeEntry(new ItemStack(DRRegistry.mattock_khazad_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.throwing_axe_khazad_dwarven), 15), new LOTRTradeEntry(new ItemStack(DRRegistry.helmet_khazad_dwarven), 25), new LOTRTradeEntry(new ItemStack(DRRegistry.body_khazad_dwarven), 36), new LOTRTradeEntry(new ItemStack(DRRegistry.legs_khazad_dwarven), 30), new LOTRTradeEntry(new ItemStack(DRRegistry.boots_khazad_dwarven), 22), new LOTRTradeEntry(new ItemStack(DRRegistry.boar_armor_khazad_dwarven), 25));
	public static final LOTRTradeEntries RED_DWARF_SMITH_SELL = new LOTRTradeEntries(TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarfSteel), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 3), 1), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(Items.string, 3), 1), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 16));

	public DREntityKhazadDwarfSmith(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendly(entityplayer);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		dropItem(LOTRMod.dwarfSteel, 1 + rand.nextInt(3) + rand.nextInt(i + 1));
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return RED_DWARF_SMITH_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return RED_DWARF_SMITH_SELL;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "khazadDwarf/smith/friendly";
			}
			return "khazadDwarf/smith/neutral";
		}
		return "khazadDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_khazad_dwarf_smith);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.blacksmithHammer));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}
