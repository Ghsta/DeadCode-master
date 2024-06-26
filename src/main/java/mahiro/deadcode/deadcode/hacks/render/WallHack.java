/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hacks.other.Optimization;
import mahiro.deadcode.deadcode.hacks.other.Targets;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.value.types.ColorValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import utils.*;
public class WallHack
extends Hack {
    public static ColorValue a;

    public WallHack() {
        super("WallHack", HackCategory.Render);
        this.b("General");
        a = new ColorValue("Color", aX.h);
        this.a(a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "The skin of the entities around you glows.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        Entity entity = this.a((Entity)object);
        if (entity == null || entity == Wrapper.INSTANCE.getLocalPlayer() || entity == Wrapper.INSTANCE.getMinecraft().getRenderViewEntity()) {
            return;
        }
        if (Optimization.a && Wrapper.INSTANCE.getGameSettings().thirdPersonView == 0 && !Optimization.a(entity)) {
            return;
        }
        int n2 = a.getValue();
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        RenderUtils.a(entity, n2, renderWorldLastEvent.getPartialTicks());
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableLighting();
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    public Entity a(Entity entity) {
        Entity entity2 = null;
        if (Targets.d && entity instanceof EntityPlayer) {
            entity2 = entity;
        } else if (Targets.e && entity instanceof EntityLiving) {
            entity2 = entity;
        } else if (entity instanceof EntityItem) {
            entity2 = entity;
        } else if (entity instanceof EntityArrow) {
            entity2 = entity;
        }
        return entity2;
    }
}

