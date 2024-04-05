package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.command.Command;

public class CommandPickupFilter
extends Command {
    public CommandPickupFilter() {
        super("pfilter");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("add")) {
                utils.fB.a(Integer.parseInt(stringArray[1]));
            } else if (stringArray[0].equalsIgnoreCase("remove")) {
                utils.fB.b(Integer.parseInt(stringArray[1]));
            } else if (stringArray[0].equalsIgnoreCase("clear")) {
                utils.fB.a();
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "PickupFilter manager.";
    }

    @Override
    public String getSyntax() {
        return "pfilter add <id> | remove <id> | clear";
    }
}

