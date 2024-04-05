/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package mahiro.deadcode.deadcode.hacks.thread;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class ShieldBreaker
extends Thread {
    public final /* synthetic */ mahiro.deadcode.deadcode.hacks.combat.ShieldBreaker a;

    public ShieldBreaker(mahiro.deadcode.deadcode.hacks.combat.ShieldBreaker shieldBreaker) {
        this.a = shieldBreaker;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10L);
            if (this.a.a != -2) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(this.a.a));
                this.a.a = -2;
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("breakShield: ", exception);
        }
    }
}

