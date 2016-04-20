package controle;


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



// Custódio Viadinho

public class Cliente extends Thread {

    static DataInputStream in;                  // cria um duto de entrada
    static PrintStream out;                     // cria um duto de saída
    static String message;
    Socket ClientSocket = null;
    int serverPort;
    String ipServer;
    InterfaceCliente iCliente;

    public Cliente(InterfaceCliente iCliente, int port, String ipServer) {
        this.serverPort = port;
        this.ipServer = ipServer;
        this.iCliente = iCliente;
    }

    public void run() {
        while (true) {
            try {
                message = in.readLine();
                if (message == null) {
                    iCliente.jtAnswer.setText(iCliente.jtAnswer.getText() + "\n" + "Conexao Encerrada");
                    iCliente.jbConectar.setText("Conectar");
                    ClientSocket = null;
                    iCliente.cliente = null;
                    this.stop();
                }
                // String received = in.readLine();

                iCliente.jtAnswer.setText(iCliente.jtAnswer.getText() + "\n" + message);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public int closeConnection(){
        try {
            this.stop();
            ClientSocket.close();
            ClientSocket = null;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
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
                iCliente.jtAnswer.setText(iCliente.jtAnswer.getText() + "\n" + in.readLine());
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
