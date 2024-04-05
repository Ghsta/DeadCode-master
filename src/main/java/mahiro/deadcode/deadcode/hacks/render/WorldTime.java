/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class WorldTime
extends Hack {
    public IntegerValue a;

    public WorldTime() {
        super("WorldTime", HackCategory.Render);
        this.b("General");
        this.a = new IntegerValue("Time", 0, 0, 24000);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Set custom world time.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        Wrapper.INSTANCE.getWorld().setWorldTime((long)this.a.getValue().intValue());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

