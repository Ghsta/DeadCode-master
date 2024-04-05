package mahiro.deadcode.deadcode.hacks.combat;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class AutoHeal
extends Hack {
    public DoubleValue a;    public Map<Potion, Boolean> b;
    public boolean c;
    public int d = -2;

    public AutoHeal() {
        super("AutoHeal", HackCategory.Combat);
        this.b("General");
        this.a = new DoubleValue("Health", 15.0, 0.0, 20.0);
        this.a(this.a);
        this.b("Other");
        this.b = new HashMap();
        this.b.put(MobEffects.INSTANT_HEALTH, false);
        this.b.put(MobEffects.REGENERATION, false);
    }

    @Override
    public String getDescription() {
        return "Automatically drink heal potions.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.d != -2) {
            entityPlayerSP.inventory.currentItem = this.d;
            this.d = -2;
        }
        if (this.a.getValue() <= (double)entityPlayerSP.getMaxHealth() && (double)entityPlayerSP.getHealth() >= this.a.getValue()) {
            this.a(false);
            return;
        }
        ItemStack itemStack = entityPlayerSP.getHeldItemOffhand();
        if (itemStack == null) {
            int n2 = -2;
            for (Map.Entry entry : this.b.entrySet()) {
                boolean bl;
                Potion potion = (Potion)entry.getKey();
                int n3 = bz.b(potion, bl = ((Boolean)entry.getValue()).booleanValue());
                if (n3 == -2) continue;
                n2 = n3;
                break;
            }
            if (n2 != -2) {
                this.d = entityPlayerSP.inventory.currentItem;
                entityPlayerSP.inventory.currentItem = n2;
            }
            if (itemStack != null || this.d != -2) {
                this.a(true);
            }
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void a(boolean bl) {
        if (this.c && !bl) {
            this.b(bl);
            this.c = false;
            return;
        }
        if (!this.c && bl) {
            this.b(bl);
            this.c = true;
        }
    }

    public void b(boolean bl) {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)bl);
    }
}

