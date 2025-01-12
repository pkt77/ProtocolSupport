package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.codec.PositionCodec;
import protocolsupport.protocol.codec.StringCodec;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleUpdateSign;

public class UpdateSign extends MiddleUpdateSign {

	public UpdateSign(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		PositionCodec.readPositionISI(clientdata, position);
		for (int i = 0; i < lines.length; i++) {
			lines[i] = StringCodec.readVarIntUTF8String(clientdata, 15);
		}
	}

}
