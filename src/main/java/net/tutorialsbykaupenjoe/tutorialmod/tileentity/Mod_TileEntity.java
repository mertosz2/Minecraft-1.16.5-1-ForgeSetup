package net.tutorialsbykaupenjoe.tutorialmod.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.block.Mod_Blocks;

public class Mod_TileEntity
{

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITY =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TutorialMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightninChanelerTile>> LIGHTNING_CHANELER_TILE =
            TILE_ENTITY.register("lightning_chaneler_tile", () -> TileEntityType.Builder.create(
                    LightninChanelerTile::new, Mod_Blocks.LIGHTNING_CHANELER.get()).build(null));


    public static  void register(IEventBus eventBus)
    {
        TILE_ENTITY.register(eventBus);
    }
}
