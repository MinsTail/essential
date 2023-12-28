package com.dotSoftix.EssentialClient.modules.RENDER;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;

public class shulkerPrev extends ModuleLoader {
    public static shulkerPrev INSTANCE;

    public shulkerPrev() {
        super("shulkerPrev", Keyboard.KEY_NONE, Category.RENDER);
    }

}
