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

public class CustomRain
extends Hack {
    public static boolean a;
    public static ColorValue b;

    public CustomRain() {
        super("CustomRain", HackCategory.Render);
        this.b("General");
        b = new ColorValue("Color", aX.i);
        this.a(b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Custom rain.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        a = true;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }
}

