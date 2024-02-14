package com.someq.tinyhealth;

import com.mojang.logging.LogUtils;
import com.someq.tinyhealth.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import net.minecraft.world.entity.player.Player;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinyHealth.MODID)
public class TinyHealth {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tiny_health";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TinyHealth() {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class HealthOverlay {
        @SubscribeEvent
        public static void registerOverlay(RegisterGuiOverlaysEvent event) {
            // 创建一个自定义的HUD元素
            final IGuiOverlay HEALTH_OVERLAY = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {

                // 获取玩家实例
                Player player = Minecraft.getInstance().player;
                if (KeyBinding.displayHUD && !player.isCreative() && !player.isSpectator()) {
                    final Minecraft client = Minecraft.getInstance();
                    final ForgeGui guig = (ForgeGui) client.gui;
                    int width = gui.getMinecraft().getWindow().getGuiScaledWidth();
                    int height = gui.getMinecraft().getWindow().getGuiScaledHeight();
                    int left = width / 2 - 91 + 1;
                    int top = height - guig.leftHeight + 10;
                    if (player.getArmorValue() != 0) {
                        top -= 10;
                    }


                    // 获取血量和最大血量
                    float health = player.getHealth();
                    float maxHealth = player.getMaxHealth();
                    // 格式化字符串
                    String healthString = String.format("%.0f/%.0f", health, maxHealth);
                    // 获取字体
                    Font font = gui.getFont();
                    // 绘制字符串，你可以根据你的喜好调整坐标和颜色
                    guiGraphics.drawString(font, "❤", left, top, 0xFF0000);
                    guiGraphics.drawString(font, healthString, left + 10, top, 0xFFFF00);
                }
            });
            // 注册这个HUD元素，你可以根据你的喜好调整位置和ID
            event.registerAboveAll("health_overlay", HEALTH_OVERLAY);
        }
    }
}
