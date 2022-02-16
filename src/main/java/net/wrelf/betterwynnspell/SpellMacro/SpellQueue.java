package net.wrelf.betterwynnspell.SpellMacro;

import net.wrelf.betterwynnspell.Ref;

import java.util.ArrayDeque;
import java.util.Queue;

public class SpellQueue {
    public static Queue<ClickType> clickQueue = new ArrayDeque<>();

    public static void QueueSpell(int spellType){
        switch(spellType) {
            case 1: {
                if (Ref.isArcher) {
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.LeftClick);
                } else {
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.RightClick);
                }
                break;
            }

            case 2: {
                if (Ref.isArcher) {
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.LeftClick);
                } else {
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.RightClick);
                }
                break;
            }

            case 3: {
                if (Ref.isArcher) {
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.RightClick);
                } else {
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.LeftClick);
                }
                break;
            }

            case 4: {
                if (Ref.isArcher) {
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.LeftClick);
                    clickQueue.add(ClickType.RightClick);
                } else {
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.RightClick);
                    clickQueue.add(ClickType.LeftClick);
                }
                break;
            }
        }
    }

}
