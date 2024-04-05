package mahiro.deadcode.excluded;

import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.item.ItemStack;

class l
implements ICrashReportDetail {
    final /* synthetic */ ItemStack a;
    final /* synthetic */ j b;

    l(j j2, ItemStack itemStack) {
        this.b = j2;
        this.a = itemStack;
    }

    public String a() {
        return String.valueOf(this.a.getMetadata());
    }

    public /* synthetic */ Object b() {
        return this.a();
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}

