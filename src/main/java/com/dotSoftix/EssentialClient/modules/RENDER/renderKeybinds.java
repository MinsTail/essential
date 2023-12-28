package com.dotSoftix.EssentialClient.modules.RENDER;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;

public class renderKeybinds extends ModuleLoader {
    public renderKeybinds() {
        super("render keybinds", Keyboard.KEY_NONE, Category.RENDER);
    }

    @Override
    public void onEnable() {

    }
}
