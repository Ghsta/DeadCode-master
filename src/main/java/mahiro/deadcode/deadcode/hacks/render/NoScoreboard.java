/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.GuiIngameForge
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.render;

import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoScoreboard
extends Hack {
    public NoScoreboard() {
        super("NoScoreboard", HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Hiding your scoreboard.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        GuiIngameForge.renderObjective = false;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        GuiIngameForge.renderObjective = true;
        super.onDisable();
    }
}

