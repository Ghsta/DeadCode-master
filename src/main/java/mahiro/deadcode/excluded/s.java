package mahiro.deadcode.excluded;

import mahiro.deadcode.deadcode.excluded.GuiContainerCreative;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class s
extends Slot {
    private final Slot b;
    public final /* synthetic */ GuiContainerCreative a;

    public s(GuiContainerCreative guiContainerCreative, Slot slot, int n2) {
        super(slot.inventory, n2, 0, 0);
        this.a = guiContainerCreative;
        this.b = slot;
    }

    public ItemStack a(EntityPlayer entityPlayer, ItemStack itemStack) {
        this.b.onTake(entityPlayer, itemStack);
        return itemStack;
    }

    public boolean a(ItemStack itemStack) {
        return this.b.isItemValid(itemStack);
    }

    public ItemStack a() {
        return this.b.getStack();
    }

    public boolean b() {
        return this.b.getHasStack();
    }

    public void b(ItemStack itemStack) {
        this.b.putStack(itemStack);
    }

    public void c() {
        this.b.onSlotChanged();
    }

    public int d() {
        return this.b.getSlotStackLimit();
    }

    public int c(ItemStack itemStack) {
        return this.b.getItemStackLimit(itemStack);
    }

    public String e() {
        return this.b.getSlotTexture();
    }

    public ItemStack a(int n2) {
        return this.b.decrStackSize(n2);
    }

    public boolean a(IInventory iInventory, int n2) {
        return this.b.isHere(iInventory, n2);
    }

    public boolean f() {
        return this.b.isEnabled();
    }

    public boolean a(EntityPlayer entityPlayer) {
        return this.b.canTakeStack(entityPlayer);
    }

    public ResourceLocation g() {
        return this.b.getBackgroundLocation();
    }

    public void a(ResourceLocation resourceLocation) {
        this.b.setBackgroundLocation(resourceLocation);
    }

    public void a(String string) {
        this.b.setBackgroundName(string);
    }

    public TextureAtlasSprite h() {
        return this.b.getBackgroundSprite();
    }

    public int i() {
        return this.b.getSlotIndex();
    }

    public boolean a(Slot slot) {
        return this.b.isSameInventory(slot);
    }

    static /* synthetic */ Slot a(s s2) {
        return s2.b;
    }
}

