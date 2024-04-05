/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.value.types;

import classes.DeadCode;
import mahiro.deadcode.deadcode.utils.SoundPlayer;
import mahiro.deadcode.deadcode.value.Value;import utils.*;

public class BooleanValue
extends Value {
    private int a = -1;

    public BooleanValue(String string, boolean bl) {
        super(string, bl);
    }

    public void a(String string) {
        this.c = (Boolean)this.c == false;
        String string2 = (Boolean)this.c != false ? "ON" : "OFF";
        String string3 = String.format("%s \u00a78- \u00a77%s", this.getName(), string);
        int n2 = (Boolean)this.c != false ? aX.i : aX.l;
        DeadCode.p.a(string2, string3, n2, n2, 0.01);
        SoundPlayer.c();
    }

    public void a(int n2) {
        this.a = n2;
    }

    public int a() {
        return this.a;
    }
}

