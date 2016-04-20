package chatserver;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.
import java.io.*;
import java.net.*;
import java.util.Map;

public class Servidor extends Thread {

    CreateServer servidor;
    Socket socketCliente;
    static ServerSocket serverSocket = null;
    String mensagem = "";                        // string para conter informações transferidas
    DataInputStream dutoEntrada;            // cria um duto de entrada
    PrintStream dutoSaida;                  // cria um duto de saída
    int portaServidor;
    String answer = "";
    private Cliente cliente = null;

    public Servidor(CreateServer servidor, Socket socketCliente, ServerSocket server, int porta) {
        this.socketCliente = socketCliente;
        this.portaServidor = porta;
        this.serverSocket = server;
        this.servidor = servidor;
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
                    + "O cliente:" + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort() + " se conectou ao servidor");

            // dutoSaida.println("Conexão efetuada com o servidor 127.0.0.1 Porta " + portaServidor);
            while (true) {
                //aguarda recebimento de dados vindos do cliente
                mensagem = dutoEntrada.readLine();                           // recebe dados do cliente
                CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\nMessagem recebida: " + mensagem);

                if (mensagem == null) {
                    CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\n"
                            + "Cliente: " + socketCliente.getInetAddress().toString() + ":" + socketCliente.getPort() + " desconectou.");
                    servidor.removeConnection(cliente);
                    servidor.updateClientsList();
                    socketCliente.close();
                    this.stop();
                } else {
                    String[] msg = mensagem.split("#");
                    
                    if ("1".equals(msg[0])) {

                        cliente = new Cliente(msg[1], socketCliente.getInetAddress().toString().replace("/", ""), socketCliente.getPort());
                        servidor.updateClientsList();
                        
                        //dutoSaida.println(sendList);

                    } else if ("3".equals(msg[0])) {
                        if("999.999.999.999".equals(msg[1]) && "99999".equals(msg[2])){
                            servidor.broadcastMessage(cliente.getNome(), cliente.getIpAddress(), cliente.getPort(), msg[3]);
                        }else{
                            servidor.fowardMessage(msg[1], msg[2], cliente.getIpAddress(), cliente.getPort(), cliente.getNome(), msg[3]);
                        }
                    } else if("5".equals(msg[0])){
                            servidor.removeConnection(cliente);
                            servidor.updateClientsList();
                            this.stop();
                    }

                }
                //envia a mensagem em caixa alta
                //answer = "Servidor responde:  " + mensagem.toUpperCase();
                // CreateServer.iServer.jtMessage.setText(CreateServer.iServer.jtMessage.getText() + "\n" + socketCliente.getInetAddress().toString()
                //        + ":" + socketCliente.getPort() + " says " + mensagem);
                //dutoSaida.println(answer);     // envia dados para o cliente
            }
        } catch (Exception e) {
            System.out.println(e + "Exception no");
        }
    }

    public void sendMessage(String message){
        dutoSaida.println(message);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

} // classe
