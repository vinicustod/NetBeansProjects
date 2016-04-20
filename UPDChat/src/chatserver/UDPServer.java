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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class UDPServer extends Thread {

    DatagramSocket serverSocket;
    String mensagemRecebida = "";
    DatagramPacket pacoteRecebimento;
    DatagramPacket sendPacket;
    byte[] msgRecebida = new byte[1024];
    byte[] msgEnviar = new byte[1024];
    Map<String, Client> connectedClients = new HashMap();

    public boolean closeServer() {
        msgEnviar = "2#".getBytes();
        for (Map.Entry<String, Client> cliente : connectedClients.entrySet()) {
            Client client = cliente.getValue();

            try {
                sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(client.getIpAddress()), client.getPort());
                serverSocket.send(sendPacket);

            } catch (IOException e) {
                System.out.println(e);
            }

        }
        this.stop();
        serverSocket.close();
        return true;
    }

    public void run() {
        while (true) {
            try {
                pacoteRecebimento = new DatagramPacket(msgRecebida, msgRecebida.length);
                // recebe o pacote do cliente
                serverSocket.receive(pacoteRecebimento);

                mensagemRecebida = new String(pacoteRecebimento.getData(), pacoteRecebimento.getOffset(), pacoteRecebimento.getLength());
                String[] splitString = mensagemRecebida.split("#");
                System.out.println(mensagemRecebida);

                int tipoMensagem = Integer.parseInt(splitString[0]);

                if (tipoMensagem == 1) {
                    System.out.println("Mensagem 1");
                    String nome = splitString[1];
                    String clienteIp = pacoteRecebimento.getAddress().toString().replace("/", "");
                    int port = pacoteRecebimento.getPort();
                    Client client = new Client(clienteIp, port, nome);
                    connectedClients.put((clienteIp + ":" + port), client);

                    String msgEnviarString = this.createList();
                    System.out.println(msgEnviarString);
                    msgEnviar = msgEnviarString.getBytes();
                    for (Map.Entry<String, Client> receiver : connectedClients.entrySet()) {

                        Client clientReceiver = receiver.getValue();
                        sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(clientReceiver.getIpAddress()), clientReceiver.getPort());
                        serverSocket.send(sendPacket);

                    }
                    System.out.println("Sair msg 1");

                } else if (tipoMensagem == 3) {
                    Client sender = connectedClients.get(pacoteRecebimento.getAddress().toString().replace("/", "") + ":"
                            + pacoteRecebimento.getPort());
                    System.out.println(splitString[1]);
                    System.out.println(splitString[2]);
                    if ("999.999.999.999".equals(splitString[1]) && "99999".equals(splitString[2])) {
                        System.out.println("todos");
                        for (Map.Entry<String, Client> cliente : connectedClients.entrySet()) {
                            String msgEnviarString = "4";
                            Client client = cliente.getValue();
                            msgEnviarString = msgEnviarString + "#" + sender.getIpAddress() + "#" + sender.getPort() + "#" + splitString[3];
                            msgEnviar = msgEnviarString.getBytes();

                            sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(client.getIpAddress()), client.getPort());

                            serverSocket.send(sendPacket);
                        }
                    } else {
                        String msgEnviarString = "4#" + sender.getIpAddress() + "#" + sender.getPort() + "#" + splitString[3];
                        msgEnviar = msgEnviarString.getBytes();

                        sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(splitString[1]), Integer.parseInt(splitString[2]));
                        serverSocket.send(sendPacket);
                    }
                } else if (tipoMensagem == 5) {
                    System.out.println("5 recebido");
                    connectedClients.remove(pacoteRecebimento.getAddress().toString().replace("/", "") + ":"
                            + pacoteRecebimento.getPort());
                    String msgEnviarString = createList();
                    msgEnviar = msgEnviarString.getBytes();

                    for (Map.Entry<String, Client> cliente : connectedClients.entrySet()) {
                        Client client = cliente.getValue();

                        sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, InetAddress.getByName(client.getIpAddress()), client.getPort());

                        serverSocket.send(sendPacket);
                    }
                }
            } catch (Exception e) {

            }
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
        String lista = "2";
        for (Map.Entry<String, Client> client : connectedClients.entrySet()) {
            Client cliente = client.getValue();
            lista = lista + "#" + cliente.getIpAddress() + "#" + cliente.getPort() + "#" + cliente.getName();
        }
        return lista;
    }
}
