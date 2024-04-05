/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.MobEffects
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.init.MobEffects;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class WaterSpeed
extends Hack {
    public DoubleValue a;
    public BooleanValue b;
    public BooleanValue c;

    public WaterSpeed() {
        super("WaterSpeed", HackCategory.Movement);
        this.b("General");
        this.a = new DoubleValue("Speed", 0.7, 0.2, 2.0);
        this.b = new BooleanValue("Only speed potion", false);
        this.c = new BooleanValue("Auto swim", false);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Make you faster in water.";
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (((Boolean)this.b.getObjectValue()).booleanValue() && !Wrapper.INSTANCE.getLocalPlayer().isPotionActive(MobEffects.SPEED)) {
            return;
        }
        if (!Wrapper.INSTANCE.getLocalPlayer().isInWater() || !dV.a()) {
            return;
        }
        if (((Boolean)this.c.getObjectValue()).booleanValue()) {
            Wrapper.INSTANCE.getLocalPlayer().motionY += (double)0.04f;
        }
        dV.a(this.a.getValue().floatValue());
        super.onPlayerTickEvent(playerTickEvent);
    }
}

