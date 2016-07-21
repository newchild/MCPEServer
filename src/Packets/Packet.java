/**
 * Created by MöbelKlein on 21.07.2016.
 */
package Packets;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Packet {
    private byte Header;
    private List<Field> fields = new ArrayList<Field>();
    private int Size;
    private int length = 0;

    public byte getHeader() {
        return Header;
    }

    public void setHeader(byte header) {
        Header = header;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setField(Field field) {
        length+= field.getSize();
        this.fields.add(field);
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public byte[] getBytes() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.write(getHeader());
        for(Field field : getFields()){
            switch (field.getType()){
                case RAK_BYTE:
                    dos.write((byte)field.getData());
                    break;
                case RAK_INT32:
                    dos.write((int)field.getData());
                    break;
                case RAK_INT64:
                    dos.writeLong((long) field.getData());
                    break;
                case RAK_SHORT:
                    dos.write((short)field.getData());
                    break;
                case RAK_MAGIC:
                    for(int intVal : (int[])field.getData()){
                        dos.write(intVal);
                    }
                    break;
                case RAK_STRING:
                    dos.writeUTF((String)field.getData());

            }
        }
        dos.close();
        return baos.toByteArray();
    }

    public int getLength() {
        return length;
    }
}
