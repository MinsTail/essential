package com.dotSoftix.EssentialClient.modules.COMBAT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.EnumHand;
import java.util.Comparator;

public class Aura extends ModuleLoader {
    public Aura() {
        super("Aura", Keyboard.KEY_NONE, Category.COMBAT);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        double range = 4.6F;
        EntityPlayer target  = mc.world.playerEntities.stream().filter(entityPlayer -> entityPlayer != mc.player).min(Comparator.comparing(entityPlayer ->
                entityPlayer.getDistance(mc.player))).filter(entityPlayer -> entityPlayer.getDistance(mc.player) <= range).orElse(null);

        if (target != null) {
            if (mc.player.getCooledAttackStrength(0) == 1) {
                mc.playerController.attackEntity(mc.player, target);
                mc.player.swingArm(EnumHand.MAIN_HAND);
                mc.player.resetCooldown();
            }
        }
    }
}
