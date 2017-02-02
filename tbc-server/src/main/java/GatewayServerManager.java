import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class GatewayServerManager {

	private GatewayServer gatewayServer;
	private static final int port = 13000;
	private static final int workerThreadCount = 4;
	private static final int executorServiceThreadPoolSize = 32;
	private static final int idleStateTimeout = 60;

	@PostConstruct
	public void start() {
		gatewayServer = new GatewayServer(port, workerThreadCount, executorServiceThreadPoolSize,
				idleStateTimeout, new GatewayRequestProcessorFactory());
		try {
			gatewayServer.start();
		} catch (InterruptedException ignored) {

		}
	}

	@PreDestroy
	public void shutdown() {
		gatewayServer.shutdown();
	}


}
