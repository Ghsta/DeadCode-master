/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.ColorValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;import utils.*;

public class Ambience
extends Hack {
    public static boolean a;
    public static ColorValue b;

    public Ambience() {
        super("Ambience", HackCategory.Render);
        this.b("General");
        b = new ColorValue("Color", aX.i);
        this.a(b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Changes the color of the ambiense.";
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
}

