package micdoodle8.mods.galacticraft.core.blocks;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCCoreBlockLandingPad extends GCCoreBlock
{
	public GCCoreBlockLandingPad(int i, int j) 
	{
		super(i, j);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}
	
    @Override
	public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
}
