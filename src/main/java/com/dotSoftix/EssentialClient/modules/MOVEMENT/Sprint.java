package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Sprint extends ModuleLoader{
    public Sprint() {
        super("Sprint", Keyboard.KEY_P, ModuleLoader.Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.moveForward > 0) {
            mc.player.setSprinting(true);
        }
    }
}
