package net.wrelf.betterwynnspell.Config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wrelf.betterwynnspell.BetterWynnSpell;

@Config(modid = BetterWynnSpell.MOD_ID, type = Config.Type.INSTANCE)
public class BWSConfig {
    @Config.RangeInt(min = 2, max = 20)
    @Config.LangKey("betterwynnspell.config.delay")
    @Config.Comment("How many ticks it takes per click. i.e. 2 for 10 cps, 4 for 5 cps.")
    public static int DelayBetweenClicks = 3;

    @Config.LangKey("betterwynnspell.config.mousedisabler")
    @Config.Comment("If true, your clicks will be ignored while this mod is casting a spell(s)")
    public static boolean EnableMouseDisabler = true;

    @Config.LangKey("betterwynnspell.config.chargemode")
    @Config.Comment("If true, third click for the spell will not be triggered until you release cast spell key.")
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
