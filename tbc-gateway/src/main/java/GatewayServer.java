
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class GatewayServer {

    private int serverPort;

    private int workerThreadNumber;

    private int eventExecutorThreadNumber;

    private int idleStateTimeout;

    private RequestProcessorFactory gatewayRequestProcessorFactory;

    private ChannelFuture future;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private EventExecutorGroup eventExecutor;

    public GatewayServer(int serverPort,
                         int workerThreadNumber,
                         int eventExecutorThreadNumber,
                         int idleStateTimeout,
                         RequestProcessorFactory gatewayRequestProcessorFactory) {
        this.serverPort = serverPort;

        this.idleStateTimeout = idleStateTimeout;
        this.gatewayRequestProcessorFactory = gatewayRequestProcessorFactory;
        this.workerThreadNumber = workerThreadNumber;
        this.eventExecutorThreadNumber = eventExecutorThreadNumber;
    }
    public void start() throws InterruptedException {
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup(workerThreadNumber);

        eventExecutor = new DefaultEventExecutorGroup(eventExecutorThreadNumber);

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
						pipeline.addLast(new IdleStateHandler(idleStateTimeout, 0, 0));
						pipeline.addLast(new PacketDataDecoder());
                        pipeline.addLast(new PacketDataEncoder());
                        pipeline.addLast(eventExecutor, new ServerHandler(gatewayRequestProcessorFactory));
                    }
                })
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        try {
            future = serverBootstrap.bind(serverPort).sync();
        }catch (InterruptedException ignored){

        }

    }

    public void shutdown() {
        try {
            future.channel().close();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            eventExecutor.shutdownGracefully();
        }
    }
}
