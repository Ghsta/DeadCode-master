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
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FastLadder
extends Hack {
    public ModeValue a;

    public FastLadder() {
        super("FastLadder", HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows speed you to climb ladders.";
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!entityPlayerSP.isOnLadder() || !entityPlayerSP.collidedHorizontally) {
            return;
        }
        if (this.a.getModeByIndex(0).isToggled()) {
            entityPlayerSP.motionY = 0.5;
        } else if (this.a.getModeByIndex(1).isToggled()) {
            entityPlayerSP.noClip = true;
            entityPlayerSP.motionY = 0.0;
            entityPlayerSP.onGround = true;
            entityPlayerSP.motionY = 0.429;
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

