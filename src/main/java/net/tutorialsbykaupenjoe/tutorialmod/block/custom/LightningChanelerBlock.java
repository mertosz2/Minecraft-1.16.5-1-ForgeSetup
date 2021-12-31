package net.tutorialsbykaupenjoe.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tutorialsbykaupenjoe.tutorialmod.container.LightningChanelerContainer;
import net.tutorialsbykaupenjoe.tutorialmod.screen.LightningChanelerScreen;
import net.tutorialsbykaupenjoe.tutorialmod.tileentity.LightninChanelerTile;
import net.tutorialsbykaupenjoe.tutorialmod.tileentity.Mod_TileEntity;

import javax.annotation.Nullable;
import java.nio.channels.NetworkChannel;

public class LightningChanelerBlock extends Block {
    public LightningChanelerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote)
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(!player.isCrouching())
            {
                if(tileEntity instanceof LightninChanelerTile)
                {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);
                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
                }
                else
                {
                    throw new IllegalStateException("Our container provoid missing");
                }

            }
            else
            {
                if(tileEntity instanceof LightninChanelerTile)
                {
                    if(!worldIn.isThundering())
                    {
                        EntityType.LIGHTNING_BOLT.spawn(((ServerWorld) worldIn), null, player, pos,
                                SpawnReason.TRIGGERED, true, true);

                        ((LightninChanelerTile)tileEntity).LightningHasStruck();
                    }
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private  INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos)
    {
        return  new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.tutorailmod.lightning_chaneler");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new LightningChanelerContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return Mod_TileEntity.LIGHTNING_CHANELER_TILE.get().create();
    }
}
