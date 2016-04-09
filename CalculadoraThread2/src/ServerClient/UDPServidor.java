package ServerClient;

// Recebe um pacote de algum cliente
// Separa o dado, o endere�o IP e a portaCliente deste cliente
// Transforma em mai�scula
// Envia ao cliente, usando o endere�o IP e a portaCliente recebidos

import ServerClient.Calculadora;
import java.io.IOException;
import java.net.*;
import javax.swing.JOptionPane;

/*
    Funciona similar ao projeto 2 porem a calculadora esta rodando em um thread, a raiz quadrada foi substituida
    pelo simbolo e o inverso uso a divisao sendo que ele nada mais e que 1/x.
*/
class UDPServidor extends Thread {

    private Server s;
    private int port;

    public UDPServidor(Server s, int port) {
        this.s = s;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // cria socket do servidor com a portaCliente 10000
            DatagramSocket serverSocket = new DatagramSocket(port);
            this.s.jtaMessages.setText("Aguardando recepção de mensagens na porta " + this.port);

            while (true) {
                Double resultado;
                String resultadoString = null;
                //Criar vetores de bytes para envio e recepção de mensagens
                byte[] msgRecebida = new byte[1024];
                byte[] msgEnviar = new byte[1024];

                // declara o pacote a ser recebido
                DatagramPacket pacoteRecebimento = new DatagramPacket(msgRecebida, msgRecebida.length);

                // recebe o pacote do cliente
                serverSocket.receive(pacoteRecebimento);

                // pega os dados, o endere�o IP e a portaCliente do cliente
                // para poder mandar a msg de volta
                String mensagemRecebida = new String(pacoteRecebimento.getData(), pacoteRecebimento.getOffset(), pacoteRecebimento.getLength());
                InetAddress ipCliente = pacoteRecebimento.getAddress();
                int portaCliente = pacoteRecebimento.getPort();
                System.out.println(mensagemRecebida);
                this.s.jtaMessages.setText(this.s.jtaMessages.getText() + "\nRecebido de " + ipCliente.getHostAddress() + ":" + portaCliente + " = " + mensagemRecebida);

                try {
                    mensagemRecebida.replace(" ", "");
                    if (mensagemRecebida.equals("desligar")) {
                        break;
                    } else if (mensagemRecebida.contains("+")) {
                        String[] numbers = mensagemRecebida.split("\\+");
                        Calculadora c = new Calculadora(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        resultado = c.realizarAdicao();

                    } else if (mensagemRecebida.contains("-")) {
                        String[] numbers = mensagemRecebida.split("\\-");
                        Calculadora c = new Calculadora(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        resultado = c.realizarSubtracao();

                    } else if (mensagemRecebida.contains("*")) {
                        String[] numbers = mensagemRecebida.split("\\*");
                        Calculadora c = new Calculadora(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        resultado = c.realizarMultiplicacao();

                    } else if (mensagemRecebida.contains("/")) {
                        String[] numbers = mensagemRecebida.split("\\/");
                        Calculadora c = new Calculadora(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        resultado = c.realizarDivisao();

                    } else if (mensagemRecebida.contains("^")) {
                        String[] numbers = mensagemRecebida.split("\\^");
                        Calculadora c = new Calculadora(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        resultado = c.realizarPotenciacao();

                    } else if (mensagemRecebida.contains("√")) {
                        String number = mensagemRecebida.replace("√", "");
                        Calculadora c = new Calculadora(Double.parseDouble(number));
                        resultado = c.realizarRaizQuadrada();

                    } else {
                        resultado = null;
                    }

                    if (resultado == null) {
                        resultadoString = "Operacao Invalida";
                    } else {
                        resultadoString = resultado.toString();
                    }

                } catch (NumberFormatException nfe) {
                    resultadoString = "Valores Invalidos";
                } catch (Exception e) {
                    resultadoString = e.getMessage();
                } finally {
                    System.out.println(resultadoString);
                    msgEnviar = resultadoString.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(msgEnviar, msgEnviar.length, ipCliente, portaCliente);
                    serverSocket.send(sendPacket);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
