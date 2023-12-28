package com.dotSoftix.EssentialClient.modules.EXPERIMENTAL;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class AirBoost extends ModuleLoader {
    public AirBoost() {
        super("Air Boost", Keyboard.KEY_NONE, Category.MOVEMENT);
    }

    private double speed = 0.01;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        mc.player.noClip = false;
        mc.player.capabilities.isFlying = false;
        if(mc.gameSettings.keyBindJump.isKeyDown()) {
            float yaw = mc.player.rotationYaw * 0.0174532920F;
            if(!mc.player.onGround) {
                mc.player.motionX -= MathHelper.sin(yaw) * (speed / 5); // 5
                mc.player.motionZ += MathHelper.cos(yaw) * (speed / 5);
                speed += 0.001;
            }
        }
        if(!mc.gameSettings.keyBindJump.isKeyDown() || mc.player.collidedHorizontally) {
            speed = 0.01;
        }
    }
}
