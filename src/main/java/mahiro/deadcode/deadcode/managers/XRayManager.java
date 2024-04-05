/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 */
package mahiro.deadcode.deadcode.managers;

import classes.class6;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.xray.XRayData;

import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.block.Block;

public class XRayManager {
    public static LinkedList<XRayData> a = new LinkedList();

    private static /* synthetic */ void b() {
        try {
            if (class6.g != null) {
                class6.g.ggg();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("XRayManager: saveXRayData", exception);
        }
    }

    public static LinkedList a(int var0) {
        LinkedList var1 = new LinkedList();
        Iterator var2 = a.iterator();

        while(var2.hasNext()) {
            XRayData var3 = (XRayData)var2.next();
            if (var3.getId() == var0) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public static XRayData b(int var0) {
        XRayData var1 = null;
        Iterator var2 = a.iterator();

        while(var2.hasNext()) {
            XRayData var3 = (XRayData)var2.next();
            if (var3.getMeta() == var0) {
                var1 = var3;
            }
        }

        return var1;
    }

    public static void a(XRayData var0) {
        if (Block.getBlockById(var0.getId()) == null) {
            ChatUtils.error("Block is null.");
        } else {
            LinkedList var1 = a(var0.getId());
            if (var1.isEmpty()) {
                b(var0);
            } else {
                boolean var2 = false;
                boolean var3 = false;
                Iterator var4 = var1.iterator();

                while(var4.hasNext()) {
                    XRayData var5 = (XRayData)var4.next();
                    if (var5.getId() == var0.getId()) {
                        var2 = true;
                    }

                    if (var5.getMeta() == var0.getMeta()) {
                        var3 = true;
                    }
                }

                if (!var2 || !var3) {
                    b(var0);
                }
            }
        }
    }

    public static void b(XRayData var0) {
        a.add(var0);
        b();
        ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77META: \u00a73%s \u00a77NAME: \u00a73%s \u00a77RGB: \u00a7c%s\u00a77, \u00a7a%s\u00a77, \u00a79%s \u00a77- ADDED.", var0.getId(), var0.getMeta(), Block.getBlockById(var0.getId()).getLocalizedName(), var0.getRed(), var0.getGreen(), var0.getBlue()));
    }

    public static void c(int var0) {
        Iterator var1 = a(var0).iterator();

        while(var1.hasNext()) {
            XRayData var2 = (XRayData)var1.next();
            if (a.contains(var2)) {
                a.remove(var2);
                b();
                ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77NAME: \u00a73%s \u00a77RGB: \u00a7c%s\u00a77, \u00a7a%s\u00a77, \u00a79%s \u00a77- REMOVED.", var2.getId(), Block.getBlockById(var2.getId()).getLocalizedName(), var2.getRed(), var2.getGreen(), var2.getBlue()));
            }
        }

    }
}
