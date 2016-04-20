package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viniciuscustodio
 */
public class CreateServer extends Thread {

    int porta;
    static InterfaceServer iServer;
    static ServerSocket serverSocket = null;
    private Map<String, Servidor> connectedClients = new HashMap();
    //static protected Map<String, Cliente> listaClientes;

    public CreateServer(InterfaceServer iServer, int portaServidor) {
        this.porta = portaServidor;
        this.iServer = iServer;
    }

    public void broadcastMessage(String nome, String ipAddress, int port, String msg) {
        for (Map.Entry<String, Servidor> cliente : connectedClients.entrySet()) {
            Servidor connected = cliente.getValue();
            connected.sendMessage("4"
                    + "#" + nome
                    + "#" + ipAddress
                    + "#" + port
                    + "#" + msg);
        }
    }

    public void fowardMessage(String ipDestino, String portaDestino, String ipOrigem, int portaOrigem, String nome, String mensagem) {
        Servidor cliente = connectedClients.get(ipDestino + ":" + portaDestino);
        cliente.sendMessage("4#" + nome + "#"
                + ipOrigem + "#"
                + portaOrigem + "#"
                + mensagem);
    }

    public synchronized String createListConnectedClients() {
        String clientsList = "2";
        for (Map.Entry<String, Servidor> cliente : connectedClients.entrySet()) {
            Servidor connected = cliente.getValue();
            clientsList = clientsList
                    + "#" + connected.getCliente().getNome()
                    + "#" + connected.getCliente().getIpAddress() + "#"
                    + connected.getCliente().getPort();
        }
        return clientsList;
    }

    public void stopAll() {
        for (Map.Entry<String, Servidor> cliente : getConnectedClients().entrySet()) {
            Servidor thread = cliente.getValue();
            thread.closingServer();
            thread.stop();
        }
    }

    public void run() {
        iServer.jtMessage.setText(iServer.jtMessage.getText() + "\n" + "Servidor carregado no IP 127.0.0.1 e na porta " + porta);

        //ServerSocket servidorEco = null;        // cria o socket do servidor
        Socket socketCliente = null;            // cria o socket do cliente

        try {

            serverSocket = new ServerSocket(porta);  // instancia o socket do servidor na porta 9999
            connectedClients = new HashMap();
        } catch (IOException e) {

            System.out.println(e);
        }

        try {
            while (true) {
                socketCliente = serverSocket.accept();                         // aguarda conexão do cliente
                Servidor t = new Servidor(this, socketCliente, serverSocket, porta);
                getConnectedClients().put(socketCliente.getInetAddress().getHostAddress() + ":" + socketCliente.getPort(), t);
                t.start();
            }
        } catch (IOException e) {
        }
    }

    /**
     * @return the connectedClients
     */
    public Map<String, Servidor> getConnectedClients() {
        return connectedClients;
    }

    /**
     * @param connectedClients the connectedClients to set
     */
    public void setConnectedClients(Map<String, Servidor> connectedClients) {
        this.connectedClients = connectedClients;
    }

    public void removeConnection(Cliente cliente) {
        this.connectedClients.remove(cliente.getIpAddress() + ":" + cliente.getPort());
    }

    void updateClientsList() {
        String listClients = this.createListConnectedClients();
        System.out.println(listClients);
        for (Map.Entry<String, Servidor> cliente : connectedClients.entrySet()) {
            Servidor connected = cliente.getValue();
            connected.sendMessage(listClients);
        }
    }

}
