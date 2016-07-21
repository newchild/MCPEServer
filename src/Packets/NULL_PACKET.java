package Packets;

/**
 * Created by fabian on 21.07.16.
 */
public class NULL_PACKET extends Packet{
    public NULL_PACKET(){
        setHeader((byte) 0xff);
        Field INVALID = new Field();
        INVALID.setType(Field.Type.RAK_INT64);
        INVALID.setData((long)312345643);
        setField(INVALID);
    }
}
