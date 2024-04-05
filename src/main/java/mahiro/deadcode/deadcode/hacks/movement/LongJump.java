/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class LongJump
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public IntegerValue c;
    public BooleanValue d;
    public TimerUtils e;

    public LongJump() {
        super("LongJump", HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));
        this.b = new DoubleValue("Distance", 1.0, 0.01, 2.0);
        this.c = new IntegerValue("Hit delay", 0, 0, 2000);
        this.d = new BooleanValue("Auto disable", false);
        this.a(this.a, this.b, this.c, this.d);
        this.b("Other");
        this.e = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Long jump.";
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        float f2 = this.b.getValue().floatValue();
        if (this.a.getMode("Default").isToggled()) {
            if ((double)entityPlayerSP.fallDistance > 0.5) {
                entityPlayerSP.jumpMovementFactor = f2;
                if (((Boolean)this.d.getObjectValue()).booleanValue()) {
                    this.toggle();
                }
            }
        } else if (this.a.getMode("Matrix").isToggled() && this.e.isReached(this.c.getValue().intValue()) && entityPlayerSP.hurtTime > 0) {
            entityPlayerSP.jumpMovementFactor = entityPlayerSP.hurtTime == entityPlayerSP.maxHurtTime ? f2 : (entityPlayerSP.hurtTime >= entityPlayerSP.maxHurtTime / 2 ? f2 - f2 / 3.0f : f2 / 2.0f);
            et.i();
            if (((Boolean)this.d.getObjectValue()).booleanValue()) {
                this.toggle();
            }
            this.e.resetTime();
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

