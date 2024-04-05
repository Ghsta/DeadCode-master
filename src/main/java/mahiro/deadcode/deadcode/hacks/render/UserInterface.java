package mahiro.deadcode.deadcode.hacks.render;

import classes.DeadCode;
import mahiro.deadcode.deadcode.hacks.other.Sleep;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.TimerUtils;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

public class UserInterface
extends Hack {
    public static BooleanValue a;
    public static BooleanValue b;
    public static BooleanValue c;
    public static BooleanValue d;
    public TimerUtils e;

    public UserInterface() {
        super("UserInterface", HackCategory.Render);
        this.setKey(54);
        this.d(false);
        a = new BooleanValue("Blur", false);
        b = new BooleanValue("Shadow", false);
        c = new BooleanValue("Glitch", false);
        d = new BooleanValue("Black And White", false);
        this.b("General");
        this.a(a, b, d, c);
        this.b("Other");
        this.e = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Graphical user interface.";
    }

    @Override
    public void onEnable() {
        if (Sleep.a) {
            return;
        }
        Wrapper.INSTANCE.getMinecraft().displayGuiScreen(DeadCode.s.sb());
        super.onEnable();
    }
}

