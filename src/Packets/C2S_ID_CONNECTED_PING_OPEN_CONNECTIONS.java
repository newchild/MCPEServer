package Packets;

import java.io.*;
import java.util.List;

/**
 * Created by MöbelKlein on 21.07.2016.
 */
public class C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS extends Packet {
    public C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS(byte[] data) throws IOException {
        setHeader(data[0]);
        Field PingTime = new Field();
        PingTime.setFieldName("PingTime");
        long value = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.write(data, 1, 9);
        dos.close();
        byte[] TimeStamp = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(TimeStamp);
        DataInputStream dos2 = new DataInputStream(bais);
        PingTime.setData(dos2.readLong());
        PingTime.setType(Field.Type.RAK_INT64);
        PingTime.setSize(8);
        setField(PingTime);
        baos.close();
        bais.close();
        dos2.close();
    }

    public long getTimeStamp(){
        return (long)getFields().get(0).getData();
    }
}
