package net.hawkloon.tutorial.item;

import net.hawkloon.tutorial.TutorialMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class StimpakItem extends Item {
    public StimpakItem(Properties properties){
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if(player.getHealth() < player.getMaxHealth()){
            player.setHealth(player.getMaxHealth());
            player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }
        return super.use(level, player, usedHand);
    }
}
