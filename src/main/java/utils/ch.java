package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.DeadCode;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.unknown.Unknown6;

import java.util.ArrayList;

public class ch
extends dp {
    public Unknown6 a = null;
    public eC b = DeadCode.n.a("Other", "Arrows");

    public ch(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.d, component);
    }

    private /* synthetic */ aD e() {
        return DeadCode.s.sb().k().a().a;
    }

    public boolean a() {
        aD aD2 = this.e();
        return aD2 == null || aD2.e == null;
    }

    @Override
    public ArrayList<Component> b() {
        aD aD2 = this.e();
        if (aD2 == null) {
            return new ArrayList();
        }
        return aD2.b();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (!this.a()) {
            return;
        }
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.onMousePress(n2, n3, n4);
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        this.d();
        super.c(n2, n3);
    }

    @Override
    public void c() {
        for (Component component : this.b()) {
            component.c();
        }
        super.c();
    }

    @Override
    public void c(int n2, int n3, int n4) {
        this.c(n4);
        super.c(n2, n3, n4);
    }

    public void d() {
        this.o();
        int n2 = 4;
        int n3 = 3;
        for (Component component : this.b()) {
            int n4 = this.getY() + n3;
            component.b(n4);
            component.setXY(this.getX() + 3, (int)((double)component.g() + this.s));
            n3 += component.getHeight() + n2;
        }
        this.t = n3;
    }
}

