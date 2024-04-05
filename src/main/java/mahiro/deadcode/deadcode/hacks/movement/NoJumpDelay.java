/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.ReflectionUtils;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoJumpDelay
extends Hack {
    public NoJumpDelay() {
        super("NoJumpDelay", HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Remove jump delay.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        ReflectionUtils.resetJumpTicks();
        super.onClientTickEvent(clientTickEvent);
    }
}

