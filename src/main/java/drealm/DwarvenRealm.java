package drealm;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import drealm.biome.DRBiome;
import drealm.block.DRBlockChandelier;
import drealm.database.*;
import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.entity.DREntity;
import drealm.item.DRItemBanner;
import drealm.map.*;
import drealm.proxy.DRServerProxy;
import drealm.structure.DRStructure;
import drealm.util.*;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "drealm", dependencies = "required-after:lotr")
public class DwarvenRealm {
	@SidedProxy(serverSide = "drealm.proxy.DRServerProxy", clientSide = "drealm.proxy.DRClientProxy")
	public static DRServerProxy proxy;
	@Mod.Instance(value = "drealm")
	public static DwarvenRealm instance;
	public static DREventHandler event_handler;

	public static ModContainer getModContainer() {
		return FMLCommonHandler.instance().findContainerFor(instance);
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		DRMaterial.onInit();
		DRShields.onInit();
		DRInvasions.onInit();
		DRAchievementCategory.onInit();
		DRAchievement.onInit();
		DRFaction.onInit();
		DRMiniQuestFactory.onInit();
		DRRoads.onInit();
		DRSpeech.onInit();
		DRCommander.setServerMapImage(new ResourceLocation("drealm:map/map.png"));
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		event_handler = new DREventHandler();
		DRConfig.preInit();
		DRCreativeTabs.preInit();
		DRFaction.preInit();
		DRWaypoint.preInit();
		DRItemBanner.preInit();
		DRRegistry.preInit();
		DREntity.preInit();
		DRStructure.preInit();
		DRRecipe.preInit();
		DRBiome.preInit();
		proxy.preInit(event);
	}
}
