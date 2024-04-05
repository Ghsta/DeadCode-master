/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 */
package mahiro.deadcode.deadcode.hacks.other;
import classes.DeadCode;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.SoundPlayer;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import utils.*;
import net.minecraft.network.play.client.CPacketUseEntity;

public class HitSound
extends Hack {
    public IntegerValue a;

    public HitSound() {
        super("HitSound", HackCategory.Other);
        this.b("General");
        this.a = new IntegerValue("Volume", 30, 5, 40);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Plays custom sounds on hit.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (object instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)object).getAction() == CPacketUseEntity.Action.ATTACK) {
            float f2 = -40.0f + (float)this.a.getValue().intValue();
            SoundPlayer.a(DeadCode.q.a, f2);
        }
        return super.a(object, bw2);
    }
}

