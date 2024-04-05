package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 */
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hacks.other.NoGuiEvents;
import mahiro.deadcode.deadcode.hacks.other.Targets;
import mahiro.deadcode.deadcode.hacks.other.Teams;
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.managers.HackManager;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class eQ {
    public static boolean a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return entityLivingBase2 == null || entityLivingBase.getHealth() < entityLivingBase2.getHealth();
    }

    public static boolean b(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return entityLivingBase2 == null || !(entityLivingBase instanceof EntityPlayer) || !(entityLivingBase2 instanceof EntityPlayer) || et.d((EntityPlayer)entityLivingBase) > et.d((EntityPlayer)entityLivingBase2);
    }

    public static boolean c(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return entityLivingBase2 == null || Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityLivingBase) < Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityLivingBase2);
    }

    public static boolean a(EntityLivingBase entityLivingBase, float f2) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= f2;
    }

    public static boolean a(Entity entity) {
        if (Targets.d && entity instanceof EntityPlayer) {
            return false;
        }
        return !Targets.e || !(entity instanceof EntityLiving);
    }

    public static boolean a(EntityLivingBase entityLivingBase) {
        EntityPlayer entityPlayer;
        String string;
        return !(entityLivingBase instanceof EntityPlayer) || !FriendManager.a.contains(string = et.a(entityPlayer = (EntityPlayer)entityLivingBase));
    }

    public static boolean b(EntityLivingBase entityLivingBase) {
        if (Teams.a) {
            Hack hack = HackManager.getHack("Teams");
            if (entityLivingBase instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
                if (hack.b(1) && entityPlayer.getTeam() != null && Wrapper.INSTANCE.getLocalPlayer().getTeam() != null && entityPlayer.getTeam().isSameTeam(Wrapper.INSTANCE.getLocalPlayer().getTeam())) {
                    return false;
                }
                if (hack.b(2) && !et.c(entityPlayer)) {
                    return false;
                }
                if (hack.b(0) && !et.a((EntityLivingBase)entityPlayer)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean c(EntityLivingBase entityLivingBase) {
        return Targets.f || !entityLivingBase.isInvisible();
    }

    public static boolean a() {
        return !NoGuiEvents.a || et.j();
    }
}

