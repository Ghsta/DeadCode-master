package utils;/*
 * Decompiled with CFR 0.152.
 */
import classes.class11;

import java.util.ArrayList;

public class ey {
    private ArrayList a = new ArrayList();

    public ey() {
        this.b();
    }

    private /* synthetic */ void b() {
        this.a(class11.a()[0], class11.a()[1]);
        this.a(class11.a()[2], class11.a()[3]);
        this.a(class11.a()[4], class11.a()[5]);
        this.a(class11.a()[6], class11.a()[7]);
        this.a(class11.a()[8], class11.a()[9]);
        this.a(class11.a()[10], class11.a()[11]);
    }

    public void a(String string, String string2) {
        this.a.add(new dH(string, string2));
    }

    public void a(String string) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (!((dH)this.a.get(i2)).b().equals(string)) continue;
            this.a.remove(i2);
        }
    }

    public boolean b(String string) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (!((dH)this.a.get(i2)).b().equals(string)) continue;
            return true;
        }
        return false;
    }

    public ArrayList<dH> a() {
        return this.a;
    }
}

