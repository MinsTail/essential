package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Glide extends ModuleLoader {
    public Glide() {
        super("Glide", Keyboard.KEY_NONE, Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.fallDistance != 0 && mc.player.motionY != 0) {
            mc.player.motionY = -0.125;
        }
    }
}
