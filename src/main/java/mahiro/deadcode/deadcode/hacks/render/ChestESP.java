/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockChest$Type
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityMinecartChest
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityEnderChest
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package mahiro.deadcode.deadcode.hacks.render;
import utils.*;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.hack.HackCategory;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.utils.visual.RenderUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.util.ArrayDeque;
import net.minecraft.block.BlockChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ChestESP
extends Hack {
    private int b = 1000;
    public boolean a = true;
    private ArrayDeque c = new ArrayDeque();
    private ArrayDeque d = new ArrayDeque();
    private String[] e = new String[]{"TileEntityIronChest", "TileEntityGoldChest", "TileEntityDiamondChest", "TileEntityCopperChest", "TileEntitySilverChest", "TileEntityCrystalChest", "TileEntityObsidianChest", "TileEntityDirtChest"};
    private boolean f = true;

    public ChestESP() {
        super("ChestESP", HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Allows you to see all of the chests around you.";
    }

    @Override
    public void onEnable() {
        this.a = true;
        this.c.clear();
        this.d.clear();
        super.onEnable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        TileEntity tileEntity;
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < Wrapper.INSTANCE.getWorld().loadedTileEntityList.size(); ++n2) {
            tileEntity = (TileEntity)Wrapper.INSTANCE.getWorld().loadedTileEntityList.get(n2);
            if (n3 >= this.b) break;
            if (tileEntity instanceof TileEntityChest) {
                int n4;
                ++n3;
                int n5 = n4 = ((TileEntityChest) tileEntity).getChestType() == BlockChest.Type.TRAP ? 1 : 0;
                if (this.c.contains(tileEntity)) {
                    RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 0.25f, 0.25f, 0.25f);
                } else if (this.d.contains(tileEntity)) {
                    if (n4 != 0) {
                        RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 1.0f, 0.0f, 0.0f);
                    } else {
                        RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 0.0f, 0.4f, 1.0f);
                    }
                } else if (n4 != 0) {
                    RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 1.0f, 0.0f, 0.0f);
                } else {
                    RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 0.0f, 0.4f, 1.0f);
                }
                if (n4 != 0) {
                    RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 1.0f, 0.0f, 0.0f);
                    continue;
                }
                RenderUtils.a(((TileEntityChest) tileEntity).getPos(), 0.0f, 0.4f, 1.0f);
                continue;
            }
            if (tileEntity instanceof TileEntityEnderChest) {
                ++n3;
                RenderUtils.a(((TileEntityEnderChest)tileEntity).getPos(), 1.0f, 0.0f, 1.0f);
                continue;
            }
            if (!this.f) continue;
            try {
                for (String string : this.e) {
                    Class<?> clazz = Class.forName("cpw.mods.ironchest.common.tileentity.chest." + string);
                    if (clazz == null || !clazz.isInstance(tileEntity)) continue;
                    RenderUtils.a(tileEntity.getPos(), 0.7f, 0.7f, 0.7f);
                }
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.f = false;
            }
        }
        for (n2 = 0; n2 < et.b().size(); ++n2) {
            if (n3 >= this.b) break;
            continue;
        }
        if (n3 >= this.b && this.a) {
            ChatUtils.warning("To prevent lag, it will only show the first " + this.b + " chests.");
            this.a = false;
        } else if (n3 < this.b) {
            this.a = true;
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

