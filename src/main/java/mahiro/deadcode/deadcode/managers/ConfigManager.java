/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.managers;

import classes.class6;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;

import java.awt.Desktop;

public class ConfigManager
extends Command {
    public ConfigManager() {
        super("config");
        this.a(false);
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("open")) {
                Desktop.getDesktop().open(class6.g.a);
            } else {
                class6.sbb(stringArray[0]);
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Config manager.";
    }

    @Override
    public String getSyntax() {
        return "config <name>, config open";
    }
}

