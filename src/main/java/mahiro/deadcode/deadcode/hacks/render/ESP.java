/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.ColorValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderWorldLastEvent;import utils.*;

public class ESP
extends Hack {
    public static ColorValue a;
    public ModeValue b;

    public ESP() {
        super("ESP", HackCategory.Render);
        this.b("General");
        this.b = new ModeValue("Mode", new Mode("WatchDogs"), new Mode("2D", true), new Mode("3D"));
        a = new ColorValue("Color", aX.i);
        this.a(a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to see all of the entities around you.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        if (object instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)object;
            Profiler.a((Entity)entityLivingBase, renderWorldLastEvent.getPartialTicks(), this.b.getModeByIndex(0).isToggled(), this.b.getModeByIndex(1).isToggled(), this.b.getModeByIndex(2).isToggled(), false, false, false, false, false, false);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

