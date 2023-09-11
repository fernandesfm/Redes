package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    public static void main(String[] args) throws IOException {
        new Servidor().executa();
    }

    private List<ObjectOutputStream> clientes;

    public Servidor() {
        this.clientes = new ArrayList<ObjectOutputStream>();
    }

    public void executa() throws IOException {
        GUI gui = new GUI();
        gui.createServerInterface();
        ServerSocket servidor = new ServerSocket(Integer.valueOf(gui.getServerPort()));
        gui.showServerPortInterface();
        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Nova conexao com o cliente "
                    + cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente a lista
            ObjectOutputStream ps = new ObjectOutputStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc
                    = new TrataCliente(new ObjectInputStream(cliente.getInputStream()), this);
            new Thread(tc).start();
        }

    }

    public synchronized void distribuiMensagem(Message pMsg) {
        // envia mensagem para todos os clientes
        for (ObjectOutputStream cliente : this.clientes) {
            try {
                System.out.println("Enviando mensagem pelo servidor");
                cliente.reset();
                cliente.writeObject(pMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
