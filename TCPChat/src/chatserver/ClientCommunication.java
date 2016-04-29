package chatserver;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class ClientCommunication extends Thread {

    static DataInputStream in;                  // cria um duto de entrada
    static PrintStream out;                     // cria um duto de saída
    static String message;
    Socket ClientSocket = null;
    int serverPort;
    String ipServer;
    InterfaceClient iCliente;
    String username;
    Map<String, Client> listaClientes;
    Map<String, Client> searchByName;

    public ClientCommunication(InterfaceClient iCliente, String username, int port, String ipServer) {
        this.serverPort = port;
        this.ipServer = ipServer;
        this.iCliente = iCliente;
        this.username = username;
    }

    public void run() {
        while (true) {
            try {
                message = in.readLine();
                System.out.println(message);
                if (message == null) {
                    iCliente.getJtAnswer().setText(iCliente.getJtAnswer().getText() + "\n" + "Conexao Encerrada");
                    iCliente.getJbConectar().setText("Conectar");
                    ClientSocket = null;
                    iCliente.cliente = null;
                    this.stop();
                } else {
                    String[] msg = message.split("#");
                    if ("2".equals(msg[0])) {
                        DefaultListModel listaModel = new DefaultListModel();
                        //ListModel lista = iCliente.jtListaClientes.getModel();
                        listaClientes = new HashMap();
                        searchByName = new HashMap();
                        for (int i = 1; i < msg.length; i = i + 3) {
                            String nome = msg[i];
                            String ip = msg[i + 1];
                            int port = Integer.parseInt(msg[i + 2]);
                            Client c = new Client(nome, ip, port);
                            listaClientes.put(nome + ":" + ip + ":" + port, c);
                            searchByName.put(nome, c);
                            listaModel.addElement(nome);
                        }
                        Client c = new Client("Todos", "999.999.999.999", 99999);
                        listaClientes.put("Todos:999.999.999.999:99999", c);
                        searchByName.put("Todos", c);
                        listaModel.addElement("Todos");
                        iCliente.getJtListaClientes().setModel(listaModel);
                    } else if ("4".equals(msg[0])) {
                        System.out.println(msg[1] + ":" + msg[2] + ":" + msg[3]);
                        Client cliente = listaClientes.get(msg[1] + ":" + msg[2] + ":" + msg[3]);
                        iCliente.getJtAnswer().setText(iCliente.getJtAnswer().getText() + "\n"
                                + cliente.getNome() + " says to me"
                                + msg[4]);
                    }
                }
                // String received = in.readLine();

                // iCliente.jtAnswer.setText(iCliente.jtAnswer.getText() + "\n" + message);
            } catch (IOException ex) {
                Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public int closeConnection() {
        try {
            this.stop();
            ClientSocket.close();
            ClientSocket = null;
        } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public boolean createConnection() throws IOException {
        //Geração do socket
        // Socket ClientSocket = null;

        // cria o stream do teclado
        //BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        if (ClientSocket == null) {
            try {
                /* cria o socket do cliente para conexao com o servidor
                 que esta na maquina work1 operando na porta 4444 */

                ClientSocket = new Socket(ipServer, serverPort);

                if (!ClientSocket.isConnected()) {
                    ClientSocket = null;
                    return false;
                }
                /* associa um buffer de entrada e outro de saida ao socket */
                in = new DataInputStream(ClientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
                out = new PrintStream(ClientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
                //imprime a resposta de conexão do servidor
                //iCliente.jtAnswer.setText(iCliente.jtAnswer.getText() + "\n" + in.readLine());
                sendMessage("1#" + this.username);
            } catch (UnknownHostException e) {
                System.err.println("Host desconhecido: ");
                ClientSocket = null;
                return false;
            } catch (IOException e) {
                System.err.println("IP ou Porta não existe ");
                ClientSocket = null;
                return false;
            } catch (Exception e) {
                System.out.println("Falha na conexão com o servidor");
                ClientSocket = null;
                return false;
            }
        }

        return true;
    }

    public void sendMessage(String message) {
        try {
            //aguarda uma digitação pelo teclado para enviar ao servidor
            // lê uma linha do teclado
            //System.out.print("Digite uma mensagem: ");
            //message = teclado.readLine();
            out.println(message);
            //imprime a resposta do servidor
        } catch (Exception ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void forwardMessage(String message, String clienteDestino) {
        if(!"Todos".equals(clienteDestino))
            iCliente.getJtAnswer().setText(iCliente.getJtAnswer().getText() + "\n" + "You say to " + clienteDestino + ": " + message);
        Client cliente = searchByName.get(clienteDestino);
        String sendMessageTo = "3#" + cliente.getIpAddress() + "#" + cliente.getPort() + "#" + message;
        sendMessage(sendMessageTo); 
    }
}
