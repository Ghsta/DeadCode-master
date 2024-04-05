package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
import classes.class6;
import mahiro.deadcode.deadcode.managers.CommandManager;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import net.minecraft.network.play.client.CPacketChatMessage;

public class bn {
    public static boolean a(Object object) {
        if (object instanceof CPacketChatMessage) {
            return bn.a((CPacketChatMessage)object);
        }
        return true;
    }

    public static boolean a(CPacketChatMessage cPacketChatMessage) {
        String string = cPacketChatMessage.getMessage().trim();
        if (string.startsWith(".")) {
            CommandManager.executeCommand(string.replace(".", ""));
            try {
                class6.g.aaa();
            }
            catch (Exception exception) {
                ChatUtils.exception("Console: runCommands", exception);
            }
            return false;
        }
        return true;
    }
}

