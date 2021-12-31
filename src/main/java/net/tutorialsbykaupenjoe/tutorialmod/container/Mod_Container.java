package net.tutorialsbykaupenjoe.tutorialmod.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;

public class Mod_Container
{
    public static DeferredRegister<ContainerType<?>> CONTAINER =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, TutorialMod.MOD_ID);

    public static final RegistryObject<ContainerType<LightningChanelerContainer>> LIGHTNING_CHANELER_CONTAINER
            = CONTAINER.register("lightning_chaneler_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return  new LightningChanelerContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<ContainerType<LightningChanelerContainer>> COOKINGPOT_CONTAINER
            = CONTAINER.register("cookingpot_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return  new LightningChanelerContainer(windowId, world, pos, inv, inv.player);
            })));

    public  static void register(IEventBus eventBus)
    {
        CONTAINER.register(eventBus);
    }
}
