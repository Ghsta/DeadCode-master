/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.ui.components;

import mahiro.deadcode.deadcode.managers.ShaderManager;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import utils.*;
public class ComponentSlider
extends ComponentRenderer {
    public ComponentSlider(Theme theme) {
        super(ComponentType.SLIDER, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        dc dc2 = (dc)component;
        int n4 = dc2.getX();
        int n5 = dc2.getY();
        int n6 = dc2.getWidth();
        int n7 = dc2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(dc2.b.getName(), n4 + 4, n5 + 5, aX.h);
        float f2 = n5 + 17;
        String string = "Drag slider for change value.";
        Wrapper.INSTANCE.o().a(string, n4 + 4, f2, aX.m);
        long l2 = System.currentTimeMillis();
        float f3 = f2 + 9.0f;
        float f4 = 5.0f;
        double d2 = (double)dc2.j * dc2.g;
        double d3 = dc2.n + (d2 - dc2.n) * Math.pow((double)(l2 - dc2.m) / 125.0, 0.5);
        RenderUtils.a((double)dc2.i, (double)f3, (double)(dc2.i + dc2.j), (double)(f3 + f4), aX.f);
        int n8 = er.b(aX.i, 0.3f);
        ShaderManager.b().a(dc2.i + 1, f3 + 1.0f, (float)((double)dc2.i + d3 - 1.0), f3 + f4 - 1.0f, 14.0f, 4, n8);
        RenderUtils.a((double)(dc2.i + 1), (double)(f3 + 1.0f), (double)dc2.i + d3 - 1.0, (double)(f3 + f4 - 1.0f), aX.i);
        RenderUtils.a((double)dc2.i + d3 - 2.0, (double)(f3 - 1.0f), (double)dc2.i + d3 + 1.0, (double)(f3 + f4 + 1.0f), aX.h);
        float f5 = dc2.i;
        float f6 = f3 + f4 + 4.0f;
        float f7 = 9.0f;
        if (dc2.c) {
            String string2 = String.format("~$: v=%s", dc2.b.getObjectValue());
            float f8 = Wrapper.INSTANCE.o().a(string2);
            RenderUtils.a((double)f5, (double)f6, (double)(f5 + f8 + 10.0f), (double)(f6 + f7), (double)f7, aX.n);
            Wrapper.INSTANCE.o().a(string2, f5 + 2.0f, f6 + 3.0f, aX.h);
        } else {
            String string3 = RenderUtils.a(dc2.g, 2);
            String string4 = "~$: 0-";
            String string5 = "-1";
            float f9 = 19.0f;
            float f10 = Wrapper.INSTANCE.o().a(string3);
            float f11 = 6.0f;
            RenderUtils.a((double)f5, (double)f6, (double)(f5 + (f9 + f10 + f11) + 10.0f), (double)(f6 + f7), (double)f7, aX.n);
            Wrapper.INSTANCE.o().a(string4, f5 + 2.0f, f6 + 3.0f, aX.h);
            Wrapper.INSTANCE.o().a(string3, f5 + 2.0f + f9, f6 + 3.0f, aX.i);
            Wrapper.INSTANCE.o().a(string5, f5 + 2.0f + f9 + f10, f6 + 3.0f, aX.h);
        }
        dc2.n = d3;
        dc2.m = l2;
    }
}

