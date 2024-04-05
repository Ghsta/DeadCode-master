package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.class6;
import mahiro.deadcode.deadcode.ui.base.Component;

public class dk
extends be_0 {
    public final /* synthetic */ String f;
    public final /* synthetic */ eJ g;

    public dk(eJ eJ2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, String string2) {
        super(n2, n3, n4, n5, component, eC2, string);
        this.g = eJ2;
        this.f = string2;
    }

    @Override
    public String a() {
        return this.f;
    }

    @Override
    public boolean d() {
        return this.b.equals(class6.g.a.getName());
    }
}

