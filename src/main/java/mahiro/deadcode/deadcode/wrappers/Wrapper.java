package mahiro.deadcode.deadcode.wrappers;

import classes.DeadCode;
import mahiro.deadcode.deadcode.managers.FontManager;
import utils.bu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.Packet;

public class Wrapper {
    public static volatile Wrapper INSTANCE = new Wrapper();

    private /* synthetic */ void r() {
        if (DeadCode.g == null) {
            DeadCode.g = new FontManager();
        }
    }

    public Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public EntityPlayerSP getLocalPlayer() {
        return Wrapper.INSTANCE.getMinecraft().player;
    }

    public WorldClient getWorld() {
        return Wrapper.INSTANCE.getMinecraft().world;
    }

    public GameSettings getGameSettings() {
        return Wrapper.INSTANCE.getMinecraft().gameSettings;
    }

    public FontRenderer getFontRenderer() {
        return Wrapper.INSTANCE.getMinecraft().fontRenderer;
    }

    public bu f() {
        this.r();
        return DeadCode.g.a();
    }

    public bu g() {
        this.r();
        return DeadCode.g.b();
    }

    public bu h() {
        this.r();
        return DeadCode.g.c();
    }

    public bu i() {
        this.r();
        return DeadCode.g.d();
    }

    public bu j() {
        this.r();
        return DeadCode.g.e();
    }

    public bu k() {
        this.r();
        return DeadCode.g.f();
    }

    public bu l() {
        this.r();
        return DeadCode.g.g();
    }

    public bu m() {
        this.r();
        return DeadCode.g.h();
    }

    public bu n() {
        this.r();
        return DeadCode.g.i();
    }

    public bu o() {
        this.r();
        return DeadCode.g.j();
    }

    public bu p() {
        this.r();
        return DeadCode.g.k();
    }

    public bu q() {
        this.r();
        return DeadCode.g.l();
    }

    public void sendPacket(Packet packet) {
        Wrapper.INSTANCE.getLocalPlayer().connection.sendPacket(packet);
    }
}

