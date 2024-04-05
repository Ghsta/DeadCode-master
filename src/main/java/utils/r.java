package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.class6;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import java.io.File;

public class r
extends bh {
    public final /* synthetic */ File a;
    public final /* synthetic */ eJ b;

    public r(eJ eJ2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6, File file) {
        super(n2, n3, n4, n5, component, eC2, string, n6);
        this.b = eJ2;
        this.a = file;
    }



    @Override
    public void onMousePress(int n2, int n3, int n4) {
        try {
            class6.sbb(this.a.getName());
        }
        catch (Exception exception) {
            ChatUtils.exception("ConfigManager: delete", exception);
        }
        super.onMousePress(n2, n3, n4);
    }
}

