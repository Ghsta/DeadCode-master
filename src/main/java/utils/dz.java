package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.managers.ShaderManager;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;

public class dz
extends ComponentRenderer {
    public dz(Theme theme) {
        super(ComponentType.i, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        bg bg2 = (bg)component;
        int n4 = bg2.getX();
        int n5 = bg2.getY();
        int n6 = bg2.getWidth();
        int n7 = bg2.getHeight();
        if (!bg2.d()) {
            return;
        }
        aX.a(n4, n5, n4 + n6, n5 + n7);
        int n8 = 3;
        int n9 = n4 + n8;
        int n10 = n5 + n8;
        int n11 = n4 + n6 - n8;
        int n12 = 20;
        bg2.c.f();
        ShaderManager.b().a(n9 + 1, n10 += n12 + 4, n11 - 1, n10 + 1, 15.0f, 3, aX.f);
        RenderUtils.a((double)(n9 + 1), (double)n10, (double)(n11 - 1), (double)(n10 + 1), aX.i);
        bg2.a(n2, n3);
    }
}

