/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class ReloadChunks
extends Hack {
    public ReloadChunks() {
        super("ReloadChunks", HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Reload chunks.";
    }

    @Override
    public void onEnable() {
        Wrapper.INSTANCE.getMinecraft().renderGlobal.loadRenderers();
        this.c(false);
        super.onEnable();
    }
}

