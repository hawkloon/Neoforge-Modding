package net.hawkloon.tutorial.potion;

import net.hawkloon.tutorial.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTION =
            DeferredRegister.create(BuiltInRegistries.POTION, TutorialMod.MODID);

    public static final MobEffectInstance EFFECT_INSTANCE = new MobEffectInstance(
            MobEffects.HEAL,
            450,
            5,
            false,
            false,
            true


    );
    public static final Holder<Potion> NUKA_COLA = POTION.register("nuka_cola",
            registryName -> new Potion(
                    registryName.getPath(),
                    new MobEffectInstance(EFFECT_INSTANCE)

            ));

    public static void register(IEventBus eventBus){
        POTION.register(eventBus);
    }
}
