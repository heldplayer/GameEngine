package me.heldplayer.mods.gameengine.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import me.heldplayer.mods.gameengine.ModOverviewer;
import me.heldplayer.mods.gameengine.Objects;
import net.minecraft.client.gui.GuiScreen;

public class GuiConfiguration extends GuiConfig {

    public GuiConfiguration(GuiScreen parent) {
        super(parent, ModOverviewer.instance.config.getConfigElements(), Objects.MOD_ID, false, false, "Overviewer Mode Configuration");
    }

}
