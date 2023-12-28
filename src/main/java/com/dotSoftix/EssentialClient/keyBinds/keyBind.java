package com.dotSoftix.EssentialClient.keyBinds;

import com.dotSoftix.EssentialClient.ClientMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class keyBind {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(Keyboard.getEventKey())) {
            if (Keyboard.getEventKey() != Keyboard.KEY_NONE) {
                ClientMain.keyPress(Keyboard.getEventKey());
                if (Keyboard.getEventKey() == Keyboard.KEY_RSHIFT) {
                    Minecraft mc = Minecraft.getMinecraft();
                    mc.player.playSound(SoundEvents.BLOCK_NOTE_CHIME, 1.0f, 1.0f);
                    Minecraft.getMinecraft().displayGuiScreen(ClientMain.clickGui);
                }
            }

        }
    }
}
