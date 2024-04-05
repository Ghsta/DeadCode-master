package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;
import utils.*;
public class ClickPearl
extends Hack {
    public BooleanValue a;
    public TimerUtils b;
    public int c = -2;

    public ClickPearl() {
        super("ClickPearl", HackCategory.Combat);
        this.b("General");
        this.a = new BooleanValue("Middle", false);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically thorw ender-pearl on click.";
    }

    @Override
    public void onEnable() {
        this.c = -2;
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        this.b();
        this.c(false);
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (!((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        if (Mouse.isButtonDown((int)2) && this.b.isReached(200L) && Wrapper.INSTANCE.getMinecraft().currentScreen == null) {
            this.b();
            this.b.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void b() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n2 = bz.b(Items.ENDER_PEARL);
        if (n2 != -2) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
            cs.a.b().processRightClick((EntityPlayer)entityPlayerSP, (World)Wrapper.INSTANCE.getWorld(), EnumHand.MAIN_HAND);
            new mahiro.deadcode.deadcode.hacks.thread.ClickPearl(this, entityPlayerSP).start();
        }
    }
}

