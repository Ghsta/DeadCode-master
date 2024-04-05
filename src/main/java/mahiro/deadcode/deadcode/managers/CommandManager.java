/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.managers;

import classes.DeadCode;
import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.hacks.other.Sleep;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.commands.CommandBind;
import mahiro.deadcode.deadcode.commands.CommandDumpPlayers;
import mahiro.deadcode.deadcode.commands.CommandEffectManager;
import mahiro.deadcode.deadcode.commands.CommandFriendManager;
import mahiro.deadcode.deadcode.commands.CommandGPS;
import mahiro.deadcode.deadcode.commands.CommandHelp;
import mahiro.deadcode.deadcode.commands.CommandHorizontalClip;
import mahiro.deadcode.deadcode.commands.CommandLogin;
import mahiro.deadcode.deadcode.commands.CommandNoCom;
import mahiro.deadcode.deadcode.commands.CommandPickupFilter;
import mahiro.deadcode.deadcode.commands.CommandSay;
import mahiro.deadcode.deadcode.commands.CommandTeleport;
import mahiro.deadcode.deadcode.commands.CommandToggleModule;
import mahiro.deadcode.deadcode.commands.CommandVerticalClip;
import mahiro.deadcode.deadcode.commands.CommandXRay;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

import java.util.ArrayList;import utils.*;

public class CommandManager {
    public static final String a = ".";
    public static Command[] commands;
    private static ArrayList<Command> b;

    public CommandManager() {
        b = new ArrayList();
        b.add(new CommandHelp());
        b.add(new CommandBind());
        b.add(new CommandVerticalClip());
        b.add(new CommandHorizontalClip());
        b.add(new CommandLogin());
        b.add(new CommandSay());
        b.add(new CommandEffectManager());
        b.add(new CommandNoCom());
        b.add(new CommandGPS());
        b.add(new CommandDumpPlayers());
        b.add(new CommandTeleport());
        b.add(new CommandFriendManager());
        b.add(new CommandToggleModule());
        b.add(new ConfigManager());
        b.add(new CommandPickupFilter());
        b.add(new CommandXRay());
        ChatUtils.debug("Loaded [" + b.size() + "] commands.");
        ChatUtils.debug("CommandManager: initialized.");
    }

    public static ArrayList<Command> a() {
        return b;
    }
    public static Command getCommand(String string) {
        Command command = null;
        for (Command command2 : CommandManager.a()) {
            if (!command2.getCommand().equalsIgnoreCase(string)) continue;
            command = command2;
            break;
        }
        return command;
    }

    public static void executeCommand(String string) {
        if (Sleep.a) {
            return;
        }
        DeadCode.p.a(">_", string, aX.h, aX.h, 0.01);
        string = a + string;
        String string2 = string.trim().substring(a.length()).trim();
        boolean bl = false;
        boolean bl2 = string2.trim().contains(" ");
        String string3 = bl2 ? string2.split(" ")[0] : string2.trim();
        String[] stringArray = bl2 ? string2.substring(string3.length()).trim().split(" ") : new String[]{};
        for (Command command : b) {
            if (!command.getCommand().trim().equalsIgnoreCase(string3.trim())) continue;
            command.runCommand(string2, stringArray);
            bl = true;
            break;
        }
        if (!bl) {
            ChatUtils.error("Cannot resolve internal command: \u00a7c" + string3);
        }
    }

    public static void a(int n2) {
        if (Wrapper.INSTANCE.getMinecraft().currentScreen != null) {
            return;
        }
        for (Command command : b) {
            if (command.d().isEmpty()) continue;
            for (fx fx2 : command.d()) {
                if (fx2.b() != n2) continue;
                CommandManager.executeCommand(fx2.a());
            }
        }
    }
}

