package Packets;

/**
 * Created by MöbelKlein on 21.07.2016.
 */
public class Field {
    private String FieldName;
    private int size;
    private Object data;
    private Type type;

    public static int[] RAK_MAGIC = {0x00, 0xff,0xff,0x00, 0xfe, 0xfe, 0xfe, 0xfe, 0xfd,0xfd, 0xfd, 0xfd, 0x12, 0x34, 0x56,0x78};

    public byte[] getBytes(){
        return new byte[1];
    }

    public enum Type{
        RAK_BYTE,
        RAK_SHORT,
        RAK_INT32,
        RAK_INT64,
        RAK_MAGIC,
        RAK_STRING
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getSize() {
        switch (type){
            case RAK_MAGIC:
                return 16;
            case RAK_STRING:
                return size;
            case RAK_SHORT:
                return 2;
            case RAK_INT64:
                return 8;
            case RAK_INT32:
                return 4;
            case RAK_BYTE:
                return 1;
        }
        return 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getFieldName() {
        return FieldName;
    }
}
