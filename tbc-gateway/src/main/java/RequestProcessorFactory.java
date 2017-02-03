public interface RequestProcessorFactory {
    byte[] process(PacketData packetData) throws Exception;

}