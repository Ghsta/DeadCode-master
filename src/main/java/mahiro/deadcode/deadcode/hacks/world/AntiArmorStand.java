/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.world;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import utils.*;
public class AntiArmorStand
extends Hack {
    public AntiArmorStand() {
        super("AntiArmorStand", HackCategory.World);
    }

    @Override
    public String getDescription() {
        return "Removes all armor stands from the world.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        for (Entity entity : et.b()) {
            if (!(entity instanceof EntityArmorStand)) continue;
            Wrapper.INSTANCE.getWorld().removeEntity(entity);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

