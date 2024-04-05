package mahiro.deadcode.excluded;

import com.google.common.base.Predicate;
import mahiro.deadcode.deadcode.excluded.EntityRendererHook;
import net.minecraft.entity.Entity;

import javax.annotation.Nullable;

class r
implements Predicate {
    final /* synthetic */ EntityRendererHook a;

    r(EntityRendererHook entityRendererHook) {
        this.a = entityRendererHook;
    }

    public boolean a(Entity entity) {
        return entity != null && entity.canBeCollidedWith();
    }

    @Override
    public boolean apply(@Nullable Object o) {
        return false;
    }
}

