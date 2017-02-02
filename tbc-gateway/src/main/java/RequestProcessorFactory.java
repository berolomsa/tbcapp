import java.util.List;

public interface RequestProcessorFactory {
    byte[] process(PacketData packetData) throws Exception;

    void inactiveTerminal(long terminalId);
}