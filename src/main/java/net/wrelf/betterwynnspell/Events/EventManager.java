package net.wrelf.betterwynnspell.Events;

import net.minecraftforge.common.MinecraftForge;
import net.wrelf.betterwynnspell.BetterWynnSpell;
import net.wrelf.betterwynnspell.Config.BWSConfig;
import net.wrelf.betterwynnspell.SpellMacro.ClickDelay;
import net.wrelf.betterwynnspell.inputs.KeyInputHandler;

public class EventManager {
    public static void registerHandler() {
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        MinecraftForge.EVENT_BUS.register(new ClickDelay());
        MinecraftForge.EVENT_BUS.register(new BWSConfig.ConfigHandler());
    }
}
