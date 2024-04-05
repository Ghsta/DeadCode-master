/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hacks.combat.KillAura;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Item360
extends Hack {
    public static boolean a;
    public static ModeValue b;
    public static DoubleValue c;
    public static BooleanValue d;

    public Item360() {
        super("Item360", HackCategory.Render);
        this.b("General");
        b = new ModeValue("Axis", new Mode("Axis-X", true), new Mode("Axis-Y"));
        c = new DoubleValue("Speed", 0.4, 0.1, 1.0);
        d = new BooleanValue("Only with KillAura", false);
        this.a(b, c, d);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Rotates your item in your hand.";
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        a = true;
        super.onClientTickEvent(clientTickEvent);
    }

    public static boolean b() {
        return a && ((Boolean)d.getObjectValue() == false || (Boolean)d.getObjectValue() != false && KillAura.J != null);
    }
}

