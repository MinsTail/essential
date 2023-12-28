package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Jesus extends ModuleLoader{
    public Jesus() {
        super("Jesus", Keyboard.KEY_NONE, Category.MOVEMENT);
    }


    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent e) {
        if(mc.player.isInWater()) {
            mc.player.setSprinting(true);
            mc.player.motionY = mc.player.jumpMovementFactor + (float) 0.1;

            if(mc.player.collidedHorizontally) {
                mc.player.motionY = mc.player.jumpMovementFactor + (float) 0.5;
            }
        }
    }
}
