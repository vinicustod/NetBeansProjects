/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echo.server.sd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author viniciuscustodio
 */
public class Client {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String control, mensagem, echo;
        do {
            mensagem = JOptionPane.showInputDialog(null, "Envie uma mensagem:");
            FileWriter fwControl = new FileWriter("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/controller.txt", false);
            PrintWriter pwControl = new PrintWriter(fwControl, false);
            FileWriter fwMessage = new FileWriter("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/message.txt");
            PrintWriter pwMessage = new PrintWriter(fwMessage, false);
            pwMessage.flush();
            pwMessage.print(mensagem);
            pwMessage.close();
            System.out.println(mensagem);
            pwControl.flush();
            pwControl.print("read");
            pwControl.close();

            do {
                BufferedReader controlReader = new BufferedReader(new FileReader("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/controller.txt"));
                control = controlReader.readLine();
                if (control == null) {

                } else if (control.equals("continue")) {
                    System.out.println("mensagem alterada cliente");
                    controlReader.close();
                    break;
                }
                controlReader.close();
            } while (true);

            BufferedReader messageReader = new BufferedReader(new FileReader("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/message.txt"));
            echo = messageReader.readLine();
            pwControl.flush();
            System.out.println("Server says: " + echo);
            pwControl.print("wait");
            pwControl.close();

        } while (!mensagem.equals("exit"));
        FileWriter fwControl = new FileWriter("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/controller.txt", false);
        PrintWriter pwControl = new PrintWriter(fwControl, false);
        pwControl.flush();
        pwControl.print("wait");
    }

}
