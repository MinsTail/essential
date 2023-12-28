package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class spider extends ModuleLoader {
    public spider() {
        super("Spider", Keyboard.KEY_NONE, Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent e) {
        if(mc.player.collidedHorizontally){
            mc.player.motionY = 0.5f;
        }
    }
}
