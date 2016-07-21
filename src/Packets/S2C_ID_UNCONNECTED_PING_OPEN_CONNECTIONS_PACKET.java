package Packets;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import static Packets.Field.Type.RAK_STRING;

/**
 * Created by MöbelKlein on 21.07.2016.
 */
public class S2C_ID_UNCONNECTED_PING_OPEN_CONNECTIONS_PACKET extends Packet {
    public S2C_ID_UNCONNECTED_PING_OPEN_CONNECTIONS_PACKET(String Name, int ServerId,
                                                           String ServerVersion, int Players, int MaxPlayer){
        setHeader((byte) 0x1c);
        Field PingID = new Field();
        PingID.setFieldName("PingID");
        PingID.setType(Field.Type.RAK_INT64);
        PingID.setData((long)0x1);
        Field ServerID = new Field();
        ServerID.setFieldName("ServerID");
        ServerID.setType(Field.Type.RAK_INT64);
        ServerID.setData((long)0x1);
        Field Magic = new Field();
        Magic.setType(Field.Type.RAK_MAGIC);
        Magic.setData(Field.RAK_MAGIC);
        Magic.setFieldName("MAGIC");
        Field ServerName = new Field();
        ServerName.setType(RAK_STRING);
        String value = "";
        value += "MCPE;";
        value += Name;
        value += ";2 7;";
        value += ServerVersion + ";";
        value += Integer.toString(Players) + ";";
        value += Integer.toString(MaxPlayer) + ";";
        ServerName.setData(value);
        ServerName.setSize(value.length());
        setField(PingID);
        setField(ServerID);
        setField(Magic);
        setField(ServerName);
    }


}
