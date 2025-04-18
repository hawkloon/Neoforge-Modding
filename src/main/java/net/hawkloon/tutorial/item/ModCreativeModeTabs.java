package net.hawkloon.tutorial.item;

import net.hawkloon.tutorial.TutorialMod;
import net.hawkloon.tutorial.potion.ModPotions;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
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
                        output.accept(ModItems.XANDER_ROOT);
                        output.accept(ModItems.NUKA_COLA);
                        output.accept(ModItems.NUKA_COLA_EMPTY);
                        output.accept(ModItems.NUKA_COLA_SWORD.get());
                    }).build());
    public static final Supplier<CreativeModeTab> CROPS_TAB = TAB.register("crop_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.XANDER_SEEDS.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MODID, "aid_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.crop"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.XANDER_SEEDS);
                    }).build());

    public static ItemStack makePotionStack(Holder<Potion> potion, Item baseItem){
        ItemStack stack = new ItemStack(baseItem);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
        return stack;
    }
    public static void register(IEventBus eventBus){
        TAB.register(eventBus);
    }

}
