package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args)
            throws UnknownHostException, IOException {
        new Cliente().executa();
    }

    public synchronized void executa() throws UnknownHostException, IOException {

        GUI gui = new GUI();
        gui.createClientInterface();
        Socket cliente = new Socket(gui.getIp(), Integer.valueOf(gui.getClientPort()));
        ObjectOutputStream obj = new ObjectOutputStream(cliente.getOutputStream());
        gui.createChatScreen(obj, cliente);
        Recebedor r = new Recebedor(new ObjectInputStream(cliente.getInputStream()), gui.getTextArea());
        new Thread(r).start();
    }
}
