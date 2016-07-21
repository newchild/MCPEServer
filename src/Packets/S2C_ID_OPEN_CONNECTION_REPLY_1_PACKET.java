package Packets;

/**
 * Created by fabian on 21.07.16.
 */
public class S2C_ID_OPEN_CONNECTION_REPLY_1_PACKET extends Packet {

    public S2C_ID_OPEN_CONNECTION_REPLY_1_PACKET(short received){
        setHeader((byte) 0x6);
        Field MAGIC = new Field();
        MAGIC.setData(Field.RAK_MAGIC);
        MAGIC.setType(Field.Type.RAK_MAGIC);
        Field SID = new Field();
        SID.setData((long)4);
        SID.setType(Field.Type.RAK_INT64);
        Field Security = new Field();
        Security.setData((byte)0);
        Security.setType(Field.Type.RAK_BYTE);
        Field MTU = new Field();
        MTU.setData(received);
        MTU.setType(Field.Type.RAK_SHORT);

        setField(MAGIC);
        setField(SID);
        setField(Security);
        setField(MTU);
    }

}
