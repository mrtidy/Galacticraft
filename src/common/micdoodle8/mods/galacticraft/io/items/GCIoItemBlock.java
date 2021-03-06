package micdoodle8.mods.galacticraft.io.items;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class GCIoItemBlock extends ItemBlock
{
	public GCIoItemBlock(int i)
	{
		super(i);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta)
    {
        return meta;
    }

	@Override
	public String getItemNameIS(ItemStack itemstack) 
	{
		String name = "";
		
		switch(itemstack.getItemDamage()) 
		{
		case 0: 
		{
			name = "pyroxene";
			break;
		}
		case 1: 
		{
			name = "iostone";
			break;
		}
		case 2: 
		{
			name = "sulfur";
			break;
		}
		default: 
			name = "null";
		}
		return getItemName() + "." + name;
	}
}
