/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketSpawnGlobalEntity
 */
package mahiro.deadcode.deadcode.hacks.world;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import utils.*;
public class LightningDetect
extends Hack {
    public LightningDetect() {
        super("LightningDetect", HackCategory.World);
    }

    @Override
    public String getDescription() {
        return "Display the coords of a lightning strike.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketSpawnGlobalEntity) {
            SPacketSpawnGlobalEntity sPacketSpawnGlobalEntity = (SPacketSpawnGlobalEntity)object;
            ChatUtils.warning(String.format("Lightning at: X: %s Y: %s Z: %s", sPacketSpawnGlobalEntity.getX(), sPacketSpawnGlobalEntity.getY(), sPacketSpawnGlobalEntity.getZ()));
        }
        return super.a(object, bw2);
    }
}

