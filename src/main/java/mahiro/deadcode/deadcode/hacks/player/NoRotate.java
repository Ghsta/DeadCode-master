/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 */
package mahiro.deadcode.deadcode.hacks.player;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.MappingManager;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import utils.*;
public class NoRotate
extends Hack {
    public NoRotate() {
        super("NoRotate", HackCategory.Player);
    }

    @Override
    public String getDescription() {
        return "No set rotation from server.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketPlayerPosLook) {
            SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)object;
            if (Wrapper.INSTANCE.getLocalPlayer().rotationYaw != 0.0f && Wrapper.INSTANCE.getLocalPlayer().rotationPitch != 0.0f) {
                try {
                    Class<?> clazz = sPacketPlayerPosLook.getClass();
                    Field field = clazz.getDeclaredField(MappingManager.fieldRotationYaw1);
                    field.setAccessible(true);
                    Field field2 = clazz.getDeclaredField(MappingManager.fieldRotationPitch1);
                    field2.setAccessible(true);
                    field.setFloat(sPacketPlayerPosLook, Wrapper.INSTANCE.getLocalPlayer().rotationYaw);
                    field2.setFloat(sPacketPlayerPosLook, Wrapper.INSTANCE.getLocalPlayer().rotationPitch);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        return super.a(object, bw2);
    }
}

