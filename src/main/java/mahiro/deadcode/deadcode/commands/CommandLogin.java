package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.AccountAuthenticator;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class CommandLogin
extends Command {
    public CommandLogin() {
        super("login");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray.length > 1 || stringArray[0].contains(":")) {
                Object object;
                String string2 = "";
                String string3 = "";
                if (stringArray[0].contains(":")) {
                    object = stringArray[0].split(":", 2);
                    string2 = stringArray[0];
                    string3 = stringArray[1];
                } else {
                    string2 = stringArray[0];
                    string3 = stringArray[1];
                }
                object = AccountAuthenticator.a(string2, string3);
                ChatUtils.warning(object);
            } else {
                AccountAuthenticator.a(stringArray[0]);
                ChatUtils.warning("Logged [Cracked]: " + Wrapper.INSTANCE.getMinecraft().getSession().getUsername());
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Change session.";
    }

    @Override
    public String getSyntax() {
        return "login <email> <password>/<nick>";
    }
}

