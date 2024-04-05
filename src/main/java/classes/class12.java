package classes;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;
import mahiro.deadcode.deadcode.excluded.GuiDefault;
import mahiro.deadcode.deadcode.hacks.other.Sleep;
import mahiro.deadcode.deadcode.utils.fontrenderer.CharData;
import mahiro.deadcode.deadcode.utils.fontrenderer.DCFont;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import utils.*;
import mahiro.deadcode.deadcode.wrappers.Wrapper;

import static utils.et.e;

public class class12 extends DCFont {

  private final int[] o = new int[32];

  public CharData[] h = new CharData[1104];

  public CharData[] i = new CharData[1104];

  public CharData[] j = new CharData[1104];

  public DynamicTexture k;

  public DynamicTexture l;

  public DynamicTexture m;

  public class12(Font paramFont, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramFont, paramBoolean1, paramBoolean2);
    e();
    for (byte b = 0; b < 32; b++) {
      int i = (b >> 3 & 0x1) * 85;
      int j = (b >> 2 & 0x1) * 170 + i;
      int k = (b >> 1 & 0x1) * 170 + i;
      int m = (b & 0x1) * 170 + i;
      if (b == 6)
        j += 85;
      if (b >= 16) {
        j /= 4;
        k /= 4;
        m /= 4;
      }
      this.o[b] = (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF;
    }
  }

  public float a(String paramString, double paramDouble1, double paramDouble2, int paramInt) {
    float f = a(paramString, paramDouble1 + 0.5D, paramDouble2 + 0.5D, paramInt, true);
    return Math.max(f, a(paramString, paramDouble1, paramDouble2, paramInt, false));
  }

  public float a(String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    return a(paramString, paramFloat1, paramFloat2, paramInt, false);
  }

  public float b(String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    return a(paramString, paramFloat1 - getStringWidth(paramString) / 2.0F, paramFloat2, paramInt);
  }

  public float c(String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    return a(paramString, (paramFloat1 - getStringWidth(paramString) / 2.0F), paramFloat2, paramInt);
  }

  public float a(String paramString, double paramDouble1, double paramDouble2, int paramInt, boolean paramBoolean) {
    try {
      if (et.a(paramString))
        return 0.0F;
      paramDouble1--;
      if (!Sleep.a && this.b.getName().contains("Aeroport") && !((Wrapper.INSTANCE.getMinecraft()).currentScreen instanceof GuiDefault) && !((Wrapper.INSTANCE.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.GuiMainMenu) && !((Wrapper.INSTANCE.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.GuiMultiplayer) && !((Wrapper.INSTANCE.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.GuiCreateWorld))
        if (paramString.contains("&q")) {
          paramString = paramString.replace("&q", "");
        } else if (RenderUtils.d.containsKey(paramString)) {
          paramString = (String)RenderUtils.d.get(paramString);
        } else if (!RenderUtils.e.contains(paramString)) {
          String str = paramString;
          boolean bool1 = true;
          for (dH dH : DeadCode.l.a()) {
            str = et.c(str);
            if (str.contains(dH.b())) {
              String str1 = str.replace(dH.b(), dH.a());
              RenderUtils.d.put(paramString, str1);
              paramString = str1;
              bool1 = false;
              break;
            }
          }
          if (bool1)
            RenderUtils.e.add(paramString);
        }
      if (paramInt == 553648127)
        paramInt = 16777215;
      if ((paramInt & 0xFC000000) == 0)
        paramInt |= 0xFF000000;
      if (paramBoolean)
        paramInt = (paramInt & 0xFCFCFC) >> 2 | paramInt & (new Color(20, 20, 20, 200)).getRGB();
      CharData[] arrayOfCharData = this.a;
      float f = (paramInt >> 24 & 0xFF) / 255.0F;
      boolean p = false;
      boolean bool = true;
      paramDouble1 *= 2.0D;
      paramDouble2 = (paramDouble2 - 3.0D) * 2.0D;
      if (bool) {
        GL11.glPushMatrix();
        GlStateManager.scale(0.5D, 0.5D, 0.5D);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((paramInt >> 16 & 0xFF) / 255.0F, (paramInt >> 8 & 0xFF) / 255.0F, (paramInt & 0xFF) / 255.0F, f);
        int i = paramString.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.g.getGlTextureId());
        GL11.glBindTexture(3553, this.g.getGlTextureId());
        for (byte b = 0; b < i; b++) {
          char c = paramString.charAt(b);
          if (String.valueOf(c).equals("§") && b < i) {
            int j = 21;
            try {
              j = "0123456789abcdefklmnor".indexOf(paramString.charAt(b + 1));
            } catch (Exception exception) {}
            if (j < 16) {
              p = false;
              GlStateManager.bindTexture(this.g.getGlTextureId());
              arrayOfCharData = this.a;
              if (j < 0 || j > 15)
                j = 15;
              if (paramBoolean)
                j += 16;
              int k = this.o[j];
              GlStateManager.color((k >> 16 & 0xFF) / 255.0F, (k >> 8 & 0xFF) / 255.0F, (k & 0xFF) / 255.0F, f);
            } else if (j == 16) {
              p = true;
            } else if (j == 17) {
              GlStateManager.bindTexture(this.k.getGlTextureId());
              arrayOfCharData = this.h;
            } else if (j != 18 && j != 19) {
              if (j == 20) {
                GlStateManager.bindTexture(this.l.getGlTextureId());
                arrayOfCharData = this.i;
              } else if (j == 21) {
                p = false;
                GlStateManager.color((paramInt >> 16 & 0xFF) / 255.0F, (paramInt >> 8 & 0xFF) / 255.0F, (paramInt & 0xFF) / 255.0F, f);
                GlStateManager.bindTexture(this.g.getGlTextureId());
                arrayOfCharData = this.a;
              }
            }
            b++;
          } else if (c >= '\000' && c <= arrayOfCharData.length) {
            String n = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
            int j = n.indexOf(c);
            if (p && j != -1) {
              int k = (arrayOfCharData[c]).width;
              while (true) {
                j = (new Random()).nextInt(n.length());
                char c1 = n.charAt(j);
                if (k == (arrayOfCharData[c1]).width) {
                  c = c1;
                  break;
                }
              }
            }
            GL11.glBegin(4);
            drawCharArray(arrayOfCharData, c, (float)paramDouble1, (float)paramDouble2);
            GL11.glEnd();
            paramDouble1 += ((arrayOfCharData[c]).width - 8 + this.f);
          }
        }
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glHint(3155, 4352);
        GL11.glPopMatrix();
      }
      return (float)paramDouble1 / 2.0F;
    } catch (Exception exception) {
      return 0.0F;
    }
  }

  public int getStringWidth(String paramString) {
    if (paramString == null)
      return 0;
    int i = 0;
    CharData[] arrayOfCharData = this.a;
    boolean bool1 = false;
    boolean bool2 = false;
    int j = paramString.length();
    for (byte b = 0; b < j; b++) {
      char c = paramString.charAt(b);
      if (String.valueOf(c).equals("§")) {
        int k = "0123456789abcdefklmnor".indexOf(c);
        if (k < 16) {
          bool1 = false;
          bool2 = false;
        } else if (k == 17) {
          bool1 = true;
          if (bool2) {
            arrayOfCharData = this.j;
          } else {
            arrayOfCharData = this.h;
          }
        } else if (k == 20) {
          bool2 = true;
          if (bool1) {
            arrayOfCharData = this.j;
          } else {
            arrayOfCharData = this.i;
          }
        } else if (k == 21) {
          bool1 = false;
          bool2 = false;
          arrayOfCharData = this.a;
        }
        b++;
      } else if (c < arrayOfCharData.length) {
        i += (arrayOfCharData[c]).width - 8 + this.f;
      }
    }
    return i / 2;
  }

  public void a(Font paramFont) {
    super.a(paramFont);
    e();
  }

  public void a(boolean paramBoolean) {
    super.a(paramBoolean);
    e();
  }

  public void b(boolean paramBoolean) {
    super.b(paramBoolean);
    e();
  }

  public void b(String paramString, double paramDouble1, double paramDouble2, int paramInt) {
    a(paramString, paramDouble1 - 0.5D, paramDouble2, Color.BLACK.getRGB(), false);
    a(paramString, paramDouble1 + 0.5D, paramDouble2, Color.BLACK.getRGB(), false);
    a(paramString, paramDouble1, paramDouble2 - 0.5D, Color.BLACK.getRGB(), false);
    a(paramString, paramDouble1, paramDouble2 + 0.5D, Color.BLACK.getRGB(), false);
    a(paramString, paramDouble1, paramDouble2, paramInt, false);
  }

  public void d(String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    b(paramString, paramFloat1 - 0.5F, paramFloat2, Color.BLACK.getRGB());
    b(paramString, paramFloat1 + 0.5F, paramFloat2, Color.BLACK.getRGB());
    b(paramString, paramFloat1, paramFloat2 - 0.5F, Color.BLACK.getRGB());
    b(paramString, paramFloat1, paramFloat2 + 0.5F, Color.BLACK.getRGB());
    b(paramString, paramFloat1, paramFloat2, paramInt);
  }
}


/* Location:              C:\Users\Administrator\Desktop\.minecraft\mods\DeadCode-Remap.jar!\ ​.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */