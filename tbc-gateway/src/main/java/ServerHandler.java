import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    private long terminalId;

	private RequestProcessorFactory requestProcessorFactory;

    public ServerHandler(RequestProcessorFactory requestProcessorFactory) {
		this.requestProcessorFactory = requestProcessorFactory;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		PacketData request = (PacketData)msg;
		requestProcessorFactory.process(request);
//		PacketData response = makeResponsePacket(request, requestProcessorFactory.process(request.getMessageType(), request.getFormat(), request.getData(), terminalId));
//		ctx.writeAndFlush(response);
	}

	private PacketData makeResponsePacket(PacketData request, byte [] responseData) {
		PacketData responsePacket  = new PacketData();

		return responsePacket;
	}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
                ctx.close();
            }
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }
}