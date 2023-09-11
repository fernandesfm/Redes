package chat;

import java.io.Serializable;

public class Message implements Serializable {

    String msg;

    public Message(String pMsg) {
        msg = pMsg;
    }
}
