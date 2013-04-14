package mods.themike.modjam.packet;

import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import ljdp.easypacket.EasyPacket;
import ljdp.easypacket.EasyPacketData;

public class PacketParticle extends EasyPacket {
	
	@EasyPacketData
	public String name;
	
	@EasyPacketData
	public double x;
	
	@EasyPacketData
	public double y;

	@EasyPacketData
	public double z;

	@EasyPacketData
	public double velX;

	@EasyPacketData
	public double velY;

	@EasyPacketData
	public double velZ;

	public PacketParticle(String par1, double par2, double par3, double par4, double par5, double par6, double par7) {
		this.name = par1;
		this.x = par2;
		this.y = par3;
		this.z = par4;
		this.velX = par5;
		this.velY = par6;
		this.velZ = par7;
	}
	
	public PacketParticle() {
		super();
	}
	
	@Override
	public boolean isChunkDataPacket() {
		return false;
	}

	@Override
	public void onReceive(DataInputStream data, Player player) {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			EntityPlayer ent = (EntityPlayer) player;
			ent.worldObj.spawnParticle(name, x, y, z, velX, velY, velZ);
		}
	}

}
