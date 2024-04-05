/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.value.types;

import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.Value;

public class ModeValue
extends Value {
    private Mode[] modes;
    private String modeName;
    private boolean toggled;

    public ModeValue(String string, Mode ... modeArray) {
        super(string, null);
        this.modeName = string;
        this.modes = modeArray;
        this.toggled = true;
    }

    public ModeValue(String string, boolean bl, Mode ... modeArray) {
        super(string, null);
        this.modeName = string;
        this.modes = modeArray;
        this.toggled = bl;
    }

    public void setModes(Mode[] modeArray) {
        this.modes = modeArray;
    }

    public Mode[] getModes() {
        return this.modes;
    }

    public Mode getMode(String string) {
        for (Mode mode : this.modes) {
            if (!mode.getName().equals(string)) continue;
            return mode;
        }
        return null;
    }

    public Mode getModeByIndex(int n2) {
        return this.modes[n2];
    }

    public String getModeName() {
        return this.modeName;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public void setToggled(boolean bl) {
        this.toggled = bl;
    }
}

