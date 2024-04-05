package mahiro.deadcode.unknown;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.ui.base.Component;
import mahiro.deadcode.deadcode.ui.base.ComponentType;
import org.lwjgl.input.Keyboard;
import utils.*;
import classes.*;
public class Unknown6
extends Component {
    public String a;
    public Hack b;
    public boolean c;
    public boolean d;
    public eC e;
    public eC f;
    public eC g;
    public aB h;

    public Unknown6(int n2, int n3, int n4, int n5, Component component, Hack hack) {
        super(n2, n3, n4, n5, ComponentType.o, component);
        this.b = hack;
        byte class27 = DeadCode.f.ifff();
        this.a = String.format("%s@%s~$: cd %s/%s", (class27), "DeadCode".toLowerCase(), hack.getCategory().toString().toLowerCase(), hack.getName().toLowerCase());
        this.e = DeadCode.n.a("Other", "Setting-Enabled");
        this.f = DeadCode.n.a("Other", "Setting-Disabled");
        this.g = DeadCode.n.a("Other", "Close");
        this.c = hack.getSettings().size() < 1;
        this.h = new aB(20L, true);
    }

    @Override
    public void c() {
        if (Keyboard.getEventKeyState() && this.d) {
            if (Keyboard.getEventKey() == 211) {
                this.b.setKey(-1);
                this.b.d(-1);
            } else {
                this.b.d(-1);
                this.b.setKey(Keyboard.getEventKey());
            }
            this.d = false;
        }
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        switch (n4) {
            case 0: {
                this.b.toggle();
                break;
            }
            case 1: {
                if (this.c) break;
                this.h.a(this.a);
                DeadCode.s.sb().k().d().a = this;
                break;
            }
            case 2: {
                this.d = !this.d;
                break;
            }
            default: {
                if (!this.d) break;
                this.b.setKey(-1);
                this.b.d(n4);
                this.d = false;
            }
        }
        super.onMousePress(n2, n3, n4);
    }
}

