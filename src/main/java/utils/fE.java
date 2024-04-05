package utils;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.managers.HackManager;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;

public class fE {
    private static boolean a;
    private static int b;

    private static /* synthetic */ boolean c() {
        if (a) {
            return a;
        }
        Hack hack = HackManager.getHack("DiscordRPC");
        try {
            if (!hack.isToggled()) {
                return false;
            }

            b = 0;
            a = true;
        }
        catch (Exception exception) {
            hack.c(false);
            ChatUtils.exception("DiscordRPC init(): ", exception);
        }
        return a;
    }

    public static void a() {
        if (!fE.c()) {
            return;
        }
        try {
            if (b % 40 == 0) {
                long l2 = 0L;
                l2 = System.currentTimeMillis() - (long)(b * 26);

                }
            if (b % 200 == 0) {
            }
            ++b;
        }
        catch (Exception exception) {
            ChatUtils.exception("DiscordRPC tick(): ", exception);
        }
    }

    public static void b() {
        if (!a) {
            return;
        }
        try {
        }
        catch (Exception exception) {
            ChatUtils.exception("DiscordRPC destroy(): ", exception);
        }
        a = false;
    }
}

