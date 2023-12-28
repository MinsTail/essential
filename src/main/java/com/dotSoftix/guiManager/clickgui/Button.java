package com.dotSoftix.guiManager.clickgui;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import com.dotSoftix.EssentialClient.guiModes.checkRedanMode;
import com.dotSoftix.EssentialClient.guiModes.checkBlueMode;

import java.awt.*;
import java.io.IOException;

public class Button {
    public Minecraft mc = Minecraft.getMinecraft();

    public int x, y, width, height;
    public boolean binding;
    public ModuleLoader module;

    public Button(int x, int y, int width, int height, ModuleLoader module) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.module = module;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if(checkRedanMode.isRedanModeActivated) {
            //Gui.drawRect(x + 10, y, x + width - 10 + 2, y + height + 2, new Color(0xD8CBCBCB, true).hashCode());
            System.out.println("activated");
            Gui.drawRect(x + 10, y, x + width - 10, y + height, new Color(0xD81C1B1B, true).hashCode());
            mc.fontRenderer.drawStringWithShadow(!binding ? module.name : "< PRESS KEY >", x + width / 2 - mc.fontRenderer.getStringWidth(!binding ? module.name : "< PRESS KEY >") / 2,
                    y + height / 2 - 9 / 2, module.toggled && !binding ? com.dotSoftix.EssentialClient.modules.ui.fadeColor(10) : -1);
        }
        if(checkBlueMode.blueMode) {
            Gui.drawRect(x + 10, y, x + width - 10 + 2, y + height + 2, new Color(0xFF5A7CFF, true).hashCode());
            Gui.drawRect(x + 10, y, x + width - 10, y + height, new Color(0xD81C1B1B, true).hashCode());
            mc.fontRenderer.drawStringWithShadow(!binding ? module.name : "< PRESS KEY >", x + width / 2 - mc.fontRenderer.getStringWidth(!binding ? module.name : "< PRESS KEY >") / 2,
                    y + height / 2 - 9 / 2, module.toggled && !binding ? new Color(0xFF5A7CFF, true).hashCode() : -1);
        }
        if(!checkRedanMode.isRedanModeActivated && !checkBlueMode.blueMode) {
            Gui.drawRect(x + 10, y, x + width - 10 + 2, y + height + 2, com.dotSoftix.EssentialClient.modules.ui.fadeColor(10));
            Gui.drawRect(x + 10, y, x + width - 10, y + height, new Color(0xD81C1B1B, true).hashCode());
            mc.fontRenderer.drawStringWithShadow(!binding ? module.name : "< PRESS KEY >", x + width / 2 - mc.fontRenderer.getStringWidth(!binding ? module.name : "< PRESS KEY >") / 2,
                    y + height / 2 - 9 / 2, module.toggled && !binding ? com.dotSoftix.EssentialClient.modules.ui.fadeColor(10) : -1);
        }


    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (binding) {
            module.keyCode = keyCode;
            binding = false;

            if (keyCode == Keyboard.KEY_ESCAPE) {
                module.keyCode = 0;
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (HoverUtils.hovered(mouseX, mouseY, x, y, x + width, y + height)) {
            if (mouseButton == 0) {
                module.toggle();
            } else if (mouseButton == 2) {
                binding = !binding;
            }
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
    }
}
