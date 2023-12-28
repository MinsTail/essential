package com.dotSoftix.EssentialClient.modules.RENDER;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import java.util.ArrayList;
import java.util.List;

public class glowESP extends ModuleLoader {
    public glowESP() {
        super("glow ESP", Keyboard.KEY_NONE, Category.RENDER);
    }
    private static List<Entity> glowed = new ArrayList<>();
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (EntityPlayer playerEntity : mc.world.playerEntities) {
            if (playerEntity != mc.player && playerEntity != glowed) {
                playerEntity.setGlowing(true);
                glowed.add(playerEntity);
            }
        }
    }

    @Override
    public void onDisable() {
        for (Entity entity : glowed) {
            entity.setGlowing(false);
        }
        glowed.clear();

        super.onDisable();
    }
}
