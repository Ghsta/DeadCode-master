/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.arikia.dev.drpc.DiscordRPC
 */
package mahiro.deadcode.deadcode.hacks.other;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import utils.*;
public class DiscordRPC
extends Hack {
    public static int a = 0;
    public static int b = 0;
    public static BooleanValue c;

    public DiscordRPC() {
        super("DiscordRPC", HackCategory.Other);
        this.d(false);
        c = new BooleanValue("Kill counter", false);
        this.b("General");
        this.a(c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Show discord rich presence.";
    }

    @Override
    public void onDisable() {
        fE.b();
        super.onDisable();
    }
}

