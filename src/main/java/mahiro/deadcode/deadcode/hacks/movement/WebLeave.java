/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.types.IntegerValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class WebLeave
extends Hack {
    public IntegerValue a;
    public IntegerValue b;
    public TimerUtils c;
    public boolean d;

    public WebLeave() {
        super("WebLeave", HackCategory.Movement);
        this.b("General");
        this.a = new IntegerValue("Motion Y", 5, 1, 20);
        this.b = new IntegerValue("Clip", 5, 1, 10);
        this.a(this.a, this.b);
        this.b("Other");
        this.c = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Gives you the ability to leave above web.";
    }

    @Override
    public void onEnable() {
        this.d = false;
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        KeyBinding keyBinding = Wrapper.INSTANCE.getGameSettings().keyBindJump;
        if (!this.d && eS.a((EntityLivingBase)entityPlayerSP, Blocks.WEB) && keyBinding.isKeyDown()) {
            dV.a(this.b.getValue());
            this.d = true;
        } else if (this.c.isReached(10L)) {
            if (this.d && keyBinding.isKeyDown() && (double)entityPlayerSP.fallDistance != 0.0) {
                entityPlayerSP.motionY = this.a.getValue().intValue();
                this.d = false;
            }
            if (entityPlayerSP.onGround && !keyBinding.isKeyDown()) {
                this.d = false;
            }
            this.c.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

