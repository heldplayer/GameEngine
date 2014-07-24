package me.heldplayer.mods.gameengine;

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.heldplayer.mods.gameengine.packet.Packet1Mode;
import net.specialattack.forge.core.ModInfo;
import net.specialattack.forge.core.SpACoreMod;
import net.specialattack.forge.core.SpACoreProxy;
import net.specialattack.forge.core.config.Config;
import net.specialattack.forge.core.packet.PacketHandler;

@Mod(modid = Objects.MOD_ID, name = Objects.MOD_NAME, guiFactory = Objects.GUI_FACTORY)
public class ModOverviewer extends SpACoreMod {

    @Instance(value = Objects.MOD_ID)
    public static ModOverviewer instance;

    @SidedProxy(clientSide = Objects.CLIENT_PROXY, serverSide = Objects.SERVER_PROXY)
    public static CommonProxy proxy;

    // HeldCore Objects
    // public static ConfigValue<Boolean> chatMessages;
    // public static ConfigValue<Boolean> lockOverlay;
    // public static ConfigValue<Boolean> instantHide;

    public static PacketHandler packetHandler;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Objects.log = event.getModLog();

        ModOverviewer.packetHandler = new PacketHandler(Objects.MOD_CHANNEL, Packet1Mode.class);

        // Config
        // ConfigCategory<?> category = new ConfigCategory(Configuration.CATEGORY_GENERAL, "config.imrecording.category.general", null, "General mod settings");
        // ModOverviewer.chatMessages = new ConfigValue<Boolean>("chatMessages", "config.imrecording.key.chatMessages", null, Boolean.TRUE, "Set this to true to broadcast a chat message to every player when a player starts recording");
        // ModOverviewer.lockOverlay = new ConfigValue<Boolean>("lockOverlay", "config.imrecording.key.lockOverlay", Side.CLIENT, Boolean.TRUE, "Set this to true to disable being able to change recording state when the overlay is hidden");
        // ModOverviewer.instantHide = new ConfigValue<Boolean>("instantHide", "config.imrecording.key.instantHide", Side.CLIENT, Boolean.FALSE, "Set this to true to instantly hide the overlay instead of fading out slowly when toggling the GUI");
        this.config = new Config(event.getSuggestedConfigurationFile());
        // this.config.addCategory(category);
        // category.addValue(ModOverviewer.chatMessages);
        // category.addValue(ModOverviewer.lockOverlay);
        // category.addValue(ModOverviewer.instantHide);

        super.preInit(event);
    }

    @Override
    public ModInfo getModInfo() {
        return Objects.MOD_INFO;
    }

    @Override
    public SpACoreProxy getProxy() {
        return ModOverviewer.proxy;
    }

    @Override
    public boolean configChanged(OnConfigChangedEvent event) {
        return true;
    }

}
