
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteOrder;

public class PacketDataEncoder extends MessageToByteEncoder {

	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
		if (msg instanceof PacketData) {
			PacketData message = (PacketData)msg;
			out = out.order(ByteOrder.LITTLE_ENDIAN);

		}
	}
}
