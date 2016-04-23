package communication;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.*;
import java.net.*;
import utility.*;
import static utility.Constants.*;

public class ServerCommunication extends Thread {

    Socket socketCliente;
    static ServerSocket serverSocket = null;
    String message = "";                        // string para conter informações transferidas
    DataInputStream dutoEntrada;            // cria um duto de entrada
    PrintStream dutoSaida;                  // cria um duto de saída
    int portaServidor;
    String answer = "";

    public ServerCommunication(Socket socketCliente, ServerSocket server, int porta) {
        this.socketCliente = socketCliente;
        this.portaServidor = porta;
        this.serverSocket = server;
    }

    public void closingServer() {
        dutoSaida.close();
    }

    @Override
    public void run() {
        try {
            
            System.out.println("cheguei aqui please");
            dutoEntrada = new DataInputStream(socketCliente.getInputStream());    // aponta o duto de entrada para o socket do cliente
            dutoSaida = new PrintStream(socketCliente.getOutputStream());       // aponta o duto de saída para o socket do cliente

            //envia a mensagem de conexão ao cliente
//            ServerManager.iServer.jtMessage.setText(ServerManager.iServer.jtMessage.getText() + "\n"
//                    + "Nova conexao: " + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort());

//            dutoSaida.println("Conexão efetuada com o servidor 127.0.0.1 Porta " + portaServidor);
            while (true) {
                //aguarda recebimento de dados vindos do cliente
                message = dutoEntrada.readLine();                           // recebe dados do cliente
                System.out.println(message);
                if (message == null) {
                    ServerManager.iServer.getJtMessage().setText(ServerManager.iServer.getJtMessage().getText() + "\n"
                          + "Cliente: "  + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort() + " desconectou." );
                    socketCliente.close();
                    this.stop();
                }else{
                    System.out.println("here");
                   String[] splitMessage = message.split(";");
                   if("01".equals(splitMessage[0])){
                       System.out.println( FileManager.checkInFile(LOGIN, message));
                   }
                }
                //envia a mensagem em caixa alta
//                answer = "ServerCommunication responde:  " + mensagem.toUpperCase();
//                ServerManager.iServer.jtMessage.setText(ServerManager.iServer.jtMessage.getText() + "\n" + socketCliente.getInetAddress().toString()
//                        + ":" + socketCliente.getPort() + " says " + mensagem);
//                dutoSaida.println(answer);     // envia dados para o cliente
            }
        } catch (Exception e) {
            System.out.println(e + "Exception no");
        }
    }

} // classe
