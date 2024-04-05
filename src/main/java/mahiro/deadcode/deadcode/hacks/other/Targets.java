/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.other;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Targets
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public BooleanValue c;
    public static boolean d;
    public static boolean e;
    public static boolean f;

    public Targets() {
        super("Targets", HackCategory.Other);
        this.d(false);
        this.c(true);
        this.g(false);
        this.b("Target");
        this.a = new BooleanValue("Players", true);
        this.b = new BooleanValue("Mobs", false);
        this.c = new BooleanValue("Invisibles", false);
        this.a(this.a, this.b, this.c);
    }

    @Override
    public String getDescription() {
        return "Manage targets for hacks.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        d = (Boolean)this.a.getObjectValue();
        e = (Boolean)this.b.getObjectValue();
        f = (Boolean)this.c.getObjectValue();
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        this.c(true);
        super.onDisable();
    }
}

