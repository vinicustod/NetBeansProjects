package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viniciuscustodio
 */
public class ServerManager extends Thread {

    int porta;
    static InterfaceServer iServer;
    static ServerSocket serverSocket = null;
    private Map<String, ServerCommunication> connectedClients = new HashMap();
    //static protected Map<String, Client> listaClientes;

    public ServerManager(InterfaceServer iServer, int portaServidor) {
        this.porta = portaServidor;
        this.iServer = iServer;
    }

    public synchronized void broadcastMessage(String nome, String ipAddress, int port, String msg) {
        for (Map.Entry<String, ServerCommunication> cliente : connectedClients.entrySet()) {
            ServerCommunication connected = cliente.getValue();
            connected.sendMessage("4"
                    + "#" + nome
                    + "#" + ipAddress
                    + "#" + port
                    + "#" + msg);
        }
    }

    public synchronized void fowardMessage(String ipDestino, String portaDestino, String ipOrigem, int portaOrigem, String nome, String mensagem) {
        ServerCommunication cliente = connectedClients.get(ipDestino + ":" + portaDestino);
        cliente.sendMessage("4#" + nome + "#"
                + ipOrigem + "#"
                + portaOrigem + "#"
                + mensagem);
    }

    public void updateTable(){
        DefaultTableModel model = (DefaultTableModel) iServer.getjTable().getModel();
        int count = model.getRowCount();
        for(int i = count -1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Map.Entry<String, ServerCommunication> cliente: connectedClients.entrySet()){
            ServerCommunication connected = cliente.getValue();
            Object[] row = {connected.getCliente().getNome(),
                            connected.getCliente().getIpAddress(),
                            connected.getCliente().getPort()};
            model.addRow(row);
        }
        iServer.getjTable().setModel(model);
    }
    
    public synchronized String createListConnectedClients() {
        String clientsList = "2";
        for (Map.Entry<String, ServerCommunication> cliente : connectedClients.entrySet()) {
            ServerCommunication connected = cliente.getValue();
            clientsList = clientsList
                    + "#" + connected.getCliente().getNome()
                    + "#" + connected.getCliente().getIpAddress() + "#"
                    + connected.getCliente().getPort();
        }
        this.updateTable();
        return clientsList;
    }

    public void stopAll() {
        for (Map.Entry<String, ServerCommunication> cliente : getConnectedClients().entrySet()) {
            ServerCommunication thread = cliente.getValue();
            thread.closingServer();
            thread.stop();
        }
    }

    public void run() {
        iServer.getJtMessage().setText(iServer.getJtMessage().getText() + "\n" + "Servidor carregado no IP 127.0.0.1 e na porta " + porta);

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
                ServerCommunication t = new ServerCommunication(this, socketCliente, serverSocket, porta);
                getConnectedClients().put(socketCliente.getInetAddress().getHostAddress() + ":" + socketCliente.getPort(), t);
                t.start();
            }
        } catch (IOException e) {
        }
    }

    /**
     * @return the connectedClients
     */
    public Map<String, ServerCommunication> getConnectedClients() {
        return connectedClients;
    }

    /**
     * @param connectedClients the connectedClients to set
     */
    public synchronized void setConnectedClients(Map<String, ServerCommunication> connectedClients) {
        this.connectedClients = connectedClients;
    }

    public synchronized void removeConnection(Client cliente) {
        this.connectedClients.remove(cliente.getIpAddress() + ":" + cliente.getPort());
        updateTable();
    }

    public synchronized void updateClientsList() {
        String listClients = this.createListConnectedClients();
        System.out.println(listClients);
        for (Map.Entry<String, ServerCommunication> cliente : connectedClients.entrySet()) {
            ServerCommunication connected = cliente.getValue();
            connected.sendMessage(listClients);
        }
    }

}
