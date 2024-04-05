/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.hacks.combat.BowAimBot;
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.value.types.ColorValue;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class Tracers
extends Hack {
    public static IntegerValue a;
    public static ModeValue b;
    public static ColorValue c;
    public BooleanValue d;
    public static boolean e;

    public Tracers() {
        super("Tracers", HackCategory.Render);
        this.b("General");
        b = new ModeValue("Mode", new Mode("Arrow", true), new Mode("Tracer"));
        c = new ColorValue("Color", aX.i);
        this.d = new BooleanValue("Arrow astolfo", false);
        a = new IntegerValue("Arrow radius", 40, 30, 100);
        this.a(a, c, this.d, b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Traces a line to the players.";
    }

    @Override
    public void onDisable() {
        e = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        e = true;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void a(float f2) {
        if (!b.getModeByIndex(0).isToggled()) {
            return;
        }
        int n2 = 0;
        List<Entity> list = et.b();
        for (Entity entity : list) {
            EntityPlayer entityPlayer;
            String string;
            int n3;
            if (entity instanceof EntityArmorStand || eQ.a(entity) || entity == Wrapper.INSTANCE.getLocalPlayer()) continue;
            int n4 = n3 = (Boolean)this.d.getObjectValue() != false ? er.a(n2, list.size(), 0.7f) : c.getValue();
            if (entity instanceof EntityPlayer && FriendManager.a.contains(string = et.a(entityPlayer = (EntityPlayer)entity))) {
                n3 = er.b;
            }
            if (entity.isInvisible()) {
                n3 = er.d;
            }
            if (entity instanceof EntityLivingBase) {
                entityPlayer = (EntityPlayer) entity;
                if (entityPlayer.hurtTime > 0 || entityPlayer == BowAimBot.b) {
                    n3 = er.a;
                }
            }
            RenderUtils.a(entity, (float)a.getValue().intValue(), n3, f2);
            if (!((Boolean)this.d.getObjectValue()).booleanValue()) continue;
            n2 += 10;
        }
        super.a(f2);
    }
}

