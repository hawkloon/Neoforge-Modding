package net.hawkloon.tutorial.item;

import net.hawkloon.tutorial.TutorialMod;
import net.hawkloon.tutorial.block.ModBlocks;
import net.hawkloon.tutorial.potion.ModPotions;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DataComponentUtil;
import net.neoforged.neoforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> STIMPAK = ITEMS.register("stimpak",
            () -> new StimpakItem(new Item.Properties().durability(1)));
    public static final DeferredItem<Item> XANDER_ROOT = ITEMS.register("xander_root",
            ()-> new PotionItem(new Item.Properties().component(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.NUKA_COLA))
                    .stacksTo(1)));
    public static final DeferredItem<Item> NUKA_COLA_EMPTY = ITEMS.register("nuka_cola_empty",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NUKA_COLA = ITEMS.register("nuka_cola",
            () -> new NukaColaItem(new Item.Properties().component(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.NUKA_COLA))
                    .stacksTo(1)
                    .craftRemainder(NUKA_COLA_EMPTY.asItem())));

    public static final Supplier<SwordItem> NUKA_COLA_SWORD = ITEMS.register("nuka_cola_sword", () -> new SwordItem(NukaColaTier.NUKA_COLA_TIER,
            new Item.Properties().attributes(SwordItem.createAttributes(
                    NukaColaTier.NUKA_COLA_TIER,
                    12,
                    0.0f
            ))));

    public static final DeferredItem<Item> XANDER_SEEDS = ITEMS.register("xander_seeds",
            () -> new ItemNameBlockItem(ModBlocks.XANDER_CROP.get(), new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
