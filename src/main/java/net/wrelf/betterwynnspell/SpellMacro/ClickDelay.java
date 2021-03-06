package net.wrelf.betterwynnspell.SpellMacro;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.BetterWynnSpell;
import net.wrelf.betterwynnspell.Config.BWSConfig;
import net.wrelf.betterwynnspell.Ref;

public class ClickDelay {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (event.phase == TickEvent.Phase.START) {
            delayTick++;
            clickOnThisTick = ClickType.NoClick;
            if (delayTick >= BWSConfig.DelayBetweenClicks) {
                Object ctp = SpellQueue.clickQueue.poll();
                if (ctp == null) {
                    delayTick--;
                    return;
                }

                if (BWSConfig.EnableChargeMode && SpellQueue.clickQueue.peek() == null && SpellQueue.IsHolding()) {
                    delayTick--;
                    SpellQueue.clickQueue.add((ClickType) ctp);
                    return;
                }

                clickOnThisTick = (ClickType) ctp;
                if (ctp == ClickType.LeftClick) {
                    ClickPerformer.PerformAttack();
                } else {
                    ClickPerformer.PerformUse();
                }

                delayTick = 0;
            }
        }
    }

    private int delayTick = 0;

    public static ClickType clickOnThisTick = ClickType.NoClick;
}
