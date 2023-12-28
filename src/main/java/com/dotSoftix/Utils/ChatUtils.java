package com.dotSoftix.Utils;

import com.dotSoftix.EssentialClient.ClientMain;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {
    private static final String prefix = "[" + ClientMain.clientName + "§f] ";

    public static void sendMessage(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(prefix + msg));
    }
}
