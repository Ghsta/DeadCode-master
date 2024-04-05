package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;

import java.io.File;

public class class7 {

    public File a;
    public File b;
    private Gson c;
    private JsonParser d;
    private File e;
    private File f;
    private File g;
    private File h;
    private File i;

    public class7(String paramString) {
        try {
            this.c = (new GsonBuilder()).setPrettyPrinting().create();
            this.d = new JsonParser();
            this.a = new File(class6.b, paramString);
            this.e = aaa(class11.sb()[0]);
            this.f = aaa(class11.sb()[1]);
            this.g = aaa(class11.sb()[2]);
            this.h = aaa(class11.sb()[3]);
            this.i = aaa(class11.sb()[4]);
            if (!this.a.exists())
                this.a.mkdir();
            this.b = aaa("Sounds");
            if (!this.b.exists())
                this.b.mkdir();
      /*
      if (!this.e.exists()) {
        //sb();
      } else {
        //sbbb();
      }
      if (!this.f.exists()) {
        if();
      } else {
        sbbbb();
      }
      if (!this.g.exists()) {
        //case();
      } else {
        //sbbbbbb();
      }
      if (!this.h.exists()) {
        //goto();
      } else {
        //class();
      }
      if (!this.i.exists()) {
        //super();
      } else {
        //sbbbbb();
      }
       */
            ChatUtils.debug("Configuration: initialized.");
        } catch (Exception exception) {
            ChatUtils.exception("Config load error.", exception);
        }
    }

    //true
    public native File aaa(String paramString);

    //if
    public native File bbb(String paramString);

    //break
    public native void ccc();

    //byte
    public native void ddd();

    //void
    public native void eee();

    //catch
    public native void fff();

    //case
    public native void ggg();

    //class
    public native void hhh();

    //goto
    public native void iii();

    //super
    public native void mmm();

    public native void aaa();

    public native void bbb();
}





/* Location:              C:\Users\Administrator\Desktop\.minecraft\mods\DeadCode-Remap.jar!\   .class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */