package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2;

import protocolsupport.protocol.codec.VarNumberCodec;
import protocolsupport.protocol.packet.ClientBoundPacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityHeadRotation;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;

public class EntityHeadRotation extends MiddleEntityHeadRotation {

	public EntityHeadRotation(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData entityheadrotation = ClientBoundPacketData.create(ClientBoundPacketType.PLAY_ENTITY_HEAD_ROTATION);
		VarNumberCodec.writeVarInt(entityheadrotation, entity.getId());
		entityheadrotation.writeByte(headRot);
		codec.writeClientbound(entityheadrotation);
	}

}
