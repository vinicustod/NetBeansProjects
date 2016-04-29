
import java.rmi.RemoteException;
import java.rmi.server.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */

// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class ServidorImpl extends UnicastRemoteObject implements ServidorInterface {
    
    public ServidorImpl() throws RemoteException {
        
        super();
    }

    // Método remoto implementado.
    @Override
    public String imprimirMensagem(String mensagem) {
        
        // Receberá uma String do cliente e a imprimirá
        System.out.println("Mensagem Recebida: " + mensagem);
        return mensagem.toUpperCase();
    }    
}
