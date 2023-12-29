/*
package com.dotSoftix.EssentialClient.netUtils;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.dotSoftix.EssentialClient.EssentialMain;

public interface Wrapper {

    // minecraft instance
    Minecraft mc = Minecraft.getMinecraft();

    default boolean nullCheck() {
        return mc.player != null && mc.world != null;
    }


    default Logger getLogger() {
        return LogManager.getLogger(EssentialMain.NAME + " | " + EssentialMain.VERSION);
    }
}

 */