package mod.xtronius.rc_mod.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator
{

	/** Rarity */
	public int OreExtremelyCommon = 5;
	public int OreCommon = 4;
	public int OreUncommon = 3;
	public int OreRare = 2;
	public int OreVeryRare = 1;
	
	/** Vein Size */
	public int OreVeinVeryLargeSize = 7;
	public int OreVeinLargeSize = 6;
	public int OreVeinAboveNormalSize = 5;
	public int OreVeinNormalSize = 4;
	public int OreVeinBelowNormalSize = 3;
	public int OreVeinSmallSize = 2;
	public int OreVeinVerySmallSize = 1;
	
	/** Height */
	public int OreHeightSkyLimit = 255;
	public int OreHeightVeryHigh = 86;
	public int OreHeightHigh = 63;
	public int OreHeightSomeWhatHigh = 56;
	public int OreHeightNormal = 43;
	public int OreHeightSomeWhatLow = 33;
	public int OreHeightLow = 23;
	public int OreHeightVeryLow = 13;
	public int OreHeightBedRockLevel = 5;

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z)
	{
	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		
//		BiomeGenBase biomeWaterPeal = world.getWorldChunkManager().getBiomeGenAt(x ,z);
//		if(biomeWaterPeal instanceof BiomeGenOcean || biomeWaterPeal instanceof BiomeGenRiver  ){
//			this.addOreSpawn(Gems.blockPearlOre, world, random, x, z, 16, 16, OreVeinVerySmallSize + random.nextInt(3), OreVeryRare, OreHeightLow, OreHeightHigh);
//		// System.out.println("Peal Ore Has Spawned!!!");
//		}
		
	  //this.addOreSpawn(Ore, world, random, x-coord, z-Ccoord, x-16, z-16, vein size + random.nextInt(3), rarity, min-y, max-y);
	  //this.addOreSpawn(Metals.blockTungstenOre, world, random, x, z, 16, 16, OreVeinSmallSize + random.nextInt(3), OreVeryRare, OreHeightBedRockLevel, OreHeightVeryLow);
			
		// System.out.println("Regular Ores Have Spawned!!!");
		
	}

	private void generateNether(World world, Random random, int x, int z)
	{
//	  //this.addOreSpawn(Ore, world, random, x-coord, z-Ccoord, x-16, z-16, vein size + random.nextInt(3), rarity, min-y, max-y);
//		BiomeGenBase biomeFire = world.getWorldChunkManager().getBiomeGenAt(x ,z);
//		if(biomeFire instanceof BiomeGenHell){
//		this.addNetherOreSpawn(Special.fireOre, world, random, x, z, 16, 16, 5 + random.nextInt(3), 5, 5, 255);
//		// System.out.println("Fire Ores Have Spawned!!!");
//	}
		}

	/**
	 * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	 * 
	 * @param The Block to spawn
	 * @param The World to spawn in
	 * @param A Random object for retrieving random positions within the world to spawn the Block
	 * @param An int for passing the X-Coordinate for the Generation method
	 * @param An int for passing the Z-Coordinate for the Generation method
	 * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum size of a vein
	 * @param An int for the Number of chances available for the Block to spawn per-chunk
	 * @param An int for the minimum Y-Coordinate height at which this block may spawn
	 * @param An int for the maximum Y-Coordinate height at which this block may spawn
	 **/
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	public void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	public void addEndOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenEndMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
}