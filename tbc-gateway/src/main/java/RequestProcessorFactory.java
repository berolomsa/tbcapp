public interface RequestProcessorFactory {
    String process(PacketData packetData) throws Exception;

	void inactiveDevice(String imei);
}