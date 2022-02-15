package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.BetterWynnSpell;
import net.wrelf.betterwynnspell.proxy.ClientProxy;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyInputHandler {
    public KeyInputHandler(){
        prevKeyStates = new boolean[7];
        keyStates = new boolean[7];
    }

    @SubscribeEvent
    public void onTickKeyCheck(TickEvent.ClientTickEvent event) {
        KeyBinding[] keyBinds = ClientProxy.keyBindings;

        for(int i = 0; i < keyStates.length; i ++)
        {
            keyStates[i] = keyBinds[i].isPressed();
        }

        if (keyStates[0] && !prevKeyStates[0]) {
            ClickPerformer.PerformAttack();
        }

        if (keyStates[1] && !prevKeyStates[1]) {
            ClickPerformer.PerformUse();
        }

        for(int i = 0; i < keyStates.length; i ++)
        {
            prevKeyStates[i] = keyStates[i];
        }
    }
    public static boolean[] keyStates;
    public static boolean[] prevKeyStates;
}


