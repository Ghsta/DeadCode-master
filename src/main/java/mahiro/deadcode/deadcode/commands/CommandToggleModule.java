package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.managers.HackManager;

public class CommandToggleModule
extends Command {
    public CommandToggleModule() {
        super("toggle");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            HackManager.getHack(stringArray[0]).toggle();
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Toggling selected hack.";
    }

    @Override
    public String getSyntax() {
        return "toggle <hackname>";
    }
}

