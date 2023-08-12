package drealm.biome;

import lotr.common.LOTRDimension;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenMistyMountains;

public class DRBiome {
	public static LOTRBiome redMountains;
	public static LOTRBiome redMountainsFoothills;
	public static LOTRBiome windMountains;
	public static LOTRBiome windMountainsFoothills;

	public static LOTRBiome khazad;

	public static LOTRBiome khazadFoothills;

	public static void preInit() {
		for (int i : new int[] { 117, 118, 164, 165,235,236 }) {
			LOTRDimension.MIDDLE_EARTH.biomeList[i] = null;
		}
		redMountains = new DRBiomeRedMountains(117, true).setTemperatureRainfall(0.3f, 0.4f).setMinMaxHeight(1.5f, 2.0f).setColor(0x93714D).setBiomeName("redMountains");
		redMountainsFoothills = new DRBiomeRedMountainsFoothills(118, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.5f, 0.9f).setColor(0x999453).setBiomeName("redMountainsFoothills");
		windMountains = new DRBiomeWindMountains(164, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(0xD3D3D4).setBiomeName("windMountains");
		windMountainsFoothills = new DRBiomeWindMountainsFoothills(165, true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(0.5f, 0.6f).setColor(0x9A9F6B).setBiomeName("windMountainsFoothills");
		khazad = new DRBiomeKhazad(235, true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(1.5f, 2.0f).setColor(0xCECECB).setBiomeName("khazad");
		khazadFoothills = new DRBiomeKhazadFoothills(236,true).setTemperatureRainfall(0.4f,0.6f).setMinMaxHeight(0.6f,0.7f).setColor(0xa6a89f).setBiomeName("khazadFoothills");
	}
}