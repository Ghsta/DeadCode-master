/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.managers.MappingManager;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiFire
extends Hack {
    public AntiFire() {
        super("AntiFire", HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "No render fire.";
    }

    @Override
    public void onDisable() {
        this.a(false);
        super.onDisable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (Wrapper.INSTANCE.getLocalPlayer().isBurning()) {
            this.a(true);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        try {
            Field field = Entity.class.getDeclaredField(MappingManager.fieldIsImmuneToFire);
            field.setAccessible(true);
            field.setBoolean(Wrapper.INSTANCE.getLocalPlayer(), bl);
        }
        catch (Exception exception) {
            ChatUtils.exception("setImmuneToFire", exception);
        }
    }
}

