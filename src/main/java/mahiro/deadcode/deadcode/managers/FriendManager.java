/*
 * Decompiled with CFR 0.152.
 */
package mahiro.deadcode.deadcode.managers;

import classes.DeadCode;
import classes.class6;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;

import java.util.ArrayList;

public class FriendManager {
    public static ArrayList<String> a = new ArrayList();

    public static void a(String string) {
        if (a.contains(string)) {
            FriendManager.c(string);
        } else {
            FriendManager.b(string);
        }
    }

    public static void b(String string) {
        if (!a.contains(string)) {
            a.add(string);
            FriendManager.b();
            ChatUtils.info(string + " Added to \u00a7bfriend \u00a77list.");
        }
    }

    public static void c(String string) {
        if (a.contains(string)) {
            a.remove(string);
            FriendManager.b();
            if (DeadCode.l != null) {
                DeadCode.l.a(string);
            }
            ChatUtils.info(string + " Removed from \u00a7bfriend \u00a77list.");
        }
    }

    public static void a() {
        if (!a.isEmpty()) {
            a.clear();
            FriendManager.b();
            ChatUtils.info("\u00a7bFriends \u00a77list clear.");
        }
    }

    private static /* synthetic */ void b() {
        try {
            if (class6.g != null) {
                class6.g.mmm();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("FriendManager: save", exception);
        }
    }
}

