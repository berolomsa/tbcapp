import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class PacketDataDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
 		in = in.order(ByteOrder.LITTLE_ENDIAN);
		if (in.readableBytes() < 2) {
			return;
		}
		InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
		InetAddress inetaddress = socketAddress.getAddress();
		String clientIp = inetaddress.getHostAddress(); // IP a

		in.markReaderIndex();
		if (in.readableBytes() >= 33) {
			PacketData packetData = new PacketData();
			packetData.setClientIP(clientIp);
			byte[] bytes = new byte[in.readableBytes()];
			in.readBytes(bytes);
			System.arraycopy(bytes, 0, packetData.getPacketData(), 0, packetData.getPacketData().length);
			out.add(packetData);
			return;
		}
		in.resetReaderIndex();
	}

}
