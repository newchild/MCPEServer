import java.net.InetAddress;

/**
 * Created by MöbelKlein on 21.07.2016.
 */


public interface OnReceivePacketEvent {
    void receivedPacket(PacketSerializer.PacketTypes type, String name, byte[] data, InetAddress address, int port) throws Exception;
}
