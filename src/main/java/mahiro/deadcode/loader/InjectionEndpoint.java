package mahiro.deadcode.loader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import mahiro.deadcode.Main;

// Reserved class for hot injection
public class InjectionEndpoint {
    public static void tryLoad(String account, String token) {
        (Main.INSTANCE.instance = new Main()).init();
    }
}
