package com.someq.tinyhealth.event;

import com.someq.tinyhealth.TinyHealth;
import com.someq.tinyhealth.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.InputEvent;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TinyHealth.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.DISPLAY_KEY.consumeClick()) {
                KeyBinding.displayHUD = !KeyBinding.displayHUD;
            }
        }
    }

    @Mod.EventBusSubscriber(modid = TinyHealth.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DISPLAY_KEY);
        }
    }
}