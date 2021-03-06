package micdoodle8.mods.galacticraft.core.tile;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.World;

public class GCCoreContainerBuggyBench extends Container
{
    public GCCoreInventoryBuggyBench craftMatrix = new GCCoreInventoryBuggyBench(this);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;

    public GCCoreContainerBuggyBench(InventoryPlayer par1InventoryPlayer)
    {
    	this.worldObj = par1InventoryPlayer.player.worldObj;
        this.addSlotToContainer(new GCCoreSlotRocketBenchResult(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 142, 79));
        int var6;
        int var7;
        
        // Body
        for (var6 = 0; var6 < 4; ++var6)
        {
            for (var7 = 0; var7 < 3; ++var7)
            {
                this.addSlotToContainer(new GCCoreSlotRocketBench(this.craftMatrix, var7 * 4 + var6 + 1, 39 + var7 * 18, 14 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 2; ++var6)
        {
            for (var7 = 0; var7 < 2; ++var7)
            {
                this.addSlotToContainer(new GCCoreSlotRocketBench(this.craftMatrix, var7 * 2 + var6 + 13, 21 + var7 * 72, 14 + var6 * 54));
            }
        }

        // Addons
        for (int var8 = 0; var8 < 3; var8++)
        {
            this.addSlotToContainer(new GCCoreSlotRocketBench(this.craftMatrix, 17 + var8, 93 + (var8 * 26), -15));
        }
        
        // Player inv:

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 111 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 169));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int var2 = 1; var2 < 18; ++var2)
            {
                ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.dropPlayerItem(var3);
                }
            }
        }
    }
    
    @Override
	public void onCraftMatrixChanged(IInventory par1IInventory)
    {
//        this.craftResult.setInventorySlotContents(0, GCCoreUtil.findMatchingSpaceshipRecipe(craftMatrix)); TODO
    }

    @Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    @Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 0)
            {
                if (!this.mergeItemStack(var4, 11, 46, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par1 >= 10 && par1 < 37)
            {
                if (!this.mergeItemStack(var4, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par1 >= 37 && par1 < 46)
            {
                if (!this.mergeItemStack(var4, 11, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 11, 46, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(par1EntityPlayer, var4);
        }

        return var2;
    }
}
