package mahiro.deadcode.deadcode.commands;

import classes.class6;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.io.File;
import java.util.ArrayList;
import net.minecraft.client.network.NetworkPlayerInfo;

public class CommandDumpPlayers
extends Command {
    public CommandDumpPlayers() {
        super("dumpplayers");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            if (stringArray[0].equalsIgnoreCase("all")) {
                for (NetworkPlayerInfo networkPlayerInfo : Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfoMap()) {
                    arrayList.add("\n" + networkPlayerInfo.getGameProfile().getName());
                }
            } else if (stringArray[0].equalsIgnoreCase("creatives")) {
                for (NetworkPlayerInfo networkPlayerInfo : Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfoMap()) {
                    if (!networkPlayerInfo.getGameType().isCreative()) continue;
                    arrayList.add("\n" + networkPlayerInfo.getGameProfile().getName());
                }
            }
            if (arrayList.isEmpty()) {
                ChatUtils.error("List is empty.");
            } else {
                File file = new File(class6.g.a, "dump_players.txt");
                utils.fn.a(file, arrayList, false, true);
                ChatUtils.info("Saved to '" + file.getAbsolutePath() + "'.");
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Get list of players.";
    }

    @Override
    public String getSyntax() {
        return "dumpplayers <all/creatives>";
    }
}

