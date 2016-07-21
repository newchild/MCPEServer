/**
 * Created by MöbelKlein on 21.07.2016.
 */

import Packets.*;

import java.net.InetAddress;

public class PacketHandler implements OnReceivePacketEvent {
    @Override
    public void receivedPacket(PacketSerializer.PacketTypes type, String name, byte[] data, InetAddress address, int port) throws Exception{
        switch (type){
            case C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS:
                C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS received = new C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS(data);
                handler.SendPacket(new S2C_ID_UNCONNECTED_PING_OPEN_CONNECTIONS_PACKET("§K§L[§4Test§r§L]§r Test Java Server", 2345, "0.0.0", 5, -1),
                        address, port);
                break;
            case UNK_UNK:
                System.out.println("Received unknown Packet with ID: " + Byte.toString(data[0]));
                break;
            case C2S_ID_OPEN_CONNECTION_REQUEST_1:
                C2S_ID_OPEN_CONNECTION_REQUEST_1_PACKET OpenRequest = new C2S_ID_OPEN_CONNECTION_REQUEST_1_PACKET(data);
                S2C_ID_OPEN_CONNECTION_REPLY_1_PACKET response = new S2C_ID_OPEN_CONNECTION_REPLY_1_PACKET(OpenRequest.getPayloadLength());
                handler.SendPacket(response, address, port);
                break;

            case C2S_ID_OPEN_CONNECTION_REQUEST_2:
                handler.SendPacket(new NULL_PACKET(), address, port);
                break;
            default:
                System.out.println(type);
        }
    }
    public static NetworkHandler handler = new NetworkHandler();
    public PacketHandler() throws Exception{
        handler.addOnReceivedPacketListener(this);
        handler.Start();
    }
}
