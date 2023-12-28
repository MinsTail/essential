package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.input.Keyboard;

public class speedhack extends ModuleLoader {
    public speedhack() {
        super("speedhack", Keyboard.KEY_L, Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent e) {
        if(mc.player.onGround && !mc.player.isInWater() && !mc.player.isInLava()) {
            double speed = 0.5;
            mc.player.setSprinting(true);
            float yaw = mc.player.rotationYaw * 0.0174532920F;
            if (mc.gameSettings.keyBindForward.isKeyDown()) {
                mc.player.motionX -= MathHelper.sin(yaw) * (speed / 5); // 5
                mc.player.motionZ += MathHelper.cos(yaw) * (speed / 5);
            }

        }
    }
}
