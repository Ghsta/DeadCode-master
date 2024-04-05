package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.class6;
import mahiro.deadcode.deadcode.ui.base.Component;
import java.awt.Desktop;

public class eX
extends bh {
    public final /* synthetic */ eJ a;

    public eX(eJ eJ2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6) {
        super(n2, n3, n4, n5, component, eC2, string, n6);
        this.a = eJ2;
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        try {
            Desktop.getDesktop().open(class6.g.a);
        }
        catch (Exception exception) {
            // empty catch block
        }
        super.onMousePress(n2, n3, n4);
    }
}

