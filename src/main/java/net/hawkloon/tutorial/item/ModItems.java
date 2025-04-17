package net.hawkloon.tutorial.item;

import net.hawkloon.tutorial.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> STIMPAK = ITEMS.register("stimpak",
            () -> new StimpakItem(new Item.Properties().durability(1)));
    public static final DeferredItem<Item> XANDER_ROOT = ITEMS.register("xander_root",
            ()-> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
