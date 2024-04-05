package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.managers.ShaderManager;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class ae
extends ComponentRenderer {
    public ae(Theme theme) {
        super(ComponentType.k, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        bh bh2 = (bh)component;
        int n4 = bh2.getX();
        int n5 = bh2.getY();
        int n6 = bh2.getWidth();
        int n7 = bh2.getHeight();
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6), (double)(n5 + n7), aX.f);
        float f2 = n4 + 2;
        float f3 = n5 + 2;
        float f4 = n4 + n6 - 2;
        float f5 = n5 + n7 - 2;
        int n8 = er.b(bh2.e, 0.2f);
        ShaderManager.b().a(f2, f3, f4, f5, 7.0f, 2, n8);
        ShaderManager.c().a(f2, f3, f4, f5, 3.0f, bh2.e);
        RenderUtils.a(bh2.c.e(), f2 + 2.0f + bh2.f, f3 + 2.0f + bh2.g, bh2.c.a(), bh2.c.b(), false, bh2.c.hashCode());
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        if (bh2.d != null) {
            Wrapper.INSTANCE.q().a(bh2.d, f2 + bh2.c.a() + 6.0f, f3 + 4.5f, aX.g);
        }
    }
}

