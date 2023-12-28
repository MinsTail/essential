package com.dotSoftix.EssentialClient.modules;

import com.dotSoftix.EssentialClient.ClientMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import java.awt.*;

import com.dotSoftix.EssentialClient.guiModes.checkRedanMode;
import com.dotSoftix.EssentialClient.guiModes.checkBlueMode;

import org.lwjgl.opengl.GL11;

import static net.minecraft.client.gui.Gui.drawRect;

public class ui {

    Minecraft mc;
    private EntityPlayer entityPlayer;
    private Entity entity;

    @SubscribeEvent
    public void drawLogo(RenderGameOverlayEvent.Post e) {
        switch (e.getType()) {
            case TEXT:

                int y = 10;
                final int[] counter = {1};
                Minecraft mc = Minecraft.getMinecraft();

                // ------------------------------------------------------ //
                if(checkBlueMode.blueMode) {
                    drawRect(2, 2, 110, 15, new Color(0xFF5A7CFF, true).hashCode());
                    drawRect(3, 3, 110, 15, new Color(0xD81C1B1B, true).hashCode());
                }

                if(checkRedanMode.isRedanModeActivated) {
                    drawRect(2, 2, 110, 15, new Color(0xD8CBCBCB, true).hashCode()); //53
                    drawRect(3, 3, 110, 15, new Color(0xD81C1B1B, true).hashCode());
                }
                if(!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {
                    drawRect(2, 2, 110, 15, fadeColor(10)); //53
                    drawRect(3, 3, 110, 15, new Color(0xD81C1B1B, true).hashCode());
                }
                // ------------------------------------------------------ //

                FontRenderer fontRender = mc.fontRenderer;
                ScaledResolution sr = new ScaledResolution(mc);

                // ------------------------------------------------------ // DRAW ESSENTIAL DEBUG INFO
                if(checkRedanMode.isRedanModeActivated){
                    fontRender.drawString("REDAN | FPS: " + Minecraft.getDebugFPS(), 5, 5, new Color(0xD8FFFFFF, true).hashCode());
                }
                if(checkBlueMode.blueMode) {
                    fontRender.drawString("essential | FPS: " + Minecraft.getDebugFPS(), 5, 5, new Color(0xFF5A7CFF, true).hashCode());
                }
                if(!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {
                    fontRender.drawString("essential | FPS: " + Minecraft.getDebugFPS(), 5, 5, fadeColor(10));
                }
                // ------------------------------------------------------ // DRAW NICK + HEAD
                if (mc.world != null && mc.player != null) {
                    if(!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {

                        drawRect(115, 2, 220, 15, com.dotSoftix.EssentialClient.modules.ui.fadeColor(10));
                        drawRect(116, 3, 220, 15, new Color(0xD81C1B1B, true).hashCode());
                        fontRender.drawString(Minecraft.getMinecraft().getSession().getUsername(), 130, 5, fadeColor(10));
                    }
                    if(checkRedanMode.isRedanModeActivated) {
                        drawRect(115, 2, 220, 15, new Color(0xD8CBCBCB, true).hashCode());
                        drawRect(116, 3, 220, 15, new Color(0xD81C1B1B, true).hashCode());
                        fontRender.drawString(Minecraft.getMinecraft().getSession().getUsername(), 130, 5, new Color(0xD8FFFFFF, true).hashCode());
                    }
                    if(checkBlueMode.blueMode) {
                        drawRect(115, 2, 220, 15, new Color(0xFF5A7CFF, true).hashCode());
                        drawRect(116, 3, 220, 15, new Color(0xD81C1B1B, true).hashCode());
                        fontRender.drawString(Minecraft.getMinecraft().getSession().getUsername(), 130, 5, new Color(0xFF5A7CFF, true).hashCode());
                    }
                    try {
                        drawHead drawHead = new drawHead(); // 116 3
                        drawHead.drawHead(116, 3);

                    } catch (Exception ignored) {}
                }
                /////////////////////////////////////////////////////////////// DRAW MODULES
                for (ModuleLoader moduleLoader : ClientMain.modules) {
                    if (moduleLoader.toggled) {
                        if(!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {
                            drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2, y + 10, fadeColor(counter[0] * 300));

                            fontRender.drawString(moduleLoader.name, sr.getScaledWidth() - 4 - fontRender.getStringWidth(moduleLoader.name),
                                    y, fadeColor(counter[0] * 300));
                        }
                        if(checkBlueMode.blueMode) {
                            drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2, y + 10, new Color(0xFF5A7CFF, true).hashCode());

                            fontRender.drawString(moduleLoader.name, sr.getScaledWidth() - 4 - fontRender.getStringWidth(moduleLoader.name),
                                    y, new Color(0xFF5A7CFF, true).hashCode());
                        }
                        if(checkRedanMode.isRedanModeActivated) {
                            drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2, y + 10, new Color(0xD81C1B1B, true).hashCode());

                            fontRender.drawString(moduleLoader.name, sr.getScaledWidth() - 4 - fontRender.getStringWidth(moduleLoader.name),
                                    y, new Color(0xD8CBCBCB, true).hashCode());
                        }
                        y = y + 10;
                        counter[0]++;
                    }
                }


            default:
                break;
        }
    }


    public static int fadeColor(int delay) {
        double fadePos = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        fadePos %= 360;
        return Color.getHSBColor((float) (fadePos / 360.0f), 0.5f, 1f).getRGB();
    }
}

class drawHead {
    Minecraft mc = Minecraft.getMinecraft();
    ResourceLocation skin = mc.player.getLocationSkin();
    public void drawHead(int width, int height) {
        GL11.glColor4f(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(mc.player.getLocationSkin());
        Gui.drawScaledCustomSizeModalRect(width, height, 8, 8, 8, 8, 11, 11, 64, 64);
    }
}