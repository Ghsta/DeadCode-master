/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.ui.base;
import classes.class9;
import mahiro.deadcode.deadcode.ui.ComponentRenderer;

import java.util.ArrayList;

public class Component
extends Interactable {
    private ArrayList a = new ArrayList();
    private ComponentType b;
    private Component c;

    public Component(int n2, int n3, int n4, int n5, ComponentType componentType, Component component) {
        super(n2, n3, n4, n5);
        this.b = componentType;
        this.c = component;
    }

    public void a(Component component) {
        this.a.add(component);
    }

    public void b(Component component) {
        this.a.remove(component);
    }

    public ArrayList<Component> b() {
        return this.a;
    }

    public void c(int n2, int n3) {
        ((ComponentRenderer)class9.j().getRenderer().get((Object)this.b)).drawComponent(this, n2, n3);
    }

    public void c() {
    }

    public ComponentType q() {
        return this.b;
    }

    public Component r() {
        return this.c;
    }

    public void c(Component component) {
        this.c = component;
    }
}

