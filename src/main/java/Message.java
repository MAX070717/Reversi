import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.lang.annotation.Native;


/**
 * Created by Максим on 18.02.2015.
 */
public class Message {

    private Square field[][];


    public Message(Square [][]field) {
        this.field=field;
    }

    public Square[][] getField() {
        return field;
    }

    public void setField(Square[][] field) {
        this.field = field;
    }

    public Message() {}


    public void jSend(OutputStream os) {
        ObjectMapper mp = new ObjectMapper();
        try {
            String s = mp.writeValueAsString(this);
            //System.out.println(s);
            new DataOutputStream(os).writeUTF(s);
            //new DataOutputStream(System.out).writeUTF(s);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Message jRecv(InputStream is) {
        ObjectMapper mp = new ObjectMapper();
        Message ms;
        try {
        //ms = mp.readValue(is,CommandMessage.class);
        String s = new DataInputStream(is).readUTF();

        ms = mp.readValue(s,Message.class);
           // System.out.println(ms);
        return ms;

        } catch (IOException e) {
        e.printStackTrace();
        }
        return null;
        }


}
