package net.wrelf.betterwynnspell.inputs;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.wrelf.betterwynnspell.SpellMacro.ClickDelay;
import net.wrelf.betterwynnspell.SpellMacro.ClickType;
import net.wrelf.betterwynnspell.SpellMacro.SpellQueue;

@SideOnly(Side.CLIENT)
public class MouseClickDisabler extends KeyBinding {
    public MouseClickDisabler(KeyBinding defKB){
        super(defKB.getKeyDescription(), defKB.getKeyCode(), defKB.getKeyCategory());

    }

    @Override
    public boolean isPressed() {
        if(ClickDelay.clickOnThisTick == ClickType.LeftClick) {
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
        if(SpellQueue.clickQueue.peek()!= null){
            super.isKeyDown();
            return false;
        }
        return super.isKeyDown();
    }

}
