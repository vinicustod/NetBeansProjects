/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservertcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

/**
 *
 * @author viniciuscustodio
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10000);
        // TODO code application logic here
        Socket cliente = socket.accept();
        Connection c = new Connection(cliente);
    }
    
}
