package com.ritesh;

import com.ritesh.config.ModConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ModConfig config = ModConfig.get();

            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Component.translatable("text.autoconfig.bettermaceswap.title"));

            ConfigCategory general = builder.getOrCreateCategory(Component.translatable("category.bettermaceswap.general"));
            ConfigEntryBuilder eb = builder.entryBuilder();

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.autoBreachSwapEnabled"), config.autoBreachSwapEnabled)
                    .setDefaultValue(false)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.autoBreachSwapEnabled.@Tooltip"))
                    .setSaveConsumer(v -> config.autoBreachSwapEnabled = v)
                    .build());

            general.addEntry(eb.startIntSlider(Component.translatable("text.autoconfig.bettermaceswap.option.breachSwapBackTicks"), config.breachSwapBackTicks, 1, 10)
                    .setDefaultValue(3)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.breachSwapBackTicks.@Tooltip"))
                    .setSaveConsumer(v -> config.breachSwapBackTicks = v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.autoStunSlamEnabled"), config.autoStunSlamEnabled)
                    .setDefaultValue(false)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.autoStunSlamEnabled.@Tooltip"))
                    .setSaveConsumer(v -> config.autoStunSlamEnabled = v)
                    .build());

            general.addEntry(eb.startSelector(Component.translatable("text.autoconfig.bettermaceswap.option.maceMode"), ModConfig.MaceEnchantMode.values(), config.maceMode)
                    .setDefaultValue(ModConfig.MaceEnchantMode.DENSITY)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.maceMode.@Tooltip"))
                    .setNameProvider(o -> Component.translatable("text.autoconfig.bettermaceswap.option.maceMode." + o.toString().toUpperCase()))
                    .setSaveConsumer(v -> config.maceMode = (ModConfig.MaceEnchantMode) v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.attackPlayers"), config.attackPlayers)
                    .setDefaultValue(true)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.attackPlayers.@Tooltip"))
                    .setSaveConsumer(v -> config.attackPlayers = v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.attackMobs"), config.attackMobs)
                    .setDefaultValue(true)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.attackMobs.@Tooltip"))
                    .setSaveConsumer(v -> config.attackMobs = v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.attackAnimals"), config.attackAnimals)
                    .setDefaultValue(false)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.attackAnimals.@Tooltip"))
                    .setSaveConsumer(v -> config.attackAnimals = v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.pearlCatchEnabled"), config.pearlCatchEnabled)
                    .setDefaultValue(false)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.pearlCatchEnabled.@Tooltip"))
                    .setSaveConsumer(v -> config.pearlCatchEnabled = v)
                    .build());

            general.addEntry(eb.startIntSlider(Component.translatable("text.autoconfig.bettermaceswap.option.pearlCatchDelayTicks"), config.pearlCatchDelayTicks, 1, 10)
                    .setDefaultValue(10)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.pearlCatchDelayTicks.@Tooltip"))
                    .setSaveConsumer(v -> config.pearlCatchDelayTicks = v)
                    .build());

            general.addEntry(eb.startBooleanToggle(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistEnabled"), config.aimAssistEnabled)
                    .setDefaultValue(false)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistEnabled.@Tooltip"))
                    .setSaveConsumer(v -> config.aimAssistEnabled = v)
                    .build());

            general.addEntry(eb.startIntSlider(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistRange"), config.aimAssistRange, 1, 20)
                    .setDefaultValue(6)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistRange.@Tooltip"))
                    .setSaveConsumer(v -> config.aimAssistRange = v)
                    .build());

            general.addEntry(eb.startIntSlider(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistSpeedRaw"), config.aimAssistSpeedRaw, 1, 10)
                    .setDefaultValue(3)
                    .setTooltip(Component.translatable("text.autoconfig.bettermaceswap.option.aimAssistSpeedRaw.@Tooltip"))
                    .setSaveConsumer(v -> config.aimAssistSpeedRaw = v)
                    .build());

            builder.setSavingRunnable(() -> AutoConfig.getConfigHolder(ModConfig.class).save());

            return builder.build();
        };
    }
}
