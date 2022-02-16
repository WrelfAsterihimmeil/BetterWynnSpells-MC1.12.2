package net.wrelf.betterwynnspell.SpellMacro;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wrelf.betterwynnspell.Ref;

import java.util.ArrayDeque;
import java.util.Queue;

public class ClickDelay {

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        delayTick ++;
        if(delayTick > Ref.tickBetweenClicks){
            Object ctp = SpellQueue.clickQueue.poll();
            if(ctp == null) {
                delayTick--;
                return;
            }

            if(ctp == ClickType.LeftClick)
                ClickPerformer.PerformAttack();
            else
                ClickPerformer.PerformUse();

            delayTick = 0;
        }
    }

    private int delayTick = 0;
}
