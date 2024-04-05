/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.world;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.ReflectionUtils;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Timer
extends Hack {
    public DoubleValue a;

    public Timer() {
        super("Timer", HackCategory.World);
        this.b("General");
        this.a = new DoubleValue("Timer", 1.0, 0.1, 10.0);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Changes the game time of the client.";
    }

    @Override
    public void onDisable() {
        ReflectionUtils.setTimerSpeedD(1.0);
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        ReflectionUtils.setTimerSpeedD(this.a.getValue());
        super.onClientTickEvent(clientTickEvent);
    }
}

