package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;

public class da
extends ComponentRenderer {
    public da(Theme theme) {
        super(ComponentType.b, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        fu fu2 = (fu)component;
        fu2.a(n2, n3);
    }
}

