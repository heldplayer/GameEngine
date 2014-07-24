package me.heldplayer.mods.gameengine;

import net.specialattack.forge.core.ModInfo;
import org.apache.logging.log4j.Logger;

/**
 * ImRecording mod Objects
 */
public final class Objects {

    public static final String MOD_ID = "gameengine";
    public static final String MOD_NAME = "GameEngine";
    public static final ModInfo MOD_INFO = new ModInfo(Objects.MOD_ID, Objects.MOD_NAME);
    public static final String MOD_CHANNEL = "GameEngine";
    public static final String CLIENT_PROXY = "me.heldplayer.mods.gameengine.client.ClientProxy";
    public static final String SERVER_PROXY = "me.heldplayer.mods.gameengine.CommonProxy";
    public static final String GUI_FACTORY = "me.heldplayer.mods.gameengine.client.gui.GuiFactory";
    public static Logger log;

}
