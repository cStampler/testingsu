package drealm.block;

import java.util.*;

import cpw.mods.fml.relauncher.*;
import lotr.common.LOTRCreativeTabs;
import lotr.common.block.LOTRBlockOrcChain;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DRBlockChandelier extends Block {
	@SideOnly(value = Side.CLIENT)
	public IIcon[] chandelierIcons;
	public String[] chandelierNames = { "redDwarven", "windDwarven" };

	public DRBlockChandelier() {
		super(Material.circuits);
		setCreativeTab(LOTRCreativeTabs.tabDeco);
		setHardness(0.0f);
		setResistance(2.0f);
		setStepSound(Block.soundTypeMetal);
		setLightLevel(0.9375f);
		setBlockBounds(0.0625f, 0.1875f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
	}

	@Override
	public boolean canBlockStay(World world, int i, int j, int k) {
		Block block = world.getBlock(i, j + 1, k);
		int meta = world.getBlockMetadata(i, j + 1, k);
		if (block instanceof BlockFence || block instanceof BlockWall) {
			return true;
		}
		if (block instanceof BlockSlab && !block.isOpaqueCube() && (meta & 8) == 0) {
			return true;
		}
		if (block instanceof BlockStairs && (meta & 4) == 0 || block instanceof LOTRBlockOrcChain) {
			return true;
		}
		return world.getBlock(i, j + 1, k).isSideSolid(world, i, j + 1, k, ForgeDirection.DOWN);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		return canBlockStay(world, i, j, k);
	}

	@Override
	public int damageDropped(int i) {
		return i;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return null;
	}

	@Override
	public IIcon getIcon(int i, int j) {
		if (j >= chandelierNames.length) {
			j = 0;
		}
		return chandelierIcons[j];
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < chandelierNames.length; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, Block block) {
		if (!canBlockStay(world, i, j, k)) {
			this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
			world.setBlockToAir(i, j, k);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		int meta = world.getBlockMetadata(i, j, k);
		double d = 0.13;
		double d1 = 1.0 - d;
		double d2 = 0.6875;
		spawnChandelierParticles(world, i + d, j + d2, k + d, random, meta);
		spawnChandelierParticles(world, i + d1, j + d2, k + d1, random, meta);
		spawnChandelierParticles(world, i + d, j + d2, k + d1, random, meta);
		spawnChandelierParticles(world, i + d1, j + d2, k + d, random, meta);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister) {
		chandelierIcons = new IIcon[chandelierNames.length];
		for (int i = 0; i < chandelierNames.length; ++i) {
			chandelierIcons[i] = iconregister.registerIcon(getTextureName() + "_" + chandelierNames[i]);
		}
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public static void spawnChandelierParticles(World world, double d, double d1, double d2, Random random, int meta) {
		world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0);
		world.spawnParticle("flame", d, d1, d2, 0.0, 0.0, 0.0);
	}
}
