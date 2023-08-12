package drealm.entity;

import drealm.item.DRItemBanner;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class DREntityKhazadDwarfBannerBearer extends DREntityKhazadDwarfWarrior implements LOTRBannerBearer {
	public DREntityKhazadDwarfBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return DRItemBanner.KHAZAD;
	}
}
