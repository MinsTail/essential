package com.dotSoftix.EssentialClient.modules.MENUCUSTOM;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;
import com.dotSoftix.EssentialClient.guiModes.checkBlueMode;
import com.dotSoftix.EssentialClient.guiModes.checkRedanMode;

public class setColor extends ModuleLoader {
    public setColor() {
        super("blue menu", Keyboard.KEY_NONE, Category.RENDER);
    }

    @Override
    public void onEnable() {
        checkRedanMode.isRedanModeActivated = false;
        checkBlueMode.blueMode = true;
    }
    @Override
    public void onDisable() {
        checkBlueMode.blueMode = false;
    }
}
