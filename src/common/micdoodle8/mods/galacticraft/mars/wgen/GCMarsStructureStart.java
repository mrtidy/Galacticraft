package micdoodle8.mods.galacticraft.mars.wgen;

import java.util.Random;

import net.minecraft.src.StructureStart;
import net.minecraft.src.World;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCMarsStructureStart extends StructureStart
{
	public GCMarsStructureStart(World world, Random random, int x, int z)
	{
        int var5 = (x << 4) + 8;
        int var6 = (z << 4) + 8;
        GCMarsComponentCreeperPitRoom room = new GCMarsComponentCreeperPitRoom(0, world, random, var5, 90, var6, 40, 7, 0);
        
        if (room != null)
        {
            this.components.add(room);
            room.buildComponent(room, this.components, random);
        }
        
        this.updateBoundingBox();
	}
}
