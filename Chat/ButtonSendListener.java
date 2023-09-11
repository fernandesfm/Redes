package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.net.Socket;

import javax.swing.JTextField;

public class ButtonSendListener implements ActionListener {

    ObjectOutputStream _client;
    JTextField _textMessage;
    String _clientName;

    public ButtonSendListener(ObjectOutputStream pClient, JTextField pTextMessage, JTextField pClientName) {
        _client = pClient;
        _textMessage = pTextMessage;
        _clientName = pClientName.getText();
    }

    @Override
    public synchronized void actionPerformed(ActionEvent arg0) {
        ObjectOutputStream saida;
        try {
            Message msg = new Message((_textMessage.getText()));
            _client.reset();
            System.out.println("Imprimindo mensagem pelo cliente");
            _client.writeObject(msg);

            _textMessage.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
