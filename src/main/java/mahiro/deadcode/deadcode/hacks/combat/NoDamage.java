/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 */
package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;
import utils.*;
public class NoDamage
extends Hack {
    public NoDamage() {
        super("NoDamage", HackCategory.Combat);
    }

    @Override
    public String getDescription() {
        return "You will not utils.be able to hit a player who is in your team or friends list.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 == bw.b && object instanceof CPacketUseEntity) {
            CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)object;
            if (cPacketUseEntity.getAction() != CPacketUseEntity.Action.ATTACK) {
                return true;
            }
            Entity entity = cPacketUseEntity.getEntityFromWorld((World) Wrapper.INSTANCE.getWorld());
            if (entity == null || !(entity instanceof EntityPlayer)) {
                return true;
            }
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (!eQ.a((EntityLivingBase)entityPlayer) || !eQ.b((EntityLivingBase)entityPlayer)) {
                return false;
            }
        }
        return true;
    }
}

