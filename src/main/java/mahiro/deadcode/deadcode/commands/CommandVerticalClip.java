package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

import java.math.BigInteger;

public class CommandVerticalClip
extends Command {
    public CommandVerticalClip() {
        super("vclip");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            Wrapper.INSTANCE.getLocalPlayer().setPosition( utils.cs.a.d(),  utils.cs.a.e() + (double)new BigInteger(stringArray[0]).longValue(),utils.cs.a.f());
            ChatUtils.info("Height teleported to " + new BigInteger(stringArray[0]).longValue());
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Teleports you up/down.";
    }

    @Override
    public String getSyntax() {
        return "vclip <height>";
    }
}

