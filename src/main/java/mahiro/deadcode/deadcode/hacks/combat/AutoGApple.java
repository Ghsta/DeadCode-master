package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;

public class AutoGApple
extends Hack {
    public BooleanValue a;
    public DoubleValue b;
    public boolean c;
    public int d = -2;

    public AutoGApple() {
        super("AutoGApple", HackCategory.Combat);
        this.b("General");
        this.a = new BooleanValue("Hotbar", false);
        this.b = new DoubleValue("Health", 15.0, 0.0, 20.0);
        this.a(this.b, this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically eat golden apples.";
    }

    @Override
    public void onEntityUseItemEvent(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        if (this.c && livingEntityUseItemEvent instanceof LivingEntityUseItemEvent.Finish && livingEntityUseItemEvent.getItem().getItem() == Items.GOLDEN_APPLE) {
            this.a(false);
        }
        super.onEntityUseItemEvent(livingEntityUseItemEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (this.c && object instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)object).getAction() != CPacketUseEntity.Action.ATTACK) {
            return false;
        }
        return super.a(object, bw2);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        int n2;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.d != -2) {
            entityPlayerSP.inventory.currentItem = this.d;
            this.d = -2;
        }
        if (this.b.getValue() <= (double)entityPlayerSP.getMaxHealth() && (double)entityPlayerSP.getHealth() >= this.b.getValue()) {
            return;
        }
        ItemStack itemStack = entityPlayerSP.getHeldItemOffhand();
        if (((Boolean)this.a.getObjectValue()).booleanValue() && (et.a(itemStack) || itemStack.getItem() != Items.GOLDEN_APPLE) && (n2 = bz.b(Items.GOLDEN_APPLE)) != -2) {
            this.d = entityPlayerSP.inventory.currentItem;
            entityPlayerSP.inventory.currentItem = n2;
        }
        if (!et.a(itemStack) && itemStack.getItem() == Items.GOLDEN_APPLE || this.d != -2) {
            this.a(true);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)bl);
        this.c = bl;
    }
}

