package drealm.database;

import java.util.*;

import drealm.util.DRCommander;
import lotr.common.*;
import lotr.common.LOTRAchievement.Category;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class DRAchievement {
	public static Map<ArmorMaterial, LOTRAchievement> armorAchievements = new EnumMap<>(ArmorMaterial.class);

	public static LOTRAchievement trade_red_dwarf_smith;
	public static LOTRAchievement trade_red_dwarf_miner;
	public static LOTRAchievement trade_red_dwarf_commander;
	public static LOTRAchievement trade_red_dwarf_merchant; 
	public static LOTRAchievement kill_red_dwarf;
	public static LOTRAchievement marry_red_dwarf;
	public static LOTRAchievement do_miniquest_red_mountains;
	public static LOTRAchievement smelt_red_dwarf_steel;
	public static LOTRAchievement wear_full_red_dwarven;
	public static LOTRAchievement use_red_dwarven_table;




	public static LOTRAchievement trade_wind_dwarf_smith;
	public static LOTRAchievement trade_wind_dwarf_miner;
	public static LOTRAchievement trade_wind_dwarf_commander;
	public static LOTRAchievement trade_wind_dwarf_merchant;
	public static LOTRAchievement kill_wind_dwarf;
	public static LOTRAchievement marry_wind_dwarf;
	public static LOTRAchievement do_miniquest_wind_mountains;
	public static LOTRAchievement smelt_wind_dwarf_steel;
	public static LOTRAchievement wear_full_wind_dwarven;
	public static LOTRAchievement use_wind_dwarven_table;


	public static LOTRAchievement trade_khazad_dwarf_smith;
	public static LOTRAchievement trade_khazad_dwarf_miner;
	public static LOTRAchievement trade_khazad_dwarf_commander;
	public static LOTRAchievement kill_khazad_dwarf;
	public static LOTRAchievement marry_khazad_dwarf;
	public static LOTRAchievement do_miniquest_khazad_mountains;
	public static LOTRAchievement smelt_khazad_dwarf_steel;
	public static LOTRAchievement wear_full_khazad_dwarven;
	public static LOTRAchievement use_khazad_dwarven_table;

	public static LOTRAchievement createArmorAchievement(LOTRAchievement.Category category, int id, Item item, String name) {
		LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
		armorAchievements.put(((ItemArmor) item).getArmorMaterial(), achievement);
		return achievement;
	}

	public static void onInit() {



		smelt_red_dwarf_steel = new LOTRAchievement(Category.OROCARNI, 1, DRRegistry.red_dwarf_steel, "smeltRedDwarfSteel");
		kill_red_dwarf = new LOTRAchievement(Category.OROCARNI, 2, LOTRMod.dwarfBone, "killRedDwarf").setRequiresEnemy(DRFaction.RED_MOUNTAINS).createTitle();
		wear_full_red_dwarven = DRAchievement.createArmorAchievement(Category.OROCARNI, 3, DRRegistry.body_red_dwarven, "wearFullRedDwarven");
		use_red_dwarven_table = new LOTRAchievement(Category.OROCARNI, 4, DRRegistry.red_dwarven_table, "useRedDwarvenTable").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_smith = new LOTRAchievement(Category.OROCARNI, 5, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_miner = new LOTRAchievement(Category.OROCARNI, 6, LOTRMod.silverCoin, "tradeRedDwarfMiner").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_commander = new LOTRAchievement(Category.OROCARNI, 7, LOTRMod.silverCoin, "tradeRedDwarfCommander").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_merchant = new LOTRAchievement(Category.OROCARNI, 8, LOTRMod.silverCoin, "tradeRedDwarfMerchant").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		marry_red_dwarf = new LOTRAchievement(Category.OROCARNI, 9, LOTRMod.dwarvenRing, "marryRedDwarf").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		do_miniquest_red_mountains = new LOTRAchievement(Category.OROCARNI, 10, LOTRMod.redBook, "doMiniquestRedMountains").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_smith = new LOTRAchievement(Category.OROCARNI, 11, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);



		smelt_wind_dwarf_steel = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 12, DRRegistry.wind_dwarf_steel, "smeltWindDwarfSteel");
		kill_wind_dwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 13, LOTRMod.dwarfBone, "killWindDwarf").setRequiresEnemy(DRFaction.WIND_MOUNTAINS).createTitle();
		wear_full_wind_dwarven = DRAchievement.createArmorAchievement(DRAchievementCategory.WIND_MOUNTAINS, 14, DRRegistry.body_wind_dwarven, "wearFullWindDwarven");
		use_wind_dwarven_table = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 15, DRRegistry.wind_dwarven_table, "useWindDwarvenTable").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_smith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 16, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_miner = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 17, LOTRMod.silverCoin, "tradeWindDwarfMiner").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_commander = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 18, LOTRMod.silverCoin, "tradeWindDwarfCommander").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_merchant = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 19, LOTRMod.silverCoin, "tradeWindDwarfMerchant").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		marry_wind_dwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 20, LOTRMod.dwarvenRing, "marryWindDwarf").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		do_miniquest_wind_mountains = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 21, LOTRMod.redBook, "doMiniquestWindMountains").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_smith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 22, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);



		trade_khazad_dwarf_smith =  new LOTRAchievement(DRAchievementCategory.KHAZAD, 23, LOTRMod.silverCoin, "tradeKhazadDwarfSmith").setRequiresAlly(DRFaction.KHAZAD);
		trade_khazad_dwarf_miner  = new LOTRAchievement(DRAchievementCategory.KHAZAD, 24, LOTRMod.silverCoin, "tradeKhazadDwarfMiner").setRequiresAlly(DRFaction.KHAZAD);
		trade_khazad_dwarf_commander = new LOTRAchievement(DRAchievementCategory.KHAZAD, 25, LOTRMod.silverCoin, "tradeKhazadDwarfMiner").setRequiresAlly(DRFaction.KHAZAD);
		kill_khazad_dwarf = new LOTRAchievement(DRAchievementCategory.KHAZAD, 26, LOTRMod.dwarfBone, "killKhazadDwarf").setRequiresEnemy(DRFaction.KHAZAD).createTitle();
		marry_khazad_dwarf =  new LOTRAchievement(DRAchievementCategory.KHAZAD, 27, LOTRMod.dwarvenRing, "marryKhazadDwarf").setRequiresAlly(DRFaction.KHAZAD);
		do_miniquest_khazad_mountains = new LOTRAchievement(DRAchievementCategory.KHAZAD, 28, LOTRMod.redBook, "doMiniquestKhazad").setRequiresAlly(DRFaction.KHAZAD);
		smelt_khazad_dwarf_steel = new LOTRAchievement(DRAchievementCategory.KHAZAD, 29, LOTRMod.dwarfSteel, "smeltKhazadDwarfSteel");
		wear_full_khazad_dwarven = DRAchievement.createArmorAchievement(DRAchievementCategory.KHAZAD, 30, DRRegistry.body_khazad_dwarven, "wearFullKhazad");
		use_khazad_dwarven_table  = new LOTRAchievement(DRAchievementCategory.KHAZAD, 31, DRRegistry.khazad_dwarven_table, "useKhazadTable").setRequiresAlly(DRFaction.KHAZAD);



	}

	public static void runAchievementCheck(EntityPlayer player) {
		ItemArmor.ArmorMaterial material = DRMaterial.getFullArmorMaterial(player);
		if (armorAchievements.containsKey(material)) {
			LOTRLevelData.getData(player).addAchievement(armorAchievements.get(material));
		}
	}

	public static class DRAchievementCategory {
		public static LOTRAchievement.Category WIND_MOUNTAINS;
		public static LOTRAchievement.Category KHAZAD;

		public static void onInit() {
			WIND_MOUNTAINS = DRCommander.addAchievementCategory("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
			KHAZAD = DRCommander.addAchievementCategory("KHAZAD_MOUNTAINS", DRFaction.KHAZAD);
		}
	}
}