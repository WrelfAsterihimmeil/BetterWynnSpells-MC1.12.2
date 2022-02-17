package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.Ref;
import net.wrelf.betterwynnspell.SpellMacro.SpellQueue;
import net.wrelf.betterwynnspell.proxy.ClientProxy;

public class KeyInputHandler {
    public KeyInputHandler(){
        prevKeyStates = new boolean[7];
        keyStates = new boolean[7];
    }

    @SubscribeEvent()
    public void onTickKeyCheck(TickEvent.ClientTickEvent event) {
        KeyBinding[] keyBinds = ClientProxy.keyBindings;

        for(int i = 0; i < keyStates.length; i ++)
        {
            keyStates[i] = keyBinds[i].isKeyDown();
        }

        //Queue Spell
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

        //Detect Key Release
        if (!keyStates[0] && prevKeyStates[0]) {
            SpellQueue.ReleaseKey();
        }

        if (!keyStates[1] && prevKeyStates[1]) {
            SpellQueue.ReleaseKey();
        }

        if (!keyStates[2] && prevKeyStates[2]) {
            SpellQueue.ReleaseKey();
        }

        if (!keyStates[3] && prevKeyStates[3]) {
            SpellQueue.ReleaseKey();
        }

        //Other Keys
        if(keyStates[4] && !prevKeyStates[4]) {
            SpellQueue.clickQueue.clear();
            SpellQueue.ReleaseKey();
        }

        if(keyStates[6] && !prevKeyStates[6]) {
            Ref.isArcher = !Ref.isArcher;
        }

        //Saving key states
        for(int i = 0; i < keyStates.length; i ++)
        {
            prevKeyStates[i] = keyStates[i];
        }
    }

    public static boolean[] keyStates;
    public static boolean[] prevKeyStates;
}


