package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;

public class Fly extends ModuleLoader {
    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    int flySpeed = 1;

    public void changeSpeed(int event){
        if (flySpeed >= 1) {
            if (event == 1) {
                flySpeed = flySpeed + 200;
            }
            if (event == 2) {
                flySpeed = 1;
            }
        }
    }

    @Override
    public void onEnable() {
        mc.player.capabilities.setFlySpeed(flySpeed + 1);
        mc.player.capabilities.allowFlying = true;
        mc.player.capabilities.isFlying = true;
    }

    @Override
    public void onDisable() {
        mc.player.capabilities.allowFlying = false;
        mc.player.capabilities.isFlying = false;
    }
}
