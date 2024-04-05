/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import classes.DeadCode;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NameProtect
extends Hack {
    public BooleanValue a;
    public TimerUtils b;

    public NameProtect() {
        super("NameProtect", HackCategory.Render);
        this.b("General");
        this.a = new BooleanValue("Friends", false);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Changes player names client side.";
    }

    @Override
    public void onDisable() {
        if (DeadCode.l != null) {
            DeadCode.l.a(Wrapper.INSTANCE.getLocalPlayer().getName());
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                for (String string : FriendManager.a) {
                    DeadCode.l.a(string);
                }
            }
        }
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (DeadCode.l != null && this.b.isReached(1000L)) {
            String string = Wrapper.INSTANCE.getLocalPlayer().getName();
            this.a(string, "DeadCode");
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                for (int i2 = 0; i2 < FriendManager.a.size(); ++i2) {
                    this.a((String)FriendManager.a.get(i2), "DeadCode_" + i2);
                }
            }
            this.b.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void a(String string, String string2) {
        if (!DeadCode.l.b(string)) {
            DeadCode.l.a(string, string2);
        }
    }
}

