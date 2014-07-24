package me.heldplayer.mods.gameengine.packet;

import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.specialattack.forge.core.client.MC;
import net.specialattack.forge.core.packet.SpACorePacket;

import java.io.IOException;

public class Packet1Mode extends SpACorePacket {

    public int entityId;
    public Mode mode;

    public Packet1Mode() {
        super(null);

        this.mode = Mode.NOTHING;
    }

    public Packet1Mode(Mode mode, int entityId) {
        super(null);

        this.mode = mode;
        this.entityId = entityId;
    }

    public Packet1Mode(EntityLiving entity) {
        super(entity == null ? null : entity.worldObj);

        this.mode = Mode.SPECTATE_ENTITY;
        this.entityId = entity == null ? -1 : entity.getEntityId();
    }

    @Override
    public Side getSendingSide() {
        return Side.SERVER;
    }

    @Override
    public void read(ChannelHandlerContext context, ByteBuf in) throws IOException {
        this.entityId = in.readInt();
    }

    @Override
    public void write(ChannelHandlerContext context, ByteBuf out) throws IOException {
        out.writeInt(this.entityId);
    }

    @Override
    public void onData(ChannelHandlerContext context, EntityPlayer player) {
        switch (this.mode) {
            case RESET:
                MC.getMinecraft().renderViewEntity = MC.getPlayer();
                break;
            case SPECTATE_ENTITY:
                World world = player.worldObj;

                Entity entity = world.getEntityByID(this.entityId);

                if (entity != null && entity instanceof EntityLivingBase) {
                    MC.getMinecraft().renderViewEntity = (EntityLiving) entity;
                }
                break;
            case OVERVIEW_MODE:
                // TODO: create overview entity and switch view, enable overview mode
                break;
        }
    }

    public static enum Mode {
        NOTHING, RESET, SPECTATE_ENTITY, OVERVIEW_MODE;
    }

}
