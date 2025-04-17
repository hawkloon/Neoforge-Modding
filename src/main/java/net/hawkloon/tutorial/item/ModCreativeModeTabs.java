package net.hawkloon.tutorial.item;

import net.hawkloon.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MODID);

    public static final Supplier<CreativeModeTab> AID_TAB = TAB.register("aid_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.STIMPAK.get()))
                    .title(Component.translatable("creativetab.turtorialmod.aid"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STIMPAK);
                    }).build());

    public static void register(IEventBus eventBus){
        TAB.register(eventBus);
    }

}
