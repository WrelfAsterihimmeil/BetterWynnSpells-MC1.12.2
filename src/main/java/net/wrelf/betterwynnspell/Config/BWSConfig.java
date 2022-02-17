package net.wrelf.betterwynnspell.Config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wrelf.betterwynnspell.BetterWynnSpell;

@Config(modid = BetterWynnSpell.MOD_ID, type = Config.Type.INSTANCE)
public class BWSConfig {
    @Config.RangeInt(min = 1)
    @Config.LangKey("betterwynnspell.config.delay")
    @Config.Comment("betterwynnspell.config.delay.desc")
    public static int DelayBetweenClicks = 4;

    @Config.LangKey("betterwynnspell.config.mousedisabler")
    @Config.Comment("betterwynnspell.config.mousedisabler.desc")
    public static boolean EnableMouseDisabler = true;

    @Config.LangKey("betterwynnspell.config.chargemode")
    @Config.Comment("betterwynnspell.config.chargemode.desc")
    public static boolean EnableChargeMode = true;

    @Mod.EventBusSubscriber(modid = BetterWynnSpell.MOD_ID)
    public static class ConfigHandler{
        @SubscribeEvent
        public static void configChanged (ConfigChangedEvent event){
            if (event.getModID().equals(BetterWynnSpell.MOD_ID)) {
                ConfigManager.sync(BetterWynnSpell.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
