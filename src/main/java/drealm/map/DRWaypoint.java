package drealm.map;

import drealm.database.DRFaction;
import drealm.util.DRCommander;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.LOTRMod;
import lotr.common.world.map.LOTRWaypoint;

public class DRWaypoint {
	public static LOTRWaypoint NARAG_GUND;
	public static LOTRWaypoint KHIBIL_TARAG;
	public static LOTRWaypoint KHELED_DUM;
	public static LOTRWaypoint RED_ROAD;
	public static LOTRWaypoint BRAGAZGATHOL;

	public static LOTRWaypoint WESTGATE;
	public static LOTRWaypoint WESTERNDEEP;
	public static LOTRWaypoint DURINSTOWER;
	public static LOTRWaypoint EASTGATE;
	public static LOTRWaypoint EASTDEEP;
	public static void preInit() {
		NARAG_GUND = DRCommander.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2579.0, 1262.0);
		KHIBIL_TARAG = DRCommander.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2448.0, 952.0);
		KHELED_DUM = DRCommander.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2382.0, 570.0);
		BRAGAZGATHOL = DRCommander.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2362.0, 1573.0);

		WESTGATE= DRCommander.addWaypoint("WESTERN_GATE",LOTRWaypoint.Region.MISTY_MOUNTAINS, DRFaction.KHAZAD, 1134.0, 873.0);
		WESTERNDEEP=DRCommander.addWaypoint("WESTERN_DEEP",LOTRWaypoint.Region.MISTY_MOUNTAINS, DRFaction.KHAZAD, 1144.0, 859.0);
		DURINSTOWER= DRCommander.addWaypoint("DURINS_TOWER",LOTRWaypoint.Region.MISTY_MOUNTAINS, DRFaction.KHAZAD, 1156.0, 871.0);
		EASTGATE= DRCommander.addWaypoint("EAST_GATE",LOTRWaypoint.Region.MISTY_MOUNTAINS, DRFaction.KHAZAD, 1173.0, 863.0);
		EASTDEEP= DRCommander.addWaypoint("EAST_DEEP",LOTRWaypoint.Region.MISTY_MOUNTAINS, DRFaction.KHAZAD, 1179.0, 878.0);
		DRCommander.disableWaypoint(LOTRWaypoint.WEST_GATE);

	}
}
