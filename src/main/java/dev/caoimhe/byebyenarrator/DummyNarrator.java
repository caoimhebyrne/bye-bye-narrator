package dev.caoimhe.byebyenarrator;

import com.mojang.text2speech.Narrator;

/**
 * An implementation of Minecraft's Narrator, designed to make it do nothing.
 * This fixes it attempting to load x86_64 libraries under arm64 JVMs.
 */
public class DummyNarrator implements Narrator {
    @Override
    public void say(String msg) {
        // Do nothing
    }

    @Override
    public void clear() {
        // Do nothing
    }

    @Override
    public boolean active() {
        return false;
    }
}