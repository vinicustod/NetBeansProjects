package ServerClient;

// Lê uma linha do teclado
// Envia o pacote (linha digitada) ao servidor
// Lê um pacote (linha)do servidor e mostra no vídeo

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket

class UDPCliente {

    public String calculator(String expression, int ClientPort, int ServerPort, String IP) throws SocketException, IOException {
        System.out.println(expression);
        // dados do servidor
        InetAddress ipServidor = InetAddress.getByName(IP);

        // declaração da mensagem que será enviada
        // declara socket cliente
        DatagramSocket clientSocket = new DatagramSocket(ClientPort); //deixar em branco para porta randomica

        //Vetores de bytes para envio e recepção de mensagens
        byte[] msgEnviar = new byte[1024];
        byte[] msgRecebida = new byte[1024];

        //Criação de objtos necessários para envio e recepção de mensagens
        DatagramPacket enviarPacote;
        DatagramPacket receberPacote;

        String msgRecebidaServidor;

        // lê uma linha do teclado
        msgEnviar = expression.getBytes();
        enviarPacote = new DatagramPacket(msgEnviar, msgEnviar.length, ipServidor, ServerPort);
        // cria pacote com o dado, o endereço do server e porta do servidor
        //envia o pacote
        clientSocket.send(enviarPacote);

        // declara o pacote a ser recebido
        receberPacote = new DatagramPacket(msgRecebida, msgRecebida.length);

        // recebe pacote do servidor
        clientSocket.receive(receberPacote);

        // separa somente o dado recebido
        msgRecebidaServidor = new String(receberPacote.getData(), receberPacote.getOffset(), receberPacote.getLength());

        // mostra mensagem recebida do servidor
        // System.out.println("Server " + ipServidor.getHostAddress() + ":" + ServerPort + " says: " + msgRecebidaServidor);
        clientSocket.close();
        return msgRecebidaServidor;

    }
}
