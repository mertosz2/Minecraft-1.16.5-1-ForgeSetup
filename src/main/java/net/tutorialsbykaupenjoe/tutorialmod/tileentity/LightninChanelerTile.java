package net.tutorialsbykaupenjoe.tutorialmod.tileentity;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tutorialsbykaupenjoe.tutorialmod.item.Mod_Items;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LightninChanelerTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public LightninChanelerTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public LightninChanelerTile()
    {
        this(Mod_TileEntity.LIGHTNING_CHANELER_TILE.get());
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(4){
            @Override
            protected  void onContentsChanged(int slot){
                markDirty();
            }
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack){
                switch (slot){
                    case 0: return stack.getItem() == Items.GLASS_PANE;
                    case 1: return stack.getItem() == Mod_Items.AMETHYST.get() ||
                            stack.getItem() == Mod_Items.FIRESTONE.get();
                    default:
                        return false;
                }
            }
            @Override
            public int getSlotLimit(int slot)
            {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack))
                {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };

    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return super.write(compound);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void LightningHasStruck()
    {
        boolean hasFocusInFirstSlot = this.itemHandler.getStackInSlot(0).getCount() > 0 &&
                this.itemHandler.getStackInSlot(0).getItem() == Items.GLASS_PANE;
        boolean hasAmethystInSecondSlot = this.itemHandler.getStackInSlot(0).getCount() > 0 &&
                this.itemHandler.getStackInSlot(1).getItem() == Mod_Items.AMETHYST.get();

        if(hasFocusInFirstSlot && hasAmethystInSecondSlot)
        {
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);

            this.itemHandler.insertItem(1, new ItemStack(Mod_Items.FIRESTONE.get()),false);
        }
    }
}
