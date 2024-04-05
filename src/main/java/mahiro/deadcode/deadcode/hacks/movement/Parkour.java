/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.movement;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class Parkour
extends Hack {
    public Parkour() {
        super("Parkour", HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Jump when reaching a block's edge.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (eS.a((EntityLivingBase) Wrapper.INSTANCE.getLocalPlayer()) && !Wrapper.INSTANCE.getLocalPlayer().isSneaking()) {
            Wrapper.INSTANCE.getLocalPlayer().jump();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

