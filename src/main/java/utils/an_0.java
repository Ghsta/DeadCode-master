package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
import classes.class11;
import mahiro.deadcode.deadcode.utils.shader.ShaderProgram;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import org.lwjgl.opengl.GL11;

/*
 * Renamed from aN
 */
public class an_0
extends ShaderProgram {
    public an_0() {
        this.a(class11.sb()[0]);
    }

    public void a(double d2, double d3, double d4, double d5) {
        if (!this.d) {
            return;
        }
        super.startUseShader();
        this.d();
        this.uniform2f("resolution", Wrapper.INSTANCE.getMinecraft().displayWidth, Wrapper.INSTANCE.getMinecraft().displayHeight);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)d4, (double)d3);
        GL11.glVertex2d((double)d2, (double)d3);
        GL11.glVertex2d((double)d2, (double)d5);
        GL11.glVertex2d((double)d4, (double)d5);
        GL11.glEnd();
        super.stopUseShader();
    }
}

