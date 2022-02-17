package net.wrelf.betterwynnspell.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.wrelf.betterwynnspell.Events.EventManager;
import net.wrelf.betterwynnspell.inputs.MouseClickDisabler;
import net.wrelf.betterwynnspell.inputs.MouseRightClickDisabler;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{
    public static KeyBinding[] keyBindings;
    public static MouseClickDisabler attackKeyDisabler = new MouseClickDisabler(Minecraft.getMinecraft().gameSettings.keyBindAttack);
    public static MouseRightClickDisabler useKeyDisabler = new MouseRightClickDisabler(Minecraft.getMinecraft().gameSettings.keyBindUseItem);


    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        keyBindings = new KeyBinding[6];

        keyBindings[0] = new KeyBinding(I18n.format("betterwynnspell.key.cast1st"), Keyboard.KEY_Z, I18n.format("betterwynnspell.key.category"));
        keyBindings[1] = new KeyBinding(I18n.format("betterwynnspell.key.cast2nd"), Keyboard.KEY_X, I18n.format("betterwynnspell.key.category"));
        keyBindings[2] = new KeyBinding(I18n.format("betterwynnspell.key.cast3rd"), Keyboard.KEY_C, I18n.format("betterwynnspell.key.category"));
        keyBindings[3] = new KeyBinding(I18n.format("betterwynnspell.key.cast4th"), Keyboard.KEY_V, I18n.format("betterwynnspell.key.category"));
        keyBindings[4] = new KeyBinding(I18n.format("betterwynnspell.key.clearQueue"), Keyboard.KEY_R, I18n.format("betterwynnspell.key.category"));
        keyBindings[5] = new KeyBinding(I18n.format("betterwynnspell.key.toggleArcher"), Keyboard.KEY_NUMPAD0, I18n.format("betterwynnspell.key.category"));

        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

        Minecraft.getMinecraft().gameSettings.keyBindAttack = attackKeyDisabler;
        Minecraft.getMinecraft().gameSettings.keyBindUseItem = useKeyDisabler;

        EventManager.registerHandler();
    }

}