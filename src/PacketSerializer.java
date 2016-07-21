import Packets.Field;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MöbelKlein on 21.07.2016.
 */
public class PacketSerializer {

    public enum PacketTypes{
        UNK_UNK,
        C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS,
        UNK_UNK2,
        UNK_UNK3,
        UNK_UNK4,
        C2S_ID_OPEN_CONNECTION_REQUEST_1,
        S2C_ID_OPEN_CONNECTION_REPLY_1,
        C2S_ID_OPEN_CONNECTION_REQUEST_2,
        S2C_ID_OPEN_CONNECTION_REPLY_2
    }

    private Map<PacketTypes, String> mappedTypes = new HashMap<PacketTypes, String>();

    public PacketSerializer(){
        mappedTypes.put(PacketTypes.C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS, "C2S_ID_CONNECTED_PING_OPEN_CONNECTIONS");
        mappedTypes.put(PacketTypes.C2S_ID_OPEN_CONNECTION_REQUEST_1, "C2S_ID_OPEN_CONNECTION_REQUEST_1");
        mappedTypes.put(PacketTypes.S2C_ID_OPEN_CONNECTION_REPLY_1, "S2C_ID_OPEN_CONNECTION_REPLY_1");
    }

    public PacketTypes getType(byte Header){
        try{
            return PacketTypes.values()[Header];
        }catch (Exception e){
            return PacketTypes.UNK_UNK;
        }

    }

    public String matchType(byte Header){
        try{
            return mappedTypes.get(PacketTypes.values()[Header]);
        }catch (java.lang.ArrayIndexOutOfBoundsException except){
            return "UNKNOWN";
        }

    }
}
