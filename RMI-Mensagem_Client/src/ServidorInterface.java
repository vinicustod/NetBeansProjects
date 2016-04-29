
import java.rmi.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */

// Interface responsável por conter as assinaturas dos métodos remotos.
// Obrigatóriamente esta interface deve herdar da classe Remote, esta do pacote RMI do Java.
public interface ServidorInterface extends Remote {
    
    // Método remoto
    // Todos os métodos remotos podem gerar uma exceção RemoteException
    String imprimirMensagem(String mensagem) throws RemoteException;
}
