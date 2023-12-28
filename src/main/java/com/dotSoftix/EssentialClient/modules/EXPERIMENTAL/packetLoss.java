package com.dotSoftix.EssentialClient.modules.EXPERIMENTAL;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;

public class packetLoss extends ModuleLoader {
    public packetLoss() {
        super("packet loss", Keyboard.KEY_NONE, Category.EXPERIMENTAL);
    }

    @Override
    public void onEnable() {
        mc.player.setDead();
    }
}
