package com.dotSoftix.EssentialClient.modules.EXPERIMENTAL;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;

public class NoWeather extends ModuleLoader {
    public NoWeather() {
        super("NoWeather", Keyboard.KEY_NONE, Category.EXPERIMENTAL);
    }

    @Override
    public void onEnable() {
        mc.world.setRainStrength(0);
        mc.world.setWorldTime(6000);
    }
}
