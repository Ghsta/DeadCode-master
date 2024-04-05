package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.DeadCode;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import java.io.File;

public class dl
extends dp {
    public boolean a;
    public eC b = DeadCode.n.a("Other", "Avatar-Circle");
    public eC c = DeadCode.n.a("Other", "Avatar");
    public eC d = DeadCode.n.a("Other", "Profile-Style");

    public dl(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.g, component);
        this.a = new File(DeadCode.n.a).exists();
    }
}

