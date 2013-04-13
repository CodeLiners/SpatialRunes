package mods.themike.packet;

import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import ljdp.easypacket.EasyPacket;
import ljdp.easypacket.EasyPacketData;

public class PacketSound extends EasyPacket {
	
	@EasyPacketData
	public String name;
	
	@EasyPacketData
	public float volume;
	
	@EasyPacketData
	public float pitch;
	
	public PacketSound(String par1, float par2, float par3) {
		name = par1;
		volume = par2;
		pitch = par3;
	}
	
	public PacketSound() {
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
			ent.playSound(name, volume, pitch);
		}
	}

}
