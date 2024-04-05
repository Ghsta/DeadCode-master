/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.ui;

import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import mahiro.deadcode.deadcode.ui.theme.Theme;

public abstract class ComponentRenderer {
    public Theme a;
    private ComponentType b;

    public ComponentRenderer(ComponentType componentType, Theme theme) {
        this.b = componentType;
        this.a = theme;
    }

    public abstract void drawComponent(Component var1, int var2, int var3);

    public ComponentType a() {
        return this.b;
    }
}

