package mahiro.deadcode;

import classes.*;
import com.mojang.realmsclient.gui.ChatFormatting;
import mahiro.deadcode.deadcode.EventsHandler;
import mahiro.deadcode.deadcode.managers.CommandManager;
import mahiro.deadcode.deadcode.managers.HackManager;
import mahiro.deadcode.deadcode.managers.ModelManager;
import mahiro.deadcode.deadcode.managers.ShaderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import utils.*;
import mahiro.deadcode.deadcode.excluded.GuiDefault;
import mahiro.deadcode.deadcode.excluded.UIScreen;
import mahiro.deadcode.deadcode.utils.SoundPlayer;

import javax.swing.*;
import java.lang.reflect.Field;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public final class Main {
    public static final String MODID = "mahiro";
    public static final String NAME = "Mahiro";
    public static final String VERSION = "1.0";
    public static final String REVISION = "@REVISION@";
    public static final Main INSTANCE = new Main();
    public static String cName = "Mahiro Client";
    public static boolean isObfuscate;

    static {
        isObfuscate = false;
    }

    public Minecraft mc = Minecraft.getMinecraft();
    @Mod.Instance
    public Main instance;
    public String prefix;
    public boolean inited;
    public static fA e;

    public static class15 f;


    public static class5 h;

    public static CommandManager i;

    public static HackManager j;

    public static class6 k;

    public static ey l;

    public static ShaderManager m;

    public static fi n;

    public static ModelManager o;

    public static ed p;

    public static SoundPlayer q;

    public static EventsHandler r;

    public static class8 s;

    public static bS t;
    public static UIScreen uiScreen;

    public static GuiDefault guiDefault;


    public Main() {
        this.prefix = "§f[" + ChatFormatting.RED + "K§f]";
    }

    public static boolean nullCheck() {
        final Minecraft mc = Minecraft.getMinecraft();
        return mc.player == null || mc.world == null;

    }
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        (Main.INSTANCE.instance = new Main()).init();
    }
    @Mod.EventHandler
    public void init() {
        Main.INSTANCE.initialize();
    }

    public void initialize() {
        uiScreen = new UIScreen();
        guiDefault = new GuiDefault();
        EVENT_BUS.register(this);
        o = new ModelManager();
        i = new CommandManager();
        j = new HackManager();
        o = new ModelManager();
        p = new ed();
        r = new EventsHandler();
        EVENT_BUS.register(new EventsHandler());
        JOptionPane.showMessageDialog(null , "successful");
    }
    public void error(String syntaxError) {

    }

    public void setOBF() {
        instance = this;
        try {
            Field F = SPacketEntityTeleport.class.getDeclaredField("field_149456_b");
            isObfuscate = true;
        } catch (NoSuchFieldException ex) {
            try {
                Field F = SPacketEntityTeleport.class.getDeclaredField("posX");
                isObfuscate = false;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}




