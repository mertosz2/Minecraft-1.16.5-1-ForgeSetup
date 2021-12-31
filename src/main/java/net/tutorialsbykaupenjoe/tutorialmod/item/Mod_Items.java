package net.tutorialsbykaupenjoe.tutorialmod.item;

import net.minecraft.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.item.custom.Firestone;


public class Mod_Items {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP).maxDamage(8)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(Mod_Item_Tier.AMETHYST,2,3f, new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(Mod_Item_Tier.AMETHYST,1,3f, new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(Mod_Item_Tier.AMETHYST,4,1f, new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(Mod_Item_Tier.AMETHYST,1,3f, new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(Mod_Item_Tier.AMETHYST,0,3f, new Item.Properties().group(Mod_ItemGroup.TUTORIAL_GROUP)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}