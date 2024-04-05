package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.managers.CommandManager;

public class CommandHelp
extends Command {
    public CommandHelp() {
        super("help");
    }

    @Override
    public void runCommand(final String s, final String[] args) {
        for (final Command cmd : CommandManager.commands) {
            if (cmd != this) {
                ChatUtils.message(cmd.getSyntax().replace("<", "<§9").replace(">", "§7>") + " - " + cmd.getDescription());
            }
        }
    }

    @Override
    public String getDescription() {
        return "Lists all commands.";
    }

    @Override
    public String getSyntax() {
        return "help";
    }
}

