package controle;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viniciuscustodio
 */
public class CreateServer extends Thread {

    int porta;
    static InterfaceServidor iServer;
    static ServerSocket serverSocket = null;
    ArrayList<Thread> athreads = new ArrayList();

    public CreateServer(InterfaceServidor iServer, int portaServidor) {
        this.porta = portaServidor;
        this.iServer = iServer;
    }
    
    public void stopAll(){
        Iterator i = athreads.iterator();
        while(i.hasNext()){
            Servidor thread = (Servidor) i.next();
            thread.closingServer();
            thread.stop();
        }
    }
    
    public void run() {
        iServer.jtMessage.setText(iServer.jtMessage.getText() + "\n" + "Servidor carregado no IP 127.0.0.1 e na porta " + porta);

        //ServerSocket servidorEco = null;        // cria o socket do servidor
        Socket socketCliente = null;            // cria o socket do cliente

        try {

            serverSocket = new ServerSocket(porta);  // instancia o socket do servidor na porta 9999

        } catch (IOException e) {

            System.out.println(e);
        }

        try {
            while (true) {
                socketCliente = serverSocket.accept();                         // aguarda conexão do cliente
                Servidor t = new Servidor( socketCliente, serverSocket, porta);
                athreads.add(t);
                t.start();

            }
        } catch (IOException e) {
        }
    }
}
