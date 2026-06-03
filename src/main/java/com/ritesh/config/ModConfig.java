package com.ritesh.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

@Config(name = "bettermaceswap")
public class ModConfig implements ConfigData {

    public boolean autoBreachSwapEnabled = false;

    @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
    public int breachSwapBackTicks = 3;

    public boolean autoStunSlamEnabled = false;

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public MaceEnchantMode maceMode = MaceEnchantMode.DENSITY;

    public boolean attackPlayers = true;
    public boolean attackMobs = true;
    public boolean attackAnimals = false;

    public boolean pearlCatchEnabled = false;

    @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
    public int pearlCatchDelayTicks = 10;

    public boolean aimAssistEnabled = false;

    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int aimAssistRange = 6;

    @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
    public int aimAssistSpeedRaw = 3;

    public float getAimAssistSpeed() {
        return aimAssistSpeedRaw * 0.5f;
    }

    public enum MaceEnchantMode {
        DENSITY,
        BREACH;

        @Override
        public String toString() {
            return this == DENSITY ? "Density" : "Breach";
        }

        public Component asText() {
            if (this == DENSITY) {
                return Component.literal("Density").withStyle(ChatFormatting.YELLOW);
            } else {
                return Component.literal("Breach").withStyle(ChatFormatting.DARK_PURPLE);
            }
        }
    }

    public static ModConfig get() {
        return me.shedaniel.autoconfig.AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}
