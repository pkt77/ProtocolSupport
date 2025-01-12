package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2;

import protocolsupport.protocol.packet.ClientBoundPacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.AbstractChunkCacheMiddleExplosion;
import protocolsupport.protocol.typeremapper.basic.SoundRemapper;
import protocolsupport.protocol.types.Position;
import protocolsupport.protocol.types.SoundCategory;

public class Explosion extends AbstractChunkCacheMiddleExplosion {

	public Explosion(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		codec.writeClientbound(WorldCustomSound.create(
			version,
			(int) (x * 8), (int) (y * 8), (int) (z * 8),
			"entity.generic.explode", SoundCategory.BLOCKS,
			4.0F, SoundRemapper.createEntityGenericExplodePitch()
		));

		ClientBoundPacketData explosion = ClientBoundPacketData.create(ClientBoundPacketType.PLAY_EXPLOSION);
		explosion.writeFloat(x);
		explosion.writeFloat(y);
		explosion.writeFloat(z);
		explosion.writeFloat(radius);
		explosion.writeInt(blocks.length);
		for (Position block : blocks) {
			explosion.writeByte(block.getX());
			explosion.writeByte(block.getY());
			explosion.writeByte(block.getZ());
		}
		explosion.writeFloat(pMotX);
		explosion.writeFloat(pMotY);
		explosion.writeFloat(pMotZ);
		codec.writeClientbound(explosion);
	}

}
