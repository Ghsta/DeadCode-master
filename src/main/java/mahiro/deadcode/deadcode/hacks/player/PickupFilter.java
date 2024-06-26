/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 */
package mahiro.deadcode.deadcode.hacks.player;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import java.util.Iterator;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;import utils.*;

public class PickupFilter
extends Hack {
    public BooleanValue a;

    public PickupFilter() {
        super("PickupFilter", HackCategory.Player);
        this.b("General");
        this.a = new BooleanValue("Ignore all", false);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Filters item picking. Use 'pfilter' command for manage.";
    }

    @Override
    public void onItemPickupEvent(EntityItemPickupEvent entityItemPickupEvent) {
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            entityItemPickupEvent.setCanceled(true);
            return;
        }
        Iterator iterator = fB.a.iterator();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            Item item = Item.getItemById((int)n2);
            if (item == null || entityItemPickupEvent.getItem().getItem().getItem() != item) continue;
            entityItemPickupEvent.setCanceled(true);
        }
        super.onItemPickupEvent(entityItemPickupEvent);
    }
}

