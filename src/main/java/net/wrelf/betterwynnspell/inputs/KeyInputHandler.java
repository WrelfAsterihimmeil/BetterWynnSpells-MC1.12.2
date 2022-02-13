package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.proxy.ClientProxy;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;

import java.awt.event.KeyEvent;

public class KeyInputHandler {
    @SubscribeEvent
    public void onTickKeyCheck(TickEvent.ClientTickEvent event)
    {
        KeyBinding[] keyBinds = ClientProxy.keyBindings;

        if (keyBinds[0].isPressed()) {

        }
        if (keyBinds[1].isPressed()) {

        }
        if (keyBinds[2].isPressed()) {

        }
    }


    public static KeyBinding[]  keyBindings;
}


