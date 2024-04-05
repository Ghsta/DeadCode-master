package classes;

import mahiro.deadcode.deadcode.excluded.UIScreen;
import mahiro.deadcode.deadcode.ui.theme.Theme;
import utils.*;
public class class9 extends UIScreen {
  public static Theme f;

  public cL g;

  public void c(float paramFloat) {
    this.g.c(c[0], c[1]);
  }

  public void a(int paramInt1, int paramInt2) {
    this.g.onMouseDrag(paramInt1, paramInt2);
  }

  public void a(int paramInt) {
    this.g.c(c[0], c[1], paramInt);
  }

  public void b(int paramInt1, int paramInt2) {
    this.g.onMouseRelease(paramInt1, paramInt2, 0);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3) {
    this.g.onMousePress(paramInt1, paramInt2, paramInt3);
  }

  public void a(int paramInt, char paramChar) {
    this.g.b(paramInt, paramChar);
  }

  public void b(int paramInt, char paramChar) {
    this.g.onKeyReleased(paramInt, paramChar);
  }

  public void i() {
    this.g.c();
  }

  public static Theme j() {
    return f;
  }

  public void a(Theme paramTheme) {
    f = paramTheme;
  }

  public cL k() {
    return this.g;
  }

  public void a(cL paramcL) {
    this.g = paramcL;
  }
}


/* Location:              C:\Users\Administrator\Desktop\.minecraft\mods\DeadCode-Remap.jar!\  .class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */