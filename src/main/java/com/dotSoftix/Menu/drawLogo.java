package com.dotSoftix.Menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class drawLogo {
    public static void drawString(final double scale, final String text,
                                  final float x, final float y, final int color) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);
        //Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
        Minecraft.getMinecraft().fontRenderer.drawString(text, (int) x, (int) y, color);
        GlStateManager.popMatrix();
    }
}
