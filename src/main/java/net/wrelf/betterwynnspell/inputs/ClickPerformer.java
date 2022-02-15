package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class ClickPerformer {
    public static void PerformAttack() {
        KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode());
    }
    public static void PerformUse() {
        KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindUseItem.getKeyCode());
    }
}
