/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  org.lwjgl.input.Keyboard
 */
package mahiro.deadcode.deadcode.hacks.player;

import classes.DeadCode;
import mahiro.deadcode.deadcode.excluded.UIScreen;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.MovementInput;
import net.minecraftforge.client.event.InputUpdateEvent;
import org.lwjgl.input.Keyboard;
import utils.*;
public class GuiWalk
extends Hack {
    public GuiWalk() {
        super("GuiWalk", HackCategory.Player);
    }

    @Override
    public String getDescription() {
        return "Allows you to walk while the gui is open.";
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        Object object;
        if (!(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiContainer) && !(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen)) {
            return;
        }
        if (DeadCode.s.sbbb() != null && DeadCode.s.sb().k() != null) {
            object = DeadCode.s.sb().k().a();
            if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen && DeadCode.s.sb().k().a().a != null && DeadCode.s.sb().k().a().a.e
            == aT.c) {
                return;
            }
        }
        object = Wrapper.INSTANCE.getGameSettings();
        MovementInput movementInput = inputUpdateEvent.getMovementInput();
        movementInput.moveStrafe = 0.0f;
        movementInput.moveForward = 0.0f;
        if (Keyboard.isKeyDown((int)Wrapper.INSTANCE.getGameSettings().keyBindForward.getKeyCode())) {
            movementInput.moveForward += 1.0f;
            movementInput.forwardKeyDown = true;
        } else {
            movementInput.forwardKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)Wrapper.INSTANCE.getGameSettings().keyBindBack.getKeyCode())) {
            movementInput.moveForward -= 1.0f;
            movementInput.backKeyDown = true;
        } else {
            movementInput.backKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)Wrapper.INSTANCE.getGameSettings().keyBindLeft.getKeyCode())) {
            movementInput.moveStrafe += 1.0f;
            movementInput.leftKeyDown = true;
        } else {
            movementInput.leftKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)Wrapper.INSTANCE.getGameSettings().keyBindRight.getKeyCode())) {
            movementInput.moveStrafe -= 1.0f;
            movementInput.rightKeyDown = true;
        } else {
            movementInput.rightKeyDown = false;
        }
        movementInput.jump = Keyboard.isKeyDown((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode());
        super.onInputEvent(inputUpdateEvent);
    }
}

