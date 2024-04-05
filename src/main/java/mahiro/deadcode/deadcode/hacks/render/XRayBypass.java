/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketMultiBlockChange
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.XRayManager;
import mahiro.deadcode.deadcode.utils.RandomUtils;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import mahiro.deadcode.deadcode.xray.XRayData;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import utils.*;
public class XRayBypass
extends Hack {
    public ModeValue a = new ModeValue("Mode", true, new Mode("Left"), new Mode("Right"), new Mode("Random", true));
    public IntegerValue b;
    public IntegerValue c;
    public IntegerValue d = new IntegerValue("Update delay", 100, 5, 500);
    public fw e;
    public Thread f;
    public ArrayList g;
    public TimerUtils h;

    public XRayBypass() {
        super("XRayBypass", HackCategory.Render);
        this.b = new IntegerValue("Horizontal distance", 18, 4, 100);
        this.c = new IntegerValue("Vertical distance", 18, 4, 100);
        this.b("General");
        this.a(this.a, this.d);
        this.b("Distance");
        this.a(this.b, this.c);
        this.b("Other");
        this.h = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Allows you to see blocks through walls with bypass Anti-XRay.";
    }

    @Override
    public void onDisable() {
        this.c();
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        this.b();
        if (this.g == null || this.g != null && this.g.isEmpty()) {
            return;
        }
        RenderUtils.a(this.g, renderWorldLastEvent.getPartialTicks());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        SPacketBlockChange sPacketBlockChange;
        if (object instanceof SPacketBlockChange) {
            sPacketBlockChange = (SPacketBlockChange)object;
            this.a(sPacketBlockChange.getBlockState(), sPacketBlockChange.getBlockPosition());
        }
        if (object instanceof SPacketMultiBlockChange) {
            Arrays.stream(((SPacketMultiBlockChange) object).getChangedBlocks()).forEach(blockUpdateData -> this.a(blockUpdateData.getBlockState(), blockUpdateData.getPos()));
        }
        return true;
    }

    public void b() {
        if (this.e != null && this.f != null) {
            return;
        }
        this.g = new ArrayList();
        this.e = new fw(this);
        this.f = new Thread(this.e);
        this.f.start();
    }

    public void c() {
        if (this.e != null) {
            this.e.a();
        }
        this.e = null;
        this.f = null;
    }

    public void a(BlockPos blockPos) {
        if (this.a.getModeByIndex(0).isToggled()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, EnumFacing.UP));
        } else if (this.a.getModeByIndex(1).isToggled()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
        } else if (this.a.getModeByIndex(2).isToggled()) {
            if (RandomUtils.getRandom().nextBoolean()) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.UP));
            } else {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            }
        }
    }

    public void a(IBlockState iBlockState, BlockPos blockPos) {
        int n2 = Block.getIdFromBlock((Block)iBlockState.getBlock());
        for (XRayData xRayData : XRayManager.a) {
            if (xRayData.getId() != n2) continue;
            by by2 = new by(blockPos, xRayData);
            this.g.add(by2);
        }
    }
}

