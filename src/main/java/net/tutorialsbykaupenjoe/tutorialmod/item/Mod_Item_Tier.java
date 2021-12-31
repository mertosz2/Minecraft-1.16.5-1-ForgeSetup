package net.tutorialsbykaupenjoe.tutorialmod.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum Mod_Item_Tier implements IItemTier
{
    AMETHYST(3,150,12,4,10, () -> Ingredient.fromItems(Mod_Items.AMETHYST.get()));
    private final int harvestlevel;
    private final int maxUses;
    private final int attackdamage;
    private final int efficiency;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    Mod_Item_Tier(int harvestlevel, int maxUses, int attackdamage, int efficiency, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestlevel = harvestlevel;
        this.maxUses = maxUses;
        this.attackdamage = attackdamage;
        this.efficiency = efficiency;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }


    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackdamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestlevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
