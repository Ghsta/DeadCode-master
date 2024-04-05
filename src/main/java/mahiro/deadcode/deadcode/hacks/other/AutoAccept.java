/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.server.SPacketChat
 */
package mahiro.deadcode.deadcode.hacks.other;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.FriendManager;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketChat;
import utils.*;
public class AutoAccept
extends Hack {
    public BooleanValue a;

    public AutoAccept() {
        super("AutoAccept", HackCategory.Other);
        this.b("General");
        this.a = new BooleanValue("Only friends", true);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically accepts teleports.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketChat) {
            SPacketChat sPacketChat = (SPacketChat)object;
            if (sPacketChat.getChatComponent() == null) {
                return true;
            }
            String string = sPacketChat.getChatComponent().getFormattedText();
            if (et.a(string)) {
                return true;
            }
            string = et.c(string);
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                boolean bl = false;
                for (String string2 : FriendManager.a) {
                    if (!string.contains(string2)) continue;
                    bl = true;
                }
                if (!bl) {
                    return true;
                }
            }
            if (string.contains("/tpyes") || string.contains("/tpaccept") || string.contains("\u043f\u0440\u043e\u0441\u0438\u0442 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f") || string.contains("\u043f\u0440\u043e\u0441\u0438\u0442 \u043a \u0432\u0430\u043c \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f")) {
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                this.b();
            }
        }
        return super.a(object, bw2);
    }

    public void b() {
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage("/tpaccept"));
    }
}

