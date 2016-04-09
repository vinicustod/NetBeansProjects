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
public class Server {
    public String controllerFile, messageFile;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String control, message;
        Server s = new Server();
        s.run(args);
        System.out.println();
        //Controller.addServer(this.getClass());
        do {
            //JOptionPane.showMessageDialog(null, "testando");
            BufferedReader controlReader = new BufferedReader(new FileReader("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/controller.txt"));
            control = controlReader.readLine();
            if( control == null){
            
            }else if (control.equals("read")){
                BufferedReader messageReader = new BufferedReader(new FileReader("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/message.txt"));
                message = messageReader.readLine();
                System.out.println(message);
                messageReader.close();
                FileWriter fwMessage = new FileWriter("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/message.txt", false);
                PrintWriter pwMessage = new PrintWriter(fwMessage, false);
                pwMessage.flush();
                pwMessage.print(message.toUpperCase());
                pwMessage.close();
                
                FileWriter fwControl = new FileWriter("/users/viniciuscustodio/NetBeansProjects/Echo Server - SD/src/control/controller.txt", false);
                PrintWriter pwControl = new PrintWriter(fwControl, false);
                pwControl.flush();
                pwControl.print("continue");
                System.out.println("mensagem alterada server");
                pwControl.close();

            }
            controlReader.close();

        } while (true);
    }

}
