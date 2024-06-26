/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.player;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoRespawn
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public TimerUtils c;
    public boolean d;

    public AutoRespawn() {
        super("AutoRespawn", HackCategory.Player);
        this.b("General");
        this.a = new BooleanValue("Instant", false);
        this.b = new BooleanValue("AutoHome", false);
        this.a(this.a, this.b);
        this.b("Other");
        this.c = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically respawns you after dying.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if ((Boolean)this.a.getObjectValue() != false ? entityPlayerSP.getHealth() != 0.0f && !entityPlayerSP.isDead : !(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiGameOver)) {
            return;
        }
        entityPlayerSP.respawnPlayer();
        Wrapper.INSTANCE.getMinecraft().displayGuiScreen(null);
        if (((Boolean)this.b.getObjectValue()).booleanValue() && !this.d) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage("/home home"));
            this.d = true;
        }
        if (this.d && this.c.isReached(200L)) {
            this.d = false;
            this.c.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

