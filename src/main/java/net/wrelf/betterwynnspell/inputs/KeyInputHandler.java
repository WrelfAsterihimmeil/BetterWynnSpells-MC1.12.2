package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.SpellMacro.ClickPerformer;
import net.wrelf.betterwynnspell.SpellMacro.SpellQueue;
import net.wrelf.betterwynnspell.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;

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
            keyStates[i] = keyBinds[i].isKeyDown();
        }

        try {
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString("State[0] = " + (keyStates[0] ? "True" : "False") + "PrevState[0] = " + (prevKeyStates[0] ? "True" : "False")));
        }
        catch (NullPointerException e)
        {

        }

        if (keyStates[0] && !prevKeyStates[0]) {
            SpellQueue.QueueSpell(1);
        }

        if (keyStates[1] && !prevKeyStates[1]) {
            SpellQueue.QueueSpell(2);
        }

        if (keyStates[2] && !prevKeyStates[2]) {
            SpellQueue.QueueSpell(3);
        }

        if (keyStates[3] && !prevKeyStates[3]) {
            SpellQueue.QueueSpell(4);
        }

        for(int i = 0; i < keyStates.length; i ++)
        {
            prevKeyStates[i] = keyStates[i];
        }
    }
    public static boolean[] keyStates;
    public static boolean[] prevKeyStates;
}


