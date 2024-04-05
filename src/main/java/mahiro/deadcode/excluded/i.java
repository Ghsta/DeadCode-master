package mahiro.deadcode.excluded;

import mahiro.deadcode.deadcode.wrappers.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;

public class i
extends PlayerControllerMP {
    private float a;

    public i(Minecraft minecraft, NetHandlerPlayClient netHandlerPlayClient) {
        super(minecraft, netHandlerPlayClient);
        IAttributeInstance iAttributeInstance;
        if (Wrapper.INSTANCE.getLocalPlayer() != null && (iAttributeInstance = Wrapper.INSTANCE.getLocalPlayer().getEntityAttribute(EntityPlayer.REACH_DISTANCE)) != null) {
            this.a = (float)iAttributeInstance.getAttributeValue();
        }
    }

    public float a() {
        return this.a;
    }

    public void a(float f2) {
        this.a = f2;
    }
}

