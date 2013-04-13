package mods.themike.packet;

import ljdp.easypacket.EasyPacketDispatcher;
import ljdp.easypacket.EasyPacketHandler;
import mods.themike.modjam.ModJam;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
	
	public static EasyPacketDispatcher dispatcher;
	public static EasyPacketHandler particle;
	public static EasyPacketHandler sound;

	public PacketHandler() {
		dispatcher = new EasyPacketDispatcher("SpatialRunes");
		particle = EasyPacketHandler.registerEasyPacket(PacketParticle.class, dispatcher);
		sound = EasyPacketHandler.registerEasyPacket(PacketSound.class, dispatcher);
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if(packet.data != null) {
			dispatcher.onPacketData(manager, packet, player);
		}
	}

}
