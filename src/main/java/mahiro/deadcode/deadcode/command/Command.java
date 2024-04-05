package mahiro.deadcode.deadcode.command;

import mahiro.deadcode.deadcode.utils.visual.ChatUtils;

import java.util.ArrayList;
import utils.fx;
import java.util.List;

public abstract class Command {
    private String command;
    private ArrayList b;
    private boolean c;

    public Command(String string) {
        this.command = string;
        this.b = new ArrayList();
        this.c = true;
        ChatUtils.debug(String.format("Load command: %s", string));
    }

    public abstract void runCommand(String var1, String[] var2);

    public abstract String getDescription();

    public abstract String getSyntax();

    public void b(String string, int n2) {
        this.b.add(new fx(string, n2));
    }

    public String getCommand() {
        return this.command;
    }

    public List<fx> d() {
        return this.b;
    }

    public boolean e() {
        return this.c;
    }

    public void a(boolean bl) {
        this.c = bl;
    }
}

