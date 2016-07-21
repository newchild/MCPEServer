import Packets.Packet;
import jdk.internal.util.xml.impl.Pair;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MöbelKlein on 21.07.2016.
 */



public class NetworkHandler{
    private PacketSerializer serializer = new PacketSerializer();
    private List<OnReceivePacketEvent> subscribedEvents = new ArrayList<OnReceivePacketEvent>();
    private DatagramSocket serverSocket;
    private byte[] receiveData = new byte[1024];
    public void addOnReceivedPacketListener(OnReceivePacketEvent listener){
        subscribedEvents.add(listener);
    }

    public void SendPacket(Packet packet, InetAddress to, int port) throws Exception{
        byte[] data = packet.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, to, port);
        serverSocket.send(sendPacket);
    }

    public void Start() throws Exception {
        serverSocket  = new DatagramSocket(19132);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        while(true){
            serverSocket.receive(receivePacket);
            byte[] data = receivePacket.getData();
            for(OnReceivePacketEvent listener : subscribedEvents){
                listener.receivedPacket(serializer.getType(data[0]), serializer.matchType(data[0]),
                        data , receivePacket.getAddress(), receivePacket.getPort());
            }
        }
    }
}
