package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class HitBox
extends Hack {
    public DoubleValue a;
    public DoubleValue b;

    public HitBox() {
        super("HitBox", HackCategory.Combat);
        this.b("General");
        this.a = new DoubleValue("Width", 0.6, 0.1, 5.0);
        this.b = new DoubleValue("Height", 1.8, 0.1, 5.0);
        this.a(this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Change size hit box of players.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        for (EntityPlayer entityPlayer : et.c()) {
            if (!this.a((EntityLivingBase)entityPlayer)) continue;
            float f2 = this.a.getValue().floatValue();
            float f3 = this.b.getValue().floatValue();
            et.a((Entity)entityPlayer, f2, f3);
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        for (EntityPlayer entityPlayer : et.c()) {
            et.a((Entity)entityPlayer);
        }
        super.onDisable();
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayerSP) {
            return false;
        }
        if (entityLivingBase == Wrapper.INSTANCE.getLocalPlayer()) {
            return false;
        }
        if (entityLivingBase.isDead) {
            return false;
        }
        if (!eQ.a(entityLivingBase)) {
            return false;
        }
        return eQ.b(entityLivingBase);
    }
}

