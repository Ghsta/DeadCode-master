package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.hacks.render.UserInterface;
import mahiro.deadcode.deadcode.managers.ShaderManager;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class ez
extends ComponentRenderer {
    public ez(Theme theme) {
        super(ComponentType.f, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        ap_0 ap_02 = (ap_0)component;
        int n4 = ap_02.getX();
        int n5 = ap_02.getY();
        int n6 = ap_02.getWidth();
        int n7 = ap_02.getHeight();
        if (((Boolean)UserInterface.b.getObjectValue()).booleanValue()) {
            ShaderManager.b().a(n4, n5, n4 + n6, n5 + n7, 5.0f, 2, er.a(0, 0, 0, 35));
        }
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6), (double)(n5 + n7), aX.i);
        int n8 = 76;
        Wrapper.INSTANCE.g().a("DeadCode".toUpperCase(), n4 + n6 / 2 - n8 / 2 - 2, n5 + n7 / 2 - 5, aX.n);
    }
}

