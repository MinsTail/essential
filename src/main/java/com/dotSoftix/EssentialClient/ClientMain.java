package com.dotSoftix.EssentialClient;

import com.dotSoftix.EssentialClient.modules.COMBAT.Aura;
import com.dotSoftix.EssentialClient.modules.COMBAT.TriggerBot;
import com.dotSoftix.EssentialClient.modules.EXPERIMENTAL.NoWeather;
import com.dotSoftix.EssentialClient.modules.EXPLOITS.*;
import com.dotSoftix.EssentialClient.modules.MENUCUSTOM.setColor;
import com.dotSoftix.EssentialClient.modules.MOVEMENT.*;
import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import com.dotSoftix.EssentialClient.modules.RENDER.*;
import com.dotSoftix.EssentialClient.modules.EXPERIMENTAL.*;
import com.dotSoftix.guiManager.clickgui.ClickGuiScreen;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;

public class ClientMain {
    private final static double modVersion = 1.92;
    public static String clientName = "essential " + modVersion;
    public static CopyOnWriteArrayList<ModuleLoader> modules = new CopyOnWriteArrayList<ModuleLoader>();

    public static ClickGuiScreen clickGui;

    public static void clientStartup() {
        Display.setTitle(clientName);

        modules.add(new Fly());
        modules.add(new Sprint());
        modules.add(new speedhack());
        modules.add(new FullBright());
        modules.add(new reachDistance());
        modules.add(new RedanMode());
        modules.add(new ultraFlight());
        modules.add(new Jesus());
        modules.add(new AirJump());
        modules.add(new TargetHud());
        modules.add(new Tracers());
        modules.add(new glowESP());
        modules.add(new NameTags());
        modules.add(new Velocity());
        modules.add(new InvWalk());
        modules.add(new JesusGlide());
        modules.add(new Glide());
        modules.add(new FakeCreative());
        modules.add(new ViewModel());
        modules.add(new spider());
        // -- combat -- //
        modules.add(new Aura());
        modules.add(new TriggerBot());
        // -- combat -- //

        // -- EXPERIMENTAL -- //
        modules.add(new AirBoost());
        modules.add(new NoWeather());
        modules.add(new noFall());
        modules.add(new packetLoss());
        modules.add(new setColor());
        modules.add(new drawCords());

        clickGui = new ClickGuiScreen();
    }
    public static void keyPress(int key) {
        for (ModuleLoader m : modules) {
            if (m.getKeyCode() == key) {
                m.toggle();
            }
        }
    }
}
