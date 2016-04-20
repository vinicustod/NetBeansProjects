package chatserver;

import chatserver.Client;
import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

class UDPClient extends Thread {

    InetAddress ipServidor;
    Map<String, Client> map;
    Map<String, Client> searchByName;
    DatagramSocket clientSocket;
    DatagramPacket enviarPacote;
    DatagramPacket receberPacote;
    byte[] msgEnviar = new byte[1024];
    byte[] msgRecebida = new byte[1024];
    String msgRecebidaServidor;
    int portaServidor;
    InterfaceClient iClient;

    UDPClient(InterfaceClient aThis) {
        this.iClient = aThis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                clientSocket.receive(receberPacote);
                // separa somente o dado recebido
                msgRecebidaServidor = new String(receberPacote.getData(), receberPacote.getOffset(), receberPacote.getLength());
                String[] mensagem = msgRecebidaServidor.split("#");
                System.out.println("Thread:" + msgRecebidaServidor);
                if ("2".equals(mensagem[0])) {
                    System.out.println("here?");
                    this.connectedClients(msgRecebidaServidor);
                } else if ("4".equals(mensagem[0])) {
                    this.messageReceived(msgRecebidaServidor);
                }
            } catch (Exception e) {

            }
        }
    }

    public boolean connect2Server(String ip, int porta, String name) {

        // dados do servidor
        try {
            ipServidor = InetAddress.getByName(ip);

            portaServidor = porta;

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
            System.out.println("enviar");
            //pacote com a conexao (pedido)
            clientSocket.send(enviarPacote);

            receberPacote = new DatagramPacket(msgRecebida, msgRecebida.length);

            // esperando lista
            //clientSocket.setSoTimeout(10000);
            clientSocket.receive(receberPacote);
            System.out.println("recebido");
            // separa somente o dado recebido
            msgRecebidaServidor = new String(receberPacote.getData(), receberPacote.getOffset(), receberPacote.getLength());
            System.out.println(msgRecebidaServidor);
            this.connectedClients(msgRecebidaServidor);
//            if (this.connectedClients(msgRecebidaServidor)) {
//                this.start();
//            } else {
//                System.out.println("Timeout");
//                return false;
//            }
        } catch (SocketTimeoutException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean desconectar() throws IOException {

        msgEnviar = "5#".getBytes();
        enviarPacote = new DatagramPacket(msgEnviar, msgEnviar.length, ipServidor, portaServidor);
        clientSocket.send(enviarPacote);
        this.stop();
        return true;
    }

    public boolean sendMessage(String message, String nome) throws IOException {
        String msgEnviarString = "";
        if (nome.equals("Todos")) {
            msgEnviarString = "3#999.999.999.999#99999#" + message;

        } else {
            Client receiver = searchByName.get(nome);
            msgEnviarString = "3#" + receiver.getIpAddress() + "#" + receiver.getPort() + "#" + message;

        }
        msgEnviar = msgEnviarString.getBytes();
        enviarPacote = new DatagramPacket(msgEnviar, msgEnviar.length, ipServidor, portaServidor);
        clientSocket.send(enviarPacote);
        return true;
    }

    private boolean messageReceived(String message) {
        String[] msg = message.split("#");
        String ipString = msg[1];
        String port = msg[2];
        String finalMessage = msg[3];
        String nome = "";
        for (Map.Entry<String, Client> client : map.entrySet()) {
            Client c = client.getValue();
            if (c.getIpAddress().equals(ipString) && c.getPort() == Integer.parseInt(port)) {
                nome = c.getName();
                break;
            }
        }
        iClient.jtaMessage.setText(iClient.jtaMessage.getText() + "\n" + nome + " says " + finalMessage);
        // print in screen
        return true;
    }

    private boolean connectedClients(String list) {
        try {
            DefaultListModel listaModel = new DefaultListModel();
            //ListModel lista = iClient.jtListaClientes.getModel();
            String[] clientsList = list.split("#");
            int pacote = Integer.parseInt(clientsList[0]);
            System.out.println("here1");
            map = new HashMap<>();
            searchByName = new HashMap<>();

            if (clientsList.length < 2) {
                iClient.jtListaClientes.setModel(listaModel);
                iClient.servidorDesconectou();
                return false;
            }
            if (pacote == 2) {

                System.out.println(clientsList.length);
                for (int i = 1; i < clientsList.length; i = i + 3) {
                    System.out.println("here2");
                    String ipClient = clientsList[i];
                    int portClient = Integer.parseInt(clientsList[i + 1]);
                    String nameClient = clientsList[i + 2];
                    System.out.println("here3");
                    Client client = new Client(ipClient, portClient, nameClient);
                    map.put((ipClient + ":" + portClient), client);
                    searchByName.put(nameClient, client);
                    System.out.println("here4");
                    listaModel.addElement(nameClient);
                }
                listaModel.addElement("Todos");
                map.put("999.999.999.999", new Client("999.999.999.999", 99999, "Todos"));
                searchByName.put("Todos", new Client("999.999.999.999", 99999, "Todos"));
                iClient.jtListaClientes.setModel(listaModel);

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
