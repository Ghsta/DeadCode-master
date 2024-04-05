package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class FastBow
extends Hack {
    public FastBow() {
        super("FastBow", HackCategory.Combat);
    }

    @Override
    public String getDescription() {
        return "Shoots very fast with bow.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.b() && Wrapper.INSTANCE.getGameSettings().keyBindAttack.isKeyDown() && (double)entityPlayerSP.getItemInUseMaxCount() >= 3.15) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, entityPlayerSP.getHorizontalFacing()));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerTryUseItem(entityPlayerSP.getActiveHand()));
            entityPlayerSP.stopActiveHand();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (object instanceof CPacketUseEntity && this.b() && Wrapper.INSTANCE.getGameSettings().keyBindAttack.isKeyDown() && (cPacketUseEntity = (CPacketUseEntity)object).getAction() != CPacketUseEntity.Action.ATTACK) {
            return false;
        }
        return super.a(object, bw2);
    }

    public boolean b() {
        ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().inventory.getCurrentItem();
        return !et.a(itemStack) && itemStack.getItem() instanceof ItemBow;
    }
}

