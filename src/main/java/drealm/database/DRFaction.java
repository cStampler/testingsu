package drealm.database;

import java.util.EnumSet;

import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.util.DRCommander;
import lotr.common.*;
import lotr.common.fac.*;
import lotr.common.world.map.LOTRWaypoint;

public class DRFaction {
	public static LOTRFaction RED_MOUNTAINS;
	public static LOTRFaction WIND_MOUNTAINS;
	public static LOTRFaction KHAZAD;

	public static void onInit() {
		DRFaction.setupRelations();
		DRFaction.setupMapInfo();
		DRFaction.setupControlZones();
		DRFaction.setupRanks();
	}

	public static void preInit() {
		DRFaction.setupFactions();
	}

	public static void setupControlZones() {
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(2437, 898, 454));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(2500, 1535, 292));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRCommander.addControlZone(KHAZAD, new LOTRControlZone(LOTRWaypoint.MOUNT_CELEBDIL,70));

	}

	public static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);
		KHAZAD = DRCommander.addFaction("KHAZAD", 0x5c63c8,LOTRDimension.DimensionRegion.WEST, enumSetFreeDwarf);
		RED_MOUNTAINS = DRCommander.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		WIND_MOUNTAINS = DRCommander.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
		RED_MOUNTAINS.approvesWarCrimes = false;
	}

	public static void setupMapInfo() {
		RED_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		WIND_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
		KHAZAD.factionMapInfo = new LOTRMapRegion(1159, 859, 100);
	}

	public static void setupRanks() {
		DRCommander.setFactionAchievementCategory(RED_MOUNTAINS, LOTRAchievement.Category.OROCARNI);
		DRCommander.addFactionRank(RED_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(RED_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DRCommander.setFactionAchievementCategory(WIND_MOUNTAINS, DRAchievementCategory.WIND_MOUNTAINS);
		DRCommander.addFactionRank(WIND_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DRCommander.setFactionAchievementCategory(KHAZAD,DRAchievementCategory.KHAZAD);
		DRCommander.addFactionRank(KHAZAD, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(KHAZAD, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(KHAZAD, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
	}

	public static void setupRelations() {
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, KHAZAD, LOTRFactionRelations.Relation.ALLY);

		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, WIND_MOUNTAINS, LOTRFactionRelations.Relation.ENEMY);

		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.NEUTRAL);

		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.MORWAITH, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DUNLAND, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.ALLY);


		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.DALE, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, WIND_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(KHAZAD, RED_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
	}
}
