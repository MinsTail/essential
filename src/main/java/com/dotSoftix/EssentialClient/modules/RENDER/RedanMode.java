package com.dotSoftix.EssentialClient.modules.RENDER;

import com.dotSoftix.EssentialClient.guiModes.checkRedanMode;
import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import com.dotSoftix.Menu.RDPMenu;
import com.dotSoftix.Utils.ChatUtils;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import com.dotSoftix.EssentialClient.guiModes.checkBlueMode;

public class RedanMode extends ModuleLoader {
    public RedanMode() {
        super("redan mode", Keyboard.KEY_NONE, Category.RENDER);
    }

    @Override
    public void onEnable() {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI("https://www.youtube.com/watch?v=bf5FGXC-mHY"));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        RDPMenu.texture = new ResourceLocation("redan.jpg");
        checkBlueMode.blueMode = false;
        checkRedanMode.isRedanModeActivated = true;
        ChatUtils.sendMessage("REDAN MODE ENABLED");

    }

    @Override
    public void onDisable() {
        RDPMenu.texture = new ResourceLocation("Solid_black.png");
        checkRedanMode.isRedanModeActivated = false;
        ChatUtils.sendMessage("REDAN MODE DISABLED");
    }
}
