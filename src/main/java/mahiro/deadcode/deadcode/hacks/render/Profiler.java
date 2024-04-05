/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hacks.combat.BowAimBot;
import mahiro.deadcode.deadcode.hacks.other.Optimization;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderWorldLastEvent;import utils.*;

public class Profiler
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public BooleanValue c;
    public BooleanValue d;
    public BooleanValue e;
    public static BooleanValue f;

    public Profiler() {
        super("Profiler", HackCategory.Render);
        this.b("General");
        this.a = new BooleanValue("Armor", true);
        this.b = new BooleanValue("Effects", true);
        this.c = new BooleanValue("Health bar", false);
        this.d = new BooleanValue("Health tag", true);
        this.e = new BooleanValue("Items", true);
        f = new BooleanValue("Person view", false);
        this.a(this.a, this.b, this.c, this.d, this.e, f);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to see armor of player or info of item.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        if (object instanceof EntityLivingBase || ((Boolean)this.e.getObjectValue()).booleanValue() && object instanceof EntityItem) {
            Entity entity = (Entity)object;
            Profiler.a(entity, renderWorldLastEvent.getPartialTicks(), false, false, false, (Boolean)this.a.getObjectValue(), true, (Boolean)this.c.getObjectValue(), false, (Boolean)this.b.getObjectValue(), (Boolean)this.d.getObjectValue());
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onDisable() {
        RenderUtils.c();
        super.onDisable();
    }

    public static void a(Entity entity, float f2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        ItemStack itemStack;
        Object object;
        String string;
        if (entity instanceof EntityArmorStand || !(entity instanceof EntityItem) && eQ.a(entity) || entity == Wrapper.INSTANCE.getLocalPlayer() && (Wrapper.INSTANCE.getGameSettings().thirdPersonView == 0 || !((Boolean)f.getObjectValue()).booleanValue())) {
            return;
        }
        if (Optimization.a && !bl7 && Wrapper.INSTANCE.getGameSettings().thirdPersonView == 0 && !Optimization.a(entity)) {
            return;
        }
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        double d2 = renderManager.viewerPosX;
        double d3 = renderManager.viewerPosY;
        double d4 = renderManager.viewerPosZ;
        double d5 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2 - d2;
        double d6 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 - d3;
        double d7 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2 - d4;
        cU cU2 = cU.e;
        int n2 = er.e;
        if (bl2 || bl3 || bl) {
            n2 = ESP.a.getValue();
        }
        if (bl7) {
            n2 = Tracers.c.getValue();
        }
        if (entity instanceof EntityPlayer && FriendManager.a.contains(string = et.a((EntityPlayer) (object = (EntityPlayer)entity)))) {
            n2 = er.b;
        }
        if (entity.isInvisible()) {
            n2 = er.d;
        }
        if (entity instanceof EntityLivingBase) {
            object = (EntityLivingBase)entity;
            if (((EntityLivingBase) object).hurtTime > 0 || object == BowAimBot.b) {
                cU2 = cU.a;
                n2 = er.a;
            }
        }
        object = entity.getDisplayName().getFormattedText();
        if (entity instanceof EntityItem && !et.a(itemStack = ((EntityItem)entity).getItem())) {
            object = itemStack.getItem().getItemStackDisplayName(itemStack);
        }
        RenderUtils.a(entity, (String)object, d5, d6, d7, cU2, bl4, bl5, bl6, bl8, bl9);
        if (bl7) {
            RenderUtils.b(entity, n2, f2);
        }
        if (bl) {
            RenderUtils.e(entity, n2, f2);
        }
        if (bl2) {
            RenderUtils.d(entity, n2, f2);
        }
        if (bl3) {
            RenderUtils.c(entity, n2, f2);
        }
    }
}

