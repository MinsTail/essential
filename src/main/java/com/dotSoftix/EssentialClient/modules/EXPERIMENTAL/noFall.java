package com.dotSoftix.EssentialClient.modules.EXPERIMENTAL;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class noFall extends ModuleLoader {
    public noFall() {
        super("No Fall", Keyboard.KEY_NONE, Category.EXPERIMENTAL);
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        e.player.fallDistance = 0;
    }
}
