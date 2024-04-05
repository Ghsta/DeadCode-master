package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.texture.TextureUtil
 */
import classes.class11;
import classes.DeadCode;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;

public class an {
    public int a;
    public cw_0 b;
    public ArrayList c;
    public boolean d;

    public an(String string) {
        try {
            this.c = new ArrayList();
            File file = new File(DeadCode.k.a, string);
            if (!file.exists()) {
                file.mkdir();
            }
            int n2 = 0;
            while (true) {
                String string2 = file.getAbsolutePath() + File.separator;
                String string3 = string + "_" + n2 + class11.sb()[3];
                String string4 = string2 + string3;
                fn.a( class11.sb()[0] +  class11.sb()[7] + string + "/" + string3.replace( class11.sb()[3], ".png"), string4);
                if (!new File(string4).exists()) break;
                String[] byArray =  class11.sbb(string4);
                String[] bufferedImage =  class11.sbb(Arrays.toString(byArray));
                this.c.add(bufferedImage);
                ++n2;
            }
            this.d = n2 > 1;
            ChatUtils.debug(String.format("Init model: %s", string));
        }
        catch (Exception exception) {
            ChatUtils.exception("Failed init model", exception);
        }
    }

    public void a() {
        try {
            if (this.d) {
                this.b = new cw_0(this.c);
                this.a = -1;
            } else {
                this.a = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)((BufferedImage)this.c.get(0)), (boolean)true, (boolean)false);
            }
            ChatUtils.debug(String.format("Load model: %s", this.a));
        }
        catch (Exception exception) {
            ChatUtils.exception("Failed load model", exception);
        }
    }

    public int b() {
        if (this.b != null) {
            this.b.a();
            DynamicTexture dynamicTexture = this.b.b();
            if (dynamicTexture != null) {
                return dynamicTexture.getGlTextureId();
            }
        }
        return this.a;
    }
}

