/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 */
package mahiro.deadcode.deadcode.commands;

import mahiro.deadcode.deadcode.command.Command;
import mahiro.deadcode.deadcode.utils.MathUtils;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.math.BigInteger;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CommandHorizontalClip
extends Command {
    public CommandHorizontalClip() {
        super("hclip");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            float f2 = MathUtils.a((Entity)entityPlayerSP);
            double d2 = -MathHelper.sin((float)f2) * (float)new BigInteger(stringArray[0]).longValue();
            double d3 = MathHelper.cos((float)f2) * (float)new BigInteger(stringArray[0]).longValue();
            entityPlayerSP.setPosition(entityPlayerSP.posX + d2, entityPlayerSP.posY, entityPlayerSP.posZ + d3);
            ChatUtils.info("Teleported to " + new BigInteger(stringArray[0]).longValue());
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Teleports you forward/back.";
    }

    @Override
    public String getSyntax() {
        return "hclip <value>";
    }
}

