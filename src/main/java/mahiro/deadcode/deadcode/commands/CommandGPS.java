package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.hacks.render.TargetDirection;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;

public class CommandGPS
extends Command {
    public CommandGPS() {
        super("gps");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("reset")) {
                TargetDirection.d();
                ChatUtils.info("GPS Position reset.");
            } else {
                int n2 = Integer.parseInt(stringArray[0]);
                int n3 = Integer.parseInt(stringArray[1]);
                TargetDirection.a(n2, n3);
                ChatUtils.info(String.format("GPS Position X: %s, Z: %s.", n2, n3));
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "GPS manager.";
    }

    @Override
    public String getSyntax() {
        return "gps <utils.x> <z> | gps reset";
    }
}

