/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author lucasmarques
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LinkedList<Patient> patients = new LinkedList();

        File file = new File(input); 
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] words = line.split(" ");
                int addlenght = words.length; //how much words one line has
                int addressEnd = addlenght - 5; //which words is the last word of the address
                String address = words[3];
                for (int i = 4; i < ((addlenght - 5)); i++) { //split the address from the rest of the line
                    address = address + " " + words[i];
                }
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    Date birth = formatter.parse(words[addressEnd + 2]); //Creating date variables 
                    Date first = formatter.parse(words[addressEnd + 3]);
                    Date last = formatter.parse(words[addressEnd + 4]);
                    Patient patient;
                    patient = new Patient(words[0] + " " + words[1], words[2], address, Integer.parseInt(words[addressEnd]), Double.parseDouble(words[addressEnd + 1]), birth, first, last);
                    patients.add(patient);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exist");
        } catch (NumberFormatException e) {
            System.out.println("Error");
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println("1. Display");
        System.out.println("2. Add a new patient");
        System.out.println("3. Show information for a patient.");
        System.out.println("4. Delete a patient.");
        System.out.println("5. Show avarage patient age");
        System.out.println("6. Show information for the youngest patient.");
        System.out.println("7. Show notification list.");
        System.out.println("8. Quit.");
        String menu = br.readLine();
        Menu m = new Menu();

        while (true) {
            switch (menu) {
                case "1":
                    m.showsPatients(patients);
                    break;
                case "2":
                    System.out.println("Enter patient id: "); //looking if id already exist
                    String id = br.readLine();
                    if (!m.exists(patients, Integer.parseInt(id))) {
                        m.newPatient(patients, id);
                    } else {
                        System.out.println("Patient already exists");
                    }
                    break;

                case "3":
                    m.showsPatients(patients, Integer.parseInt(br.readLine()));
                    break;
                case "4":
                    int removeId = m.deletePatient(patients, Integer.parseInt(br.readLine()));
                    if (removeId != -1) { //test if the patient was removed
                        patients.remove(removeId);
                        System.out.println("Patient removed.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case "5":
                    DecimalFormat df = new DecimalFormat("#.#"); //formating value
                    System.out.println("Average age: " + df.format(m.averageAge(patients)));
                    break;
                case "6":
                    m.youngestInfo(patients);
                    break;
                case "7":
                    m.overduePatient(patients);
                    break;
                case "8":
                    m.quit(patients);
                    System.exit(0);
                    break;
            }

            System.out.println("1. Display");
            System.out.println("2. Add a new patient");
            System.out.println("3. Show information for a patient.");
            System.out.println("4. Delete a patient.");
            System.out.println("5. Show avarage patient age");
            System.out.println("6. Show information for the youngest patient.");
            System.out.println("7. Show notification list.");
            System.out.println("8. Quit.");
            menu = br.readLine();

        }
        // TODO code application logic here
    }

}
