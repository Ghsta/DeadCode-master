package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;

public class CommandSay
extends Command {
    public CommandSay() {
        super("say");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            String string2 = "";
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                string2 = string2 + stringArray[i2] + " ";
            }
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage(string2));
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Send message to chat.";
    }

    @Override
    public String getSyntax() {
        return "say <message>";
    }
}

