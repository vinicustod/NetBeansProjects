
import java.rmi.Naming;
import java.rmi.RemoteException;
import sun.rmi.registry.RegistryImpl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class Servidor {
    
    // Variáveis responsáveis por possibilitar que este servidor seja alocado em um endereço visível a outros clientes.
    static String ip = "127.0.0.1"; // Definindo IP como localhost
    static int porta = 1099;        // Definindo Porta como 1099

    public Servidor() {
      
        try {
            // Registrando o serviço em uma determinada porta.
            RegistryImpl registryImpl = new RegistryImpl(porta);    
        
            // Instanciando a classe ServidorImpl que é do tipo ServidorInterface.
            ServidorInterface servidor = new ServidorImpl();    
            
            // Possibilitando que a instância contendo métodos remotos fique visível aos clientes. Além do IP e PORTA, deve-se associar um nome a instância.
            // Parâmetros: String (IP, Porta e nome do serviço) e Objeto com métodos remotos.
            Naming.rebind("rmi://" + ip + ":" + porta + "/olaMundo", servidor); 
            
            System.out.println("Servidor Registrado");
            
        } catch (Exception e) {
            
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public static void main ( String args[] ) {

        new Servidor() ; //Nova instância da classe Servidor.
    }
}
