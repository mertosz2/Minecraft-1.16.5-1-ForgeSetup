package net.tutorialsbykaupenjoe.tutorialmod.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.tutorialsbykaupenjoe.tutorialmod.item.custom.Firestone;

import javax.annotation.Nullable;
import java.util.List;


public class FirestoneBlock extends Block {
    public  FirestoneBlock(Properties properties)
    {
        super(properties);
    }
   // @SuppressWarnings("deprecation")
    //@Override
    //public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
       // return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    //}



    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entityIn)
    {

        //Firestone.lightEntityOnFire(entityIn, 5);
        entityIn.setAir(30);
        super.onEntityWalk(world, pos, entityIn);
    }
}
