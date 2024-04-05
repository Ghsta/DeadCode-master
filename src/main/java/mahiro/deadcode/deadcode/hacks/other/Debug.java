/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.other;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Debug
extends Hack {
    public static boolean toggled;

    public Debug() {
        super("Debug", HackCategory.Other);
    }

    @Override
    public String getDescription() {
        return "Show debug messages.";
    }

    @Override
    public void onDisable() {
        toggled = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        toggled = true;
        super.onClientTickEvent(clientTickEvent);
    }
}

