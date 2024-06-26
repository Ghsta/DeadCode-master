/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiContainerCreative
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.GameType
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package mahiro.deadcode.deadcode.hacks.other;

import mahiro.deadcode.deadcode.excluded.GuiContainerCreative;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import utils.*;
public class FakeCreative
extends Hack {
    public GameType a;
    public BooleanValue b;

    public FakeCreative() {
        super("FakeCreative", HackCategory.Other);
        this.b("General");
        this.b = new BooleanValue("Show items ID", true);
        this.a(this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Visual change your game mode to Creative.";
    }

    @Override
    public void onGuiOpenEvent(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.getGui() instanceof GuiContainerCreative) {
            guiOpenEvent.setGui((GuiScreen)new GuiContainerCreative((EntityPlayer) Wrapper.INSTANCE.getLocalPlayer()));
        }
        super.onGuiOpenEvent(guiOpenEvent);
    }

    @Override
    public void onDisable() {
        if (this.a == null) {
            return;
        }
        cs.a.b().setGameType(this.a);
        this.a = null;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (cs.a.b().getCurrentGameType() == GameType.CREATIVE) {
            return;
        }
        this.a = cs.a.b().getCurrentGameType();
        cs.a.b().setGameType(GameType.CREATIVE);
        super.onClientTickEvent(clientTickEvent);
    }
}

