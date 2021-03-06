import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    private String imei = null;

	private RequestProcessorFactory requestProcessorFactory;

    public ServerHandler(RequestProcessorFactory requestProcessorFactory) {
		this.requestProcessorFactory = requestProcessorFactory;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		PacketData request = (PacketData)msg;
		String imeiResp = requestProcessorFactory.process(request);
		if (imei == null) {
			imei = imeiResp;
		}
		ctx.writeAndFlush("");
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
		requestProcessorFactory.inactiveDevice(imei);

	}
}