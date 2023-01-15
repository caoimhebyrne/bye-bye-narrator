package dev.cbyrne.byebyenarrator.mixins;

import com.mojang.text2speech.Narrator;
import dev.cbyrne.byebyenarrator.DummyNarrator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Narrator.class, remap = false)
public interface NarratorMixin {
    /**
     * @reason To remove the narrator from the game
     */
    @Overwrite
    static Narrator getNarrator() {
        return new DummyNarrator();
    }
}
