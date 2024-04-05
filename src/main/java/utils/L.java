package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class L
extends ComponentRenderer {
    public L(Theme theme) {
        super(ComponentType.m, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        bi bi2 = (bi)component;
        int n4 = bi2.getX();
        int n5 = bi2.getY();
        Wrapper.INSTANCE.n().a(bi2.a, n4, n5, aX.h);
    }
}

