package com.dotSoftix.EssentialClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class ModuleLoader {
    public String name;
    public boolean toggled;
    public int keyCode;
    public Category category;
    public Minecraft mc = Minecraft.getMinecraft();

    public ModuleLoader(String name, int key, Category c) {
        this.name = name;
        this.keyCode = key;
        this.category = c;
    }

    public boolean isEnabled() {
        return toggled;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable(){
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void setKey(int key){
        this.keyCode = key;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return this.name;
    }
    public void disable() {
        toggled = false;
    }

    public void onUpdate() {

    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public enum Category {
        MOVEMENT,
        RENDER,
        COMBAT,
        EXPLOIT,
        EXPERIMENTAL;
    }

    public void setToggled() {
        this.toggled = toggled;
        if (this.toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }
}
