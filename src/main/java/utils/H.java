package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  net.minecraft.entity.Entity
 */
import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;

import javax.annotation.Nullable;

public final class H
implements Predicate {
    public boolean a(Entity entity) {
        return entity != null && entity.canBeCollidedWith();
    }

    @Override
    public boolean apply(@Nullable Object o) {
        return false;
    }
}

