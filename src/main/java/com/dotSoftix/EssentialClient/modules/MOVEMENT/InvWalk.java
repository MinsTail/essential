package com.dotSoftix.EssentialClient.modules.MOVEMENT;

import com.dotSoftix.EssentialClient.modules.ModuleLoader;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class InvWalk extends ModuleLoader {
    public InvWalk() {
        super("Inv walk", Keyboard.KEY_NONE, Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e) {
        if (!(mc.currentScreen instanceof GuiChat) && !(mc.currentScreen instanceof GuiContainer) && !(mc.currentScreen instanceof com.dotSoftix.guiManager.clickgui.ClickGuiScreen)) {
            mc.gameSettings.thirdPersonView = 0;
            return;
        }

        double speed = 0.05;

        if (!mc.player.onGround) {
            speed /= 4.0;
        }

        handleJump();
        handleForward(speed);

        if (!mc.player.onGround) {
            speed /= 2.0;
        }

        handleBack(speed);
        handleLeft(speed);
        handleRight(speed);
    }

    void moveForward(double speed) {
        float direction = getDirection();
        mc.player.motionX -= (double)(MathHelper.sin(direction) * speed);
        mc.player.motionZ += (double)(MathHelper.cos(direction) * speed);
    }

    void moveBack(double speed) {
        float direction = getDirection();
        mc.player.motionX += (double)(MathHelper.sin(direction) * speed);
        mc.player.motionZ -= (double)(MathHelper.cos(direction) * speed);
    }

    void moveLeft(double speed) {
        float direction = getDirection();
        mc.player.motionZ += (double)(MathHelper.sin(direction) * speed);
        mc.player.motionX += (double)(MathHelper.cos(direction) * speed);
    }

    void moveRight(double speed) {
        float direction = getDirection();
        mc.player.motionZ -= (double)(MathHelper.sin(direction) * speed);
        mc.player.motionX -= (double)(MathHelper.cos(direction) * speed);
    }


    void handleForward(double speed) {
        if(!Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()))
            return;
        moveForward(speed);
    }

    void handleBack(double speed) {
        if(!Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()))
            return;
        moveBack(speed);
    }

    void handleLeft(double speed) {
        if(!Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode()))
            return;
        moveLeft(speed);
    }

    void handleRight(double speed) {
        if(!Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()))
            return;
        moveRight(speed);
    }

    void handleJump() {
        if (mc.player.onGround && Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode())) {
            mc.player.jump();
        }
    }

    public static float getDirection() {
        Minecraft mc = Minecraft.getMinecraft();

        float var1 = mc.player.rotationYaw;

        if (mc.player.moveForward < 0.0f) {
            var1 += 180.0f;
        }

        float forward = 1.0f;

        if (mc.player.moveForward < 0.0f) {
            forward = -0.5f;
        } else if (mc.player.moveForward > 0.0F) {
            forward = 0.5f;
        } if (mc.player.moveStrafing > 0.0f) {
            var1 -= 90.0f * forward;
        } if (mc.player.moveStrafing < 0.0f) {
            var1 += 90.0f * forward;
        }

        var1 *= 0.017453292f;
        return  var1;
    }
}

