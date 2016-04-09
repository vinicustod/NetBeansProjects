import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Cliente {
    static DataInputStream in;                  // cria um duto de entrada
    static PrintStream out;                     // cria um duto de saída


    public static void main(String[] args) throws IOException {

        //Geração do socket
        Socket ClientSocket = null;
        
        // cria o stream do teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            /* cria o socket do cliente para conexao com o servidor
               que esta na maquina work1 operando na porta 4444 */
            ClientSocket = new Socket("127.0.0.1", 9999);
            
            /* associa um buffer de entrada e outro de saida ao socket */
            in = new DataInputStream(ClientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            out = new PrintStream(ClientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente

            //imprime a resposta de conexão do servidor
            System.out.println(in.readLine());
            
            
            //aguarda uma digitação pelo teclado para enviar ao servidor
            // lê uma linha do teclado
            System.out.print("Digite uma mensagem: ");
            out.println(teclado.readLine());
            
            //imprime a resposta do servidor
            System.out.println(in.readLine());
            
                
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("IP ou Porta não existe ");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Falha na conexão com o servidor");
            System.exit(1);
        }
    }
}
