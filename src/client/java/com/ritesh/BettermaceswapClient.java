package com.ritesh;

import com.ritesh.config.ModConfig;
import com.ritesh.feature.AutoFeatures;
import com.ritesh.keybind.KeyBindings;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResult;

public class BettermaceswapClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBindings.register();

        UseItemCallback.EVENT.register((player, world, hand) -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player != null && player == client.player) {
                if (player.getItemInHand(hand).is(Items.ENDER_PEARL)) {
                    AutoFeatures.onPearlThrown(client.player);
                }
            }
            return InteractionResult.PASS;
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            ModConfig cfg = ModConfig.get();

            if (KeyBindings.BREACH_SWAP_TOGGLE.consumeClick()) {
                cfg.autoBreachSwapEnabled = !cfg.autoBreachSwapEnabled;
                AutoConfig.getConfigHolder(ModConfig.class).save();
                client.gui.setOverlayMessage(
                        Component.literal("Attribute Swap: ")
                                .append(Component.literal(cfg.autoBreachSwapEnabled ? "ON" : "OFF")
                                        .withStyle(cfg.autoBreachSwapEnabled ? ChatFormatting.GREEN : ChatFormatting.RED)),
                        false
                );
            }

            if (KeyBindings.STUN_SLAM_TOGGLE.consumeClick()) {
                cfg.autoStunSlamEnabled = !cfg.autoStunSlamEnabled;
                AutoConfig.getConfigHolder(ModConfig.class).save();
                client.gui.setOverlayMessage(
                        Component.literal("Stun Slam: ")
                                .append(Component.literal(cfg.autoStunSlamEnabled ? "ON" : "OFF")
                                        .withStyle(cfg.autoStunSlamEnabled ? ChatFormatting.GREEN : ChatFormatting.RED)),
                        false
                );
            }

            if (KeyBindings.MACE_MODE_CYCLE.consumeClick()) {
                cfg.maceMode = (cfg.maceMode == ModConfig.MaceEnchantMode.DENSITY)
                        ? ModConfig.MaceEnchantMode.BREACH
                        : ModConfig.MaceEnchantMode.DENSITY;
                AutoConfig.getConfigHolder(ModConfig.class).save();

                boolean isDensity = (cfg.maceMode == ModConfig.MaceEnchantMode.DENSITY);
                client.gui.setOverlayMessage(
                        Component.literal("Mode: ")
                                .append(Component.literal(isDensity ? "Density" : "Breach")
                                        .withStyle(isDensity ? ChatFormatting.YELLOW : ChatFormatting.DARK_PURPLE)),
                        false
                );
            }

            if (KeyBindings.PEARL_CATCH_TOGGLE.consumeClick()) {
                cfg.pearlCatchEnabled = !cfg.pearlCatchEnabled;
                AutoConfig.getConfigHolder(ModConfig.class).save();
                client.gui.setOverlayMessage(
                        Component.literal("Pearl Catch: ")
                                .append(Component.literal(cfg.pearlCatchEnabled ? "ON" : "OFF")
                                        .withStyle(cfg.pearlCatchEnabled ? ChatFormatting.GREEN : ChatFormatting.RED)),
                        false
                );
            }

            if (KeyBindings.AIM_ASSIST_TOGGLE.consumeClick()) {
                cfg.aimAssistEnabled = !cfg.aimAssistEnabled;
                AutoConfig.getConfigHolder(ModConfig.class).save();
                client.gui.setOverlayMessage(
                        Component.literal("Aim Assist: ")
                                .append(Component.literal(cfg.aimAssistEnabled ? "ON" : "OFF")
                                        .withStyle(cfg.aimAssistEnabled ? ChatFormatting.GREEN : ChatFormatting.RED)),
                        false
                );
            }

            AutoFeatures.tick(client);
        });
    }
}
