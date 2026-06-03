package com.ritesh.keybind;

import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static KeyMapping BREACH_SWAP_TOGGLE;
    public static KeyMapping STUN_SLAM_TOGGLE;
    public static KeyMapping MACE_MODE_CYCLE;
    public static KeyMapping PEARL_CATCH_TOGGLE;
    public static KeyMapping AIM_ASSIST_TOGGLE;

    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath("bettermaceswap", "general"));

    public static void register() {

        BREACH_SWAP_TOGGLE = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.bettermaceswap.breach_swap_toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                CATEGORY
        ));

        STUN_SLAM_TOGGLE = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.bettermaceswap.stun_slam_toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                CATEGORY
        ));

        MACE_MODE_CYCLE = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.bettermaceswap.mace_mode_cycle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                CATEGORY
        ));

        PEARL_CATCH_TOGGLE = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.bettermaceswap.pearl_catch_toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                CATEGORY
        ));

        AIM_ASSIST_TOGGLE = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.bettermaceswap.aim_assist_toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                CATEGORY
        ));
    }
}
