/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundEvent
 */
package mahiro.deadcode.deadcode.utils;

import classes.class11;
import classes.class6;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.io.File;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;import utils.*;

public class SoundPlayer {
    public final File a;

    public SoundPlayer() {
        this.a = new File(class6.g.b, "hit.wav");
    }

    public void a() {
        fn.a(class11.sb()[0] + class11.sb()[6] + this.a.getName(), this.a.getAbsolutePath());
    }

    public static void b() {
        SoundPlayer.a(SoundEvents.BLOCK_SHULKER_BOX_OPEN);
    }

    public static void c() {
        SoundPlayer.a(SoundEvents.BLOCK_NOTE_HAT);
    }

    public static synchronized void a(File file, float f2) {
        if (!file.exists()) {
            return;
        }
        new MusicPlayerThread(file, f2).start();
    }

    public static void a(SoundEvent soundEvent) {
        Wrapper.INSTANCE.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)soundEvent, (float)1.0f));
    }
}

