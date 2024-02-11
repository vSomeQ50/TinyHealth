package com.someq.tinyhealth.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_TinyHealth = "key.tinyhealthmod.tinyhealth";
    public static final String KEY_DISPLAY_Health = "key.tinyhealthmod.display_health";

    public static boolean displayHUD = true;

    public static final KeyMapping DISPLAY_KEY = new KeyMapping(KEY_DISPLAY_Health, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_TAB, KEY_TinyHealth);
}