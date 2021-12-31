package net.tutorialsbykaupenjoe.tutorialmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.block.custom.FirestoneBlock;
import net.tutorialsbykaupenjoe.tutorialmod.block.custom.LightningChanelerBlock;
import net.tutorialsbykaupenjoe.tutorialmod.item.Mod_ItemGroup;
import net.tutorialsbykaupenjoe.tutorialmod.item.Mod_Items;

import java.util.function.Supplier;

public class Mod_Blocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(AbstractBlock.Properties.create(Material.SAND).harvestLevel(2)
                    .setRequiresTool().harvestTool(ToolType.SHOVEL).hardnessAndResistance(2f)));

    public static final RegistryObject<Block> COOKING_POT = registerBlock("cooking_pot",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2)
                    .setRequiresTool().harvestTool(ToolType.SHOVEL).hardnessAndResistance(2f)));

    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2)
                    .setRequiresTool().harvestTool(ToolType.SHOVEL).hardnessAndResistance(2f)));

    public static final RegistryObject<Block> LIGHTNING_CHANELER = registerBlock("lightning_chaneler",
            () -> new LightningChanelerBlock(AbstractBlock.Properties.create(Material.IRON)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Mod_Items.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}