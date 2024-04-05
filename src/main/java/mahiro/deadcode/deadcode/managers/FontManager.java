/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.managers;

import classes.class11;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import utils.*;
public class FontManager {
    private bu a;
    private bu b;
    private bu c;
    private bu d;
    private bu e;
    private bu f;
    private bu g;
    private bu h;
    private bu i;
    private bu j;
    private bu k;
    private bu l;

    public FontManager() {
        String[] stringArray = class11.a();
        this.a = class11.a(stringArray[0], 18, true, true);
        this.b = class11.a(stringArray[1], 24, true, true);
        this.c = class11.a(stringArray[2], 24, true, true);
        this.d = class11.a(stringArray[2], 28, true, true);
        this.e = class11.a(stringArray[2], 18, true, true);
        this.f = class11.a(stringArray[2], 14, true, true);
        this.g = class11.a(stringArray[2], 7, true, true);
        this.h = class11.a(stringArray[3], 24, true, true);
        this.i = class11.a(stringArray[3], 18, true, true);
        this.j = class11.a(stringArray[3], 14, true, true);
        this.k = class11.a(stringArray[4], 18, true, true);
        this.l = class11.a(stringArray[4], 14, true, true);
        ChatUtils.debug("FontManager: initialized.");
    }

    public bu a() {
        return this.a;
    }

    public bu b() {
        return this.b;
    }

    public bu c() {
        return this.c;
    }

    public bu d() {
        return this.d;
    }

    public bu e() {
        return this.e;
    }

    public bu f() {
        return this.f;
    }

    public bu g() {
        return this.g;
    }

    public bu h() {
        return this.h;
    }

    public bu i() {
        return this.i;
    }

    public bu j() {
        return this.j;
    }

    public bu k() {
        return this.k;
    }

    public bu l() {
        return this.l;
    }
}

