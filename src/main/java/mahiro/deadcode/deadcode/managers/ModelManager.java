/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.managers;

import classes.class6;
import mahiro.deadcode.deadcode.hacks.render.TextureChanger;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.value.Mode;

import java.io.File;
import java.util.ArrayList;import utils.*;

public class ModelManager {
    public final File a = new File(class6.d, "Models");
    public final ArrayList<an> b = new ArrayList();
    public boolean c;
    public boolean d;

    public void a() {
        if (this.d) {
            return;
        }
        try {
            if (!this.a.exists()) {
                this.a.mkdir();
            }
            for (Mode mode : TextureChanger.a.getModes()) {
                this.b.add(new an(mode.getName()));
            }
            this.d = true;
            ChatUtils.debug("ModelManager: initialized.");
        }
        catch (Exception exception) {
            ChatUtils.exception("ModelManager", exception);
        }
    }

    public final  void b() {
        if (this.c) {
            return;
        }
        for (an an2 : this.b) {
            an2.a();
        }
        this.c = true;
    }

    public an c() {
        for (int i2 = 0; i2 < TextureChanger.a.getModes().length; ++i2) {
            if (!TextureChanger.a.getModes()[i2].isToggled()) continue;
            return (an)this.b.get(i2);
        }
        return null;
    }
}

