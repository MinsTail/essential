package com.dotSoftix.EssentialClient.modules.EXPERIMENTAL;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class motionFly extends ModuleLoader {
    public motionFly() {
        super("motion Fly", Keyboard.KEY_NONE, Category.EXPERIMENTAL);
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        float yaw = mc.player.rotationYaw * 0.0174532920F;
        double speed = 0.5;
        if(mc.player != null && mc.world != null) {
            e.player.noClip = true;
            e.player.onGround = false;
            e.player.capabilities.isFlying = true;
            if(mc.gameSettings.keyBindForward.isKeyDown()) {
                mc.player.motionX -= MathHelper.sin(yaw) * (speed / 5); // 5
                mc.player.motionZ += MathHelper.cos(yaw) * (speed / 5);
            }
        }
    }
}
