/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.client.event.InputUpdateEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputUpdateEvent;

public class AutoWalk
extends Hack {
    public BooleanValue a = new BooleanValue("Auto jump", false);

    public AutoWalk() {
        super("AutoWalk", HackCategory.Movement);
        this.b("General");
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatic walking.";
    }

    @Override
    public void onDisable() {
        this.a(false);
        super.onDisable();
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        this.a(true);
        super.onInputEvent(inputUpdateEvent);
    }

    public void a(boolean bl) {
        KeyBinding.setKeyBindState((int) Wrapper.INSTANCE.getGameSettings().keyBindForward.getKeyCode(), (boolean)bl);
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)bl);
        }
    }
}

