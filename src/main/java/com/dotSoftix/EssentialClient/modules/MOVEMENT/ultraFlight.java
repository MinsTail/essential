package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class ultraFlight extends ModuleLoader {
    public ultraFlight() {
        super("Flight Exploit", Keyboard.KEY_NONE, Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent e) {
        float speed = (float) 10000;

        mc.player.noClip = true;
        mc.player.fallDistance = 0;
        mc.player.onGround = false;

        mc.player.capabilities.isFlying = false;

        mc.player.motionX = 0;
        mc.player.motionY = 0;
        mc.player.motionZ = 0;

        mc.player.jumpMovementFactor = speed;

        if (mc.gameSettings.keyBindJump.isKeyDown()) {
            mc.player.motionY += speed;
        } if (mc.gameSettings.keyBindSneak.isKeyDown()) {
            mc.player.motionY -= speed;
        }
    }
}
