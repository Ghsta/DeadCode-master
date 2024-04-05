package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.command.Command;
import net.minecraft.entity.player.EntityPlayer;
import utils.*;
public class CommandTeleport
extends Command {
    public CommandTeleport() {
        super("tp");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray.length > 2) {
                int n2 = Integer.parseInt(stringArray[0]);
                int n3 = Integer.parseInt(stringArray[1]);
                int n4 = Integer.parseInt(stringArray[2]);
                utils.et.b(n2, n3, n4);
            } else if (stringArray.length > 0) {
                boolean bl = false;
                for (EntityPlayer entityPlayer : et.c()) {
                    if (!stringArray[0].equalsIgnoreCase(entityPlayer.getName())) continue;
                    et.b(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
                    bl = true;
                }
                if (!bl) {
                    ChatUtils.error("Player not found.");
                }
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Telports you.";
    }

    @Override
    public String getSyntax() {
        return "tp <nick/utils.x y z>";
    }
}

