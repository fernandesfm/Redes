package chat;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JTextArea;

public class Recebedor implements Runnable {

    private ObjectInputStream servidor;
    private JTextArea _textArea;
    
    public Recebedor(ObjectInputStream servidor, JTextArea pJTextArea) {
        this.servidor = servidor;
        _textArea = pJTextArea;
    }

    public synchronized void run() {
        // recebe mensagens do servidor e imprime na tela
        Message pmsg;
        try {
            while (true) {
                pmsg = (Message) servidor.readObject();
                if (pmsg != null) {
                    System.out.println("Recebendo mensagem do servidor");
                    String line = pmsg.msg;
                    _textArea.append(line);
                    _textArea.append("\n");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            try {
                servidor.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }
}
