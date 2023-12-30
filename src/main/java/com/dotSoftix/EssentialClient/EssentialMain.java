package com.dotSoftix.EssentialClient;

import com.dotSoftix.Menu.onGuiOpenEvent;
import com.dotSoftix.EssentialClient.keyBinds.keyBind;
import com.dotSoftix.EssentialClient.modules.RENDER.RedanMode;
import com.dotSoftix.EssentialClient.modules.ui;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;


import java.lang.reflect.Field;

@Mod(modid = EssentialMain.MODID, name = EssentialMain.NAME, version = EssentialMain.VERSION)
public class EssentialMain
{
    public static final String MODID = "essential (dotsoftix)";
    public static final String NAME = "essential";
    public static final String VERSION = "1.92";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Display.setTitle("Loading " + ClientMain.clientName);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientMain.clientStartup();
        MinecraftForge.EVENT_BUS.register(new keyBind());
        MinecraftForge.EVENT_BUS.register(new ui());
        MinecraftForge.EVENT_BUS.register(new onGuiOpenEvent());
        //MinecraftForge.EVENT_BUS.register(new RedanMode());
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    public static void setSession(Session s) {
        Class<? extends Minecraft> mc = Minecraft.getMinecraft().getClass();

        try {
            Field session = null;

            for (Field f : mc.getDeclaredFields()) {
                if (f.getType().isInstance(s)) {
                    session = f;
                }
            }

            if (session == null) {
                throw new IllegalStateException("Session Null");
            }

            session.setAccessible(true);
            session.set(Minecraft.getMinecraft(), s);
            session.setAccessible(false);

            ClientMain.clientName = "essential | User: " + Minecraft.getMinecraft().getSession().getUsername();
            Display.setTitle(ClientMain.clientName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
