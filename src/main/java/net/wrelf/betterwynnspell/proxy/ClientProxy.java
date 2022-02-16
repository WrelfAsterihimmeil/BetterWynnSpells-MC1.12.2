package net.wrelf.betterwynnspell.proxy;

import net.minecraft.client.Minecraft;
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
        keyBindings = new KeyBinding[7];

        keyBindings[0] = new KeyBinding("key.betterwynnspell.cast1st", Keyboard.KEY_Z, "key.betterwynnspell.category");
        keyBindings[1] = new KeyBinding("key.betterwynnspell.cast2nd", Keyboard.KEY_X, "key.betterwynnspell.category");
        keyBindings[2] = new KeyBinding("key.betterwynnspell.cast3rd", Keyboard.KEY_C, "key.betterwynnspell.category");
        keyBindings[3] = new KeyBinding("key.betterwynnspell.cast4th", Keyboard.KEY_V, "key.betterwynnspell.category");
        keyBindings[4] = new KeyBinding("key.betterwynnspell.clearQueue", Keyboard.KEY_R, "key.betterwynnspell.category");
        keyBindings[5] = new KeyBinding("key.betterwynnspell.openConfig", Keyboard.KEY_SEMICOLON, "key.betterwynnspell.category");
        keyBindings[6] = new KeyBinding("key.betterwynnspell.toggleArcher", Keyboard.KEY_NUMPAD0, "key.betterwynnspell.category");

        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

        Minecraft.getMinecraft().gameSettings.keyBindAttack = attackKeyDisabler;
        Minecraft.getMinecraft().gameSettings.keyBindUseItem = useKeyDisabler;

        EventManager.registerHandler();
    }

}