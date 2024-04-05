/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraftforge.client.GuiIngameForge
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.value.Mode;
import mahiro.deadcode.deadcode.value.types.ColorValue;
import mahiro.deadcode.deadcode.value.types.DoubleValue;
import mahiro.deadcode.deadcode.value.types.ModeValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.GuiIngameForge;
import utils.*;
public class Crosshair
extends Hack {
    public ModeValue a = new ModeValue("Crosshair type", new Mode("Radial", true), new Mode("Default"));
    public DoubleValue b = new DoubleValue("Size", 5.0, 2.0, 30.0);
    public DoubleValue c = new DoubleValue("Width", 1.0, 0.5, 5.0);
    public ColorValue d = new ColorValue("Color", aX.i);

    public Crosshair() {
        super("Crosshair", HackCategory.Render);
        this.b("General");
        this.a(this.d, this.a);
        this.b("Default");
        this.a(this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Draw custom crosshair.";
    }

    @Override
    public void onDisable() {
        GuiIngameForge.renderCrosshairs = true;
        super.onDisable();
    }

    @Override
    public void a(float f2) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        GuiIngameForge.renderCrosshairs = false;
        int n2 = scaledResolution.getScaledWidth() / 2;
        int n3 = scaledResolution.getScaledHeight() / 2;
        if (this.a.getModeByIndex(0).isToggled()) {
            float f3 = Wrapper.INSTANCE.getLocalPlayer().getCooledAttackStrength(f2);
            RenderUtils.a((float)n2, (float)n3, 5.0f, f3, false, aX.f, (int)this.d.getValue());
        } else if (this.a.getModeByIndex(1).isToggled()) {
            float f4 = this.b.getValue().floatValue();
            float f5 = this.c.getValue().floatValue();
            RenderUtils.a((double)n2, (double)((float)n3 - (f4 - f5)), (double)((float)n2 + f5), (double)((float)n3 + f4), (int)this.d.getValue());
            RenderUtils.a((float)n2 - (f4 - f5), (double)n3, (double)((float)n2 + f4), (double)((float)n3 + f5), (int)this.d.getValue());
        }
        super.a(f2);
    }
}

