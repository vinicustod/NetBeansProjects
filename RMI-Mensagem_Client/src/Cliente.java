
import javax.swing.*;
import java.rmi.Naming;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Vinicius
 */
public class Cliente {

    public static void main(String args[]) {

        try {

            // Recuperando o objeto remoto.
            // Para obtê-lo é necessário indicar o IP, Porta e Nome do serviço (nome associado a instância do objeto remoto)
            ServidorInterface servidor = (ServidorInterface) Naming.lookup("rmi://localhost:1099/olaMundo");
            
            // Utilização dos métodos remotos, bastante semelhante a utilização de métodos locais.
            //System.out.println();
            JOptionPane.showMessageDialog(null,
                                          servidor.imprimirMensagem(JOptionPane.showInputDialog(null, "Digite a mensagem")));
        } catch (Exception e) {
        
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
