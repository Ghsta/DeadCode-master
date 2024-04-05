/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.world;

import net.minecraft.util.math.BlockPos;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.MathUtils;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraftforge.fml.common.gameevent.TickEvent;import utils.*;

public class BedFucker
extends Hack {
    public IntegerValue a;
    public TimerUtils b;
    public TimerUtils c;
    public TimerUtils d;

    public BedFucker() {
        super("BedFucker", HackCategory.World);
        this.b("General");
        this.a = new IntegerValue("Distance", 5, 2, 10);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
        this.c = new TimerUtils();
        this.d = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Breaking beds near you.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        AtomicInteger n2 = new AtomicInteger(this.a.getValue());
        Stream stream = eS.a(n2.get(), n2.get(), n2.get());
        if (stream == null) {
            return;
        }
        stream.forEach(blockPos -> {
            n2.set(Block.getIdFromBlock((Block) eS.b((BlockPos) blockPos)));
            if (n2.get() == Block.getIdFromBlock((Block)Blocks.BED)) {
                float[] fArray = MathUtils.a((BlockPos) blockPos);
                ef.a(fArray);
                if (this.d.isReached(1L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                }
                if (this.d.isReached(2L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
                    this.d.resetTime();
                }
                if (this.c.isReached(33L)) {
                    if (this.b.isReached(1000L)) {
                        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, (BlockPos) blockPos, Wrapper.INSTANCE.getMinecraft().objectMouseOver.sideHit));
                    }
                    if (this.b.isReached(2000L)) {
                        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, (BlockPos) blockPos, Wrapper.INSTANCE.getMinecraft().objectMouseOver.sideHit));
                        this.b.resetTime();
                    }
                    cs.a.c();
                    this.c.resetTime();
                }
            }
        });
        super.onClientTickEvent(clientTickEvent);
    }
}

