package controle;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.*;
import java.net.*;

public class Servidor extends Thread {

    Socket socketCliente;
    static ServerSocket serverSocket = null;
    String mensagem = "";                        // string para conter informações transferidas
    DataInputStream dutoEntrada;            // cria um duto de entrada
    PrintStream dutoSaida;                  // cria um duto de saída
    int portaServidor;
    String answer = "";

    public Servidor(Socket socketCliente, ServerSocket server, int porta) {
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
            dutoEntrada = new DataInputStream(socketCliente.getInputStream());    // aponta o duto de entrada para o socket do cliente
            dutoSaida = new PrintStream(socketCliente.getOutputStream());       // aponta o duto de saída para o socket do cliente

            //envia a mensagem de conexão ao cliente
            CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\n"
                    + "Nova conexao: " + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort());

            dutoSaida.println("Conexão efetuada com o servidor 127.0.0.1 Porta " + portaServidor);
            while (true) {
                //aguarda recebimento de dados vindos do cliente
                mensagem = dutoEntrada.readLine();                           // recebe dados do cliente

                if (mensagem == null) {
                    CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\n"
                          + "Cliente: "  + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort() + " desconectou." );
                    socketCliente.close();
                    this.stop();
                }
                //envia a mensagem em caixa alta
                answer = "Servidor responde:  " + mensagem.toUpperCase();
                CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\n" + socketCliente.getInetAddress().toString()
                        + ":" + socketCliente.getPort() + " says " + mensagem);
                dutoSaida.println(answer);     // envia dados para o cliente
            }
        } catch (Exception e) {
            System.out.println(e + "Exception no");
        }
    }

} // classe
