package net.hawkloon.tutorial.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class NukaColaTier {
    public static final Tier NUKA_COLA_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            8192,
            500f,
            6f,
            0,
            () -> Ingredient.of(ModItems.NUKA_COLA)
    );
}
