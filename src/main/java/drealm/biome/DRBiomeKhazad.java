package drealm.biome;

import drealm.entity.*;
import drealm.structure.*;
import drealm.util.DRCommander;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRMod;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRBiomeSpawnList;
import lotr.common.world.spawning.LOTREventSpawner;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;
import lotr.common.world.structure2.LOTRWorldGenRuinedDwarvenTower;
import lotr.common.world.structure2.LOTRWorldGenSmallStoneRuin;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class DRBiomeKhazad extends LOTRBiome {
    public static final LOTRSpawnList KHAZAD = DRCommander.newLOTRSpawnList(new LOTRSpawnEntry(DREntityKhazadDwarf.class, 100, 4, 4), new LOTRSpawnEntry(DREntityKhazadDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(DREntityKhazadDwarfWarrior.class, 20, 4, 4));
    public DRBiomeKhazad(int i, boolean major) {
        super(i, major);
        spawnableCreatureList.clear();
        spawnableLOTRAmbientList.clear();
        npcSpawnList.clear();
        LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[1];
        arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(KHAZAD, 10);
        npcSpawnList.newFactionList(600).add(arrspawnListContainer);
        addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.3f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.3f);
        decorator.biomeOreFactor = 2.0f;
        decorator.biomeGemFactor = 1.5f;
        decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
        decorator.addOre(new WorldGenMinable(LOTRMod.oreMithril, 6), 1.0f, 0, 16);
        decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
        decorator.flowersPerChunk = 1;
        decorator.grassPerChunk = 3;
        decorator.doubleGrassPerChunk = 1;
        decorator.generateWater = false;
        decorator.addTree(LOTRTreeType.SPRUCE, 400);
        decorator.addTree(LOTRTreeType.SPRUCE_THIN, 400);
        decorator.addTree(LOTRTreeType.LARCH, 300);
        decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 100);
        decorator.addTree(LOTRTreeType.SPRUCE_MEGA_THIN, 20);
        decorator.addTree(LOTRTreeType.FIR, 500);
        decorator.addTree(LOTRTreeType.PINE, 500);
        decorator.addRandomStructure(new DRStructureKhazadMountainsStronghold(false), 150);
        decorator.addRandomStructure(new DRStructureKhazadMountainsSmithy(false), 70);
        registerMountainsFlowers();
        addFlower(LOTRMod.dwarfHerb, 0, 2);
        biomeColors.setSky(12241873);
        registerTravellingTrader(DREntityRedDwarfMerchant.class);
        setBanditChance(LOTREventSpawner.EventChance.NEVER);
    }

    @Override
    public void decorate(World world, Random random, int i, int k) {
        super.decorate(world, random, i, k);
        for (int l = 0; l < 4; ++l) {
            int i1 = i + random.nextInt(16) + 8;
            int j1 = 70 + random.nextInt(80);
            int k1 = k + random.nextInt(16) + 8;
            new DRStructureKhazadMountainsHouse(false).generate(world, random, i1, j1, k1);
        }
    }

    @Override
    public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
        int snowHeight = 120 - rockDepth;
        int stoneHeight = snowHeight - 30;
        for (int j = ySize - 1; j >= stoneHeight; --j) {
            int index = xzIndex * ySize + j;
            Block block = blocks[index];
            if (j >= snowHeight && block == topBlock) {
                blocks[index] = Blocks.snow;
                meta[index] = 0;
                continue;
            }
            if (block != topBlock && block != fillerBlock) {
                continue;
            }
            blocks[index] = Blocks.stone;
            meta[index] = 0;
        }
    }

    @Override
    public LOTRAchievement getBiomeAchievement() {
        return LOTRAchievement.enterMistyMountains;
    }

    @Override
    public LOTRMusicRegion.Sub getBiomeMusic() {
        return LOTRMusicRegion.MISTY_MOUNTAINS.getSubregion("mistyMountains");
    }

    @Override
    public LOTRWaypoint.Region getBiomeWaypoints() {
        return LOTRWaypoint.Region.MISTY_MOUNTAINS;
    }

    @Override
    public float getChanceToSpawnAnimals() {
        return 0.5f;
    }

    @Override
    public boolean getEnableRiver() {
        return false;
    }

    @Override
    public LOTRRoadType getRoadBlock() {
        return LOTRRoadType.DWARVEN;
    }
}
