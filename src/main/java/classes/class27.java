package classes;


import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;

public class class27 extends Hack {

    public BooleanValue a;

    public class27() {
        super("class27", HackCategory.Other);
        b("General");
        this.a = new BooleanValue("Clear traces", true);
        a(this.a);
        b("Other");
    }

    public native String getDescription();

    public native void onEnable();
}


/* Location:              C:\Users\Administrator\Desktop\.minecraft\mods\DeadCode-Remap.jar!\  .class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */