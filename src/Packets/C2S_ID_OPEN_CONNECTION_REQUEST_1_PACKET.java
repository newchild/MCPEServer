package Packets;

/**
 * Created by fabian on 21.07.16.
 */
public class C2S_ID_OPEN_CONNECTION_REQUEST_1_PACKET extends Packet {

    private int RakNetProtocol;
    private short PayloadLength;


    public C2S_ID_OPEN_CONNECTION_REQUEST_1_PACKET(byte[] data){
        PayloadLength = (short) ((new Integer(data.length)).shortValue() - 18);
        RakNetProtocol = data[17];

    }

    public int getRakNetProtocol() {
        return RakNetProtocol;
    }

    public short getPayloadLength() {
        return PayloadLength;
    }
}
