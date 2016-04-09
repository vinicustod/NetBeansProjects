
import chatserver.Client;
import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class UDPClient extends Thread {

    InetAddress ipServidor;
    Map<String, Client> map;
    DatagramSocket clientSocket;
    DatagramPacket enviarPacote;
    DatagramPacket receberPacote;
    byte[] msgEnviar = new byte[1024];
    byte[] msgRecebida = new byte[1024];
    String msgRecebidaServidor;

    @Override
    public void run() {
        try {
            clientSocket.receive(receberPacote);
            // separa somente o dado recebido
            msgRecebidaServidor = new String(receberPacote.getData(), receberPacote.getOffset(), receberPacote.getLength());
            String[] mensagem = msgRecebidaServidor.split("#");
            if(mensagem[0] == "2"){
                this.connectedClients(msgRecebidaServidor);
            }else if(mensagem[0] == "4"){
                this.messageReceived(msgRecebidaServidor);
            }
        } catch (Exception e) {

        }
    }

    public void connect2Server(String name) {

        // dados do servidor
        try {
            ipServidor = InetAddress.getByName("127.0.0.1");

            int portaServidor = 10000;

            // declaração da mensagem que será enviada
            //String textoDigitado = "";
            // cria o stream do teclado
            // BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            // declara socket cliente
            clientSocket = new DatagramSocket();

            //Vetores de bytes para envio e recepção de mensagens
            //Criação de objtos necessários para envio e recepção de mensagens
            name = "1#" + name;
            msgEnviar = name.getBytes();

            // cria pacote com o dado, o endereço do server e porta do servidor
            enviarPacote = new DatagramPacket(msgEnviar, msgEnviar.length, ipServidor, portaServidor);

            //pacote com a conexao (pedido)
            clientSocket.send(enviarPacote);

            receberPacote = new DatagramPacket(msgRecebida, msgRecebida.length);

            // esperando lista
            clientSocket.setSoTimeout(10000);

            clientSocket.receive(receberPacote);

            // separa somente o dado recebido
            msgRecebidaServidor = new String(receberPacote.getData(), receberPacote.getOffset(), receberPacote.getLength());

            if (this.connectedClients(msgRecebidaServidor)) {
                this.start();
            } else {
                System.out.println("Timeout");
            }

        } catch (SocketTimeoutException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private boolean messageReceived(String message){
        String[] msg = message.split("#");
        String ipString = msg[1];
        String port = msg[2];
        String finalMessage = msg[3];
        
        // print in screen
        return true;
    }

    private boolean connectedClients(String list) {
        try {
            String[] clientsList = list.split("#");
            int pacote = Integer.parseInt(clientsList[0]);
            if (pacote == 2) {
                for (int i = 1; 0 < clientsList.length; i = i + 3) {
                    String ipClient = clientsList[i];
                    int portClient = Integer.parseInt(clientsList[i + 1]);
                    String nameClient = clientsList[i + 2];
                    Client client = new Client(ipClient, portClient, nameClient);
                    map = new HashMap<>();
                    map.put((ipClient + ":" + portClient), client);

                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }
}
