// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.*;
import java.net.*;

public class Servidor {
    
    public static void main(String args[]) {
    
        System.out.println("Servidor carregado no IP 127.0.0.1 e na porta 9999");
        
        ServerSocket servidorEco = null;        // cria o socket do servidor
        String mensagem;                        // string para conter informações transferidas
        DataInputStream dutoEntrada;            // cria um duto de entrada
        PrintStream dutoSaida;                  // cria um duto de saída
        Socket socketCliente = null;            // cria o socket do cliente

        try {
            
            servidorEco = new ServerSocket(9999);  // instancia o socket do servidor na porta 9999
        
        } catch (IOException e) {
            
            System.out.println(e);
        }

        try {
            socketCliente = servidorEco.accept();                         // aguarda conexão do cliente
            dutoEntrada = new DataInputStream(socketCliente.getInputStream());    // aponta o duto de entrada para o socket do cliente
            dutoSaida = new PrintStream(socketCliente.getOutputStream());       // aponta o duto de saída para o socket do cliente
            
            //envia a mensagem de conexão ao cliente
            dutoSaida.println("Conexão efetuada com o servidor 127.0.0.1 Porta 9999");
            
            //aguarda recebimento de dados vindos do cliente
            mensagem = dutoEntrada.readLine();                           // recebe dados do cliente
            
            //envia a mensagem em caixa alta
            dutoSaida.println("Servidor responde:  " + mensagem.toUpperCase());     // envia dados para o cliente
            
        }

        catch (IOException e) {
            System.out.println(e);
        }
    } // main
} // classe