package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.wrelf.betterwynnspell.BetterWynnSpell;
import net.wrelf.betterwynnspell.Config.BWSConfig;
import net.wrelf.betterwynnspell.SpellMacro.ClickDelay;
import net.wrelf.betterwynnspell.SpellMacro.ClickType;
import net.wrelf.betterwynnspell.SpellMacro.SpellQueue;

@SideOnly(Side.CLIENT)
public class MouseRightClickDisabler extends KeyBinding {
    public MouseRightClickDisabler(KeyBinding defKB){
        super(defKB.getKeyDescription(), defKB.getKeyCode(), defKB.getKeyCategory());

    }

    @Override
    public boolean isPressed() {
        if(!BWSConfig.EnableMouseDisabler || ClickDelay.clickOnThisTick == ClickType.RightClick) {
            return super.isPressed();
        }

        if(SpellQueue.clickQueue.peek()!= null) {
            super.isPressed();
            return false;
        }
        return super.isPressed();
    }

    @Override
    public boolean isKeyDown() {
        if(BWSConfig.EnableMouseDisabler && SpellQueue.clickQueue.peek()!= null){
            super.isKeyDown();
            return false;
        }
        return super.isKeyDown();
    }

}
