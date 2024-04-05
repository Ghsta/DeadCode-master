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

public class EnchantColor
extends Hack {
    public static boolean a;
    public static ColorValue b;
    public static ColorValue c;

    public EnchantColor() {
        super("EnchantColor", HackCategory.Render);
        this.b("General");
        b = new ColorValue("Color one", aX.i);
        c = new ColorValue("Color two", aX.j);
        this.a(b, c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Change color for enchanted items.";
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

