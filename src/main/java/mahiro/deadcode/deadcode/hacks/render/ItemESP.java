/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ItemESP
extends Hack {
    public ModeValue a;

    public ItemESP() {
        super("ItemESP", HackCategory.Render);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("WatchDogs"), new Mode("2D", true), new Mode("3D"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to see all of the items around you.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        if (object instanceof EntityItem || object instanceof EntityArrow) {
            Entity entity = (Entity)object;
            Profiler.a(entity, renderWorldLastEvent.getPartialTicks(), this.a.getModeByIndex(0).isToggled(), this.a.getModeByIndex(1).isToggled(), this.a.getModeByIndex(2).isToggled(), false, false, false, false, false, false);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

