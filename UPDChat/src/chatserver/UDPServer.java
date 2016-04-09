/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

/**
 *
 * @author viniciuscustodio
 */
// Recebe um pacote de algum cliente
// Separa o dado, o endere�o IP e a portaCliente deste cliente
// Transforma em mai�scula
// Envia ao cliente, usando o endere�o IP e a portaCliente recebidos
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

class UDPServer extends Thread {

    DatagramSocket serverSocket;
    String mensagemRecebida = "";
    DatagramPacket pacoteRecebimento;
    DatagramPacket sendPacket;
    byte[] msgRecebida = new byte[1024];
    byte[] msgEnviar = new byte[1024];
    Map<String, Client> connectedClients = new HashMap();

    public void run() {
        try {
            pacoteRecebimento = new DatagramPacket(msgRecebida, msgRecebida.length);
            // recebe o pacote do cliente
            serverSocket.receive(pacoteRecebimento);

            mensagemRecebida = new String(pacoteRecebimento.getData(), pacoteRecebimento.getOffset(), pacoteRecebimento.getLength());
            String[] splitString = mensagemRecebida.split("#");
            int tipoMensagem = Integer.parseInt(splitString[0]);
            if (tipoMensagem == 1) {
                String nome = splitString[1];
                String clienteIp = pacoteRecebimento.getAddress().toString();
                int port = pacoteRecebimento.getPort();
                Client client = new Client(clienteIp, port, nome);
                connectedClients.put((clienteIp + ":" + port), client);

                String msgEnviarString = this.createList();
                msgEnviar = msgEnviarString.getBytes();

                sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(clienteIp), port);
                serverSocket.send(sendPacket);

            }
        } catch (Exception e) {

        }
    }

    public boolean openServer(int porta) {
        try {
            serverSocket = new DatagramSocket(porta);
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private String createList() {
        // Iterator i = connectedClients.
        String lista = "2#";
        for (Map.Entry<String, Client> client: connectedClients.entrySet()) {
            Client cliente = client.getValue();
            lista = lista + cliente.getIpAddress() + "#" + cliente.getPort() + "#" + cliente.getPort();
        }
        return lista;
    }
}
