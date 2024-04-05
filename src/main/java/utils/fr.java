package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.DeadCode;
import classes.class2;
import mahiro.deadcode.deadcode.hacks.render.UserInterface;
import mahiro.deadcode.deadcode.managers.ShaderManager;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class fr
extends ComponentRenderer {
    public fr(Theme theme) {
        super(ComponentType.g, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        dl dl2 = (dl)component;
        int n4 = dl2.getX();
        int n5 = dl2.getY();
        int n6 = dl2.getWidth();
        int n7 = dl2.getHeight();
        if (((Boolean)UserInterface.b.getObjectValue()).booleanValue()) {
            ShaderManager.b().a(n4, n5, n4 + n6, n5 + n7, 5.0f, 2, er.a(0, 0, 0, 35));
        }
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6), (double)(n5 + n7), aX.h);
        int n8 = 3;
        int n9 = 37;
        fd_0 fd_02 = ShaderManager.f();
        if (fd_02.d && dl2.a) {
            fd_02.startUseShader();
            fd_02.uniform1f("radius", 0.5f);
            fd_02.uniform1f("glow", 0.08f);
            RenderUtils.b(DeadCode.n.a, n4 + n8 + 5, n5 + n8, dl2.c.a(), dl2.c.b(), false);
            fd_02.stopUseShader();
        } else {
            RenderUtils.a(dl2.c.e(), (float)(n4 + n8 + 5), (float)(n5 + n8), dl2.c.a(), dl2.c.b(), false, dl2.c.hashCode());
        }
        RenderUtils.a(dl2.b.e(), (float)(n4 + n8) - 8.0f + 5.0f, (float)(n5 + n8) - 8.0f, dl2.b.a(), dl2.b.b(), false, dl2.b.hashCode());
        RenderUtils.a(dl2.d.e(), (float)(n4 + n6) - dl2.d.a() + 1.5f, (float)n5 + 2.5f, dl2.d.a(), dl2.d.b(), true, dl2.d.hashCode());
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        class2 class22 = (class2) DeadCode.f;
        int n10 = n4 + n8 * 2 + n9 + 2;
        int n11 = n5 + n8 * 2;
        int n12 = Wrapper.INSTANCE.h().a(class22.ifs());
        Wrapper.INSTANCE.h().a(class22.ifs(), n10, n11, aX.n);
        Wrapper.INSTANCE.m().a(et.b(class22.ifs().toString()), n10 + n12 + n8, n11, aX.n);
        Wrapper.INSTANCE.p().a("UID: " + class22.ifs(), n10, n11 + 15, aX.n);
    }
}

