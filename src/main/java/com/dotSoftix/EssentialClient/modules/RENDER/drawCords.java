package com.dotSoftix.EssentialClient.modules.RENDER;

import com.dotSoftix.EssentialClient.guiModes.checkBlueMode;
import com.dotSoftix.EssentialClient.guiModes.checkRedanMode;
import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import com.dotSoftix.EssentialClient.modules.ui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static net.minecraft.client.gui.Gui.drawRect;

public class drawCords extends ModuleLoader {
    public drawCords() {
        super("draw cords", Keyboard.KEY_NONE, Category.RENDER);
    }

    @SubscribeEvent
    public void drawLogo(RenderGameOverlayEvent.Post event) {
        switch (event.getType()) {
            case TEXT:
                FontRenderer fontRender = mc.fontRenderer;
                //////////////////////////////////////////////////////// DRAW CORDS
                if (mc.world != null && mc.player != null) {
                    if (!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {
                        drawRect(2, 20, 50, 55, ui.fadeColor(10));
                        drawRect(3, 21, 50, 55, new Color(0xD81C1B1B, true).hashCode());
                        fontRender.drawString("X: " + (int) mc.player.posX, 6, 23, ui.fadeColor(10));
                        fontRender.drawString("Z: " + (int) mc.player.posZ, 6, 33, ui.fadeColor(10));
                        fontRender.drawString("Y: " + (int) mc.player.posY, 6, 43, ui.fadeColor(10));
                    }
                    if (checkRedanMode.isRedanModeActivated) {
                        drawRect(2, 20, 50, 55, new Color(0xD8CBCBCB, true).hashCode());
                        drawRect(3, 21, 50, 55, new Color(0xD81C1B1B, true).hashCode());
                    }
                    if (checkBlueMode.blueMode) {
                        drawRect(2, 20, 50, 55, new Color(0xFF5A7CFF, true).hashCode());
                        drawRect(3, 21, 50, 55, new Color(0xD81C1B1B, true).hashCode());
                    }

                }

            default:
                break;
    }   }
}
