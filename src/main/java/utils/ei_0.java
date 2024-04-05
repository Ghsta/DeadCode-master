package utils;/*
 * Decompiled with CFR 0.152.
 */
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.ui.base.Component;

/*
 * Renamed from eI
 */
public class ei_0
extends bh {
    public final /* synthetic */ String a;
    public final /* synthetic */ bg b;

    public ei_0(bg bg2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6, String string2) {
        super(n2, n3, n4, n5, component, eC2, string, n6);
        this.b = bg2;
        this.a = string2;
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        FriendManager.c(this.a);
        super.onMousePress(n2, n3, n4);
    }
}

