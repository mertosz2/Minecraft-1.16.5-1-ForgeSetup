package net.tutorialsbykaupenjoe.tutorialmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.tutorialsbykaupenjoe.tutorialmod.block.Mod_Blocks;

public class Mod_ItemGroup {

    public static final ItemGroup TUTORIAL_GROUP = new ItemGroup("ModTab") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(Mod_Items.AMETHYST.get());
        }
    };


}