import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.ByteOrder;
import java.util.List;

public class PacketDataDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		in = in.order(ByteOrder.LITTLE_ENDIAN);
		if (in.readableBytes() < 2) {
			return;
		}

		in.markReaderIndex();
		PacketData packetData = new PacketData();
		in.readBytes(packetData.getPacketData());

		out.add(packetData);

//		byte stx = in.readByte();
//
//		if(in.readableBytes() >= 4) {
//			byte msgType = in.readByte();
//			byte format = in.readByte();
//            int dataLength = in.readInt();
//
//			if (in.readableBytes() >= dataLength + 3) {
//				byte[] data = new byte[dataLength];
//				in.readBytes(data);
//
//				PacketData packetData = new PacketData();
//
//                byte etx = in.readByte();
//
//				out.add(packetData);
//				return;
//			}
//		}
//		in.resetReaderIndex();
	}

}
