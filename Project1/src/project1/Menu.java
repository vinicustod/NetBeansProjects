/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author lucasmarques
 */
public class Menu {

    public void showsPatients(LinkedList ll) {
        Iterator i = sortedList(ll).iterator();
        while (i.hasNext()) {
            Patient p = (Patient) i.next();
            System.out.println(p.getName() + ", " + Integer.parseInt(p.getId()));
        }
    }

    public void newPatient(LinkedList<Patient> patients, String id) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //adding a new patient

        Patient p = new Patient();
        System.out.println("Enter patient name: ");
        p.setName(br.readLine());
        p.setId(id);
        System.out.println("Enter address: ");
        p.setAddress(br.readLine());
        System.out.println("Enter patient height: ");
        p.setHeight(Integer.parseInt(br.readLine()));
        System.out.println("Enter patient weight: ");
        p.setWeight(Double.parseDouble(br.readLine()));
        System.out.println("Enter patient birthday (MM/DD/YYYY): ");
        p.setBirth(formatter.parse(br.readLine()));
        System.out.println("Enter patient first visit (MM/DD/YYYY): ");
        p.setFirstVisit(formatter.parse(br.readLine()));
        System.out.println("Enter patient last visit (MM/DD/YYYY): ");
        p.setLastVisit(formatter.parse(br.readLine()));
        patients.add(p);
    }

    public void showsPatients(LinkedList<Patient> patients, int id) {
        Iterator i = patients.iterator();
        Patient p = null;
        while (i.hasNext()) { //searching for the patient
            p = (Patient) i.next();
            if (id == Integer.parseInt(p.getId())) {
                break;
            } else {
                p = null;
            }
        }
        if (p != null) {
            System.out.println(p.getName() + ", " + p.getId() + ", " + p.getAddress() + ", " + p.getHeight() + "ft " + p.getWeight() + "in");
            if(p.get_time_as_patient() < 1)
                System.out.println("Less than a Year.");
            else
                System.out.println("Years as patient: " + p.get_time_as_patient());
        } else {
            System.out.println("Patient not found.");
        }
    }

    public LinkedList sortedList(LinkedList<Patient> ll) {
        LinkedList patients = (LinkedList) ll.clone(); //organizing the list
        LinkedList a = new LinkedList();
        while (!patients.isEmpty()) {
            Iterator i = patients.iterator();
            Patient first = (Patient) i.next();
            while (i.hasNext()) {
                Patient now = (Patient) i.next();
                if (Integer.parseInt(first.getId()) > Integer.parseInt(now.getId())) {
                    first = now;
                }
            }
            a.add(first);
            patients.remove(first);
        }
        return a;
    }

    public int deletePatient(LinkedList<Patient> patients, int id) {
        Iterator i = patients.iterator();
        int toRemove = -1; //flag that represents if the list doesn't contain the patient
        Patient p = null;
        while (i.hasNext()) {
            p = (Patient) i.next();
            if (Integer.parseInt(p.getId()) == id) {
               toRemove = patients.indexOf(p);
            }
        }
        return toRemove;
    }

    public float averageAge(LinkedList<Patient> patients) {
        if (!patients.isEmpty()) {
            Iterator i = patients.iterator();
            float average = 0, numPatients = 0;
            while (i.hasNext()) {
                numPatients++;
                Patient p = (Patient) i.next();
                average = average + p.get_age();
            }
            return (average / numPatients);
        }else{
            System.out.println("Empty List.");
            return 0;
        }
    }

    void youngestInfo(LinkedList<Patient> patients) {
        Iterator i = patients.iterator(); 
        int age = 0, youngest = 0, id = 0, youngid = 0;
        Patient young, p;
        if (i.hasNext()) {
            young = p = (Patient) i.next();
            age = youngest = p.get_age();
        } else {
            System.out.println("Empty list");
            return;
        }
        while (i.hasNext()) {
            p = (Patient) i.next();
            id++;
            int ageCalc = p.get_age();
            if (age > ageCalc) {
                young = p;
                youngid = id;
                youngest = ageCalc;
            }
        }
        showsPatients(patients, Integer.parseInt(young.getId()));

    }

    void overduePatient(LinkedList<Patient> patients) {
        Iterator i = patients.iterator();
        int id = 0;
        while (i.hasNext()) {
            Patient p = (Patient) i.next();
            if (p.get_time_since_last_visit() > 2) {
                System.out.println(p.getName() + ", " + p.getId());
            }
            id++;
        }
    }

    void quit(LinkedList<Patient> patients) throws FileNotFoundException, UnsupportedEncodingException {
        Iterator i = patients.iterator();
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        while (i.hasNext()) {
            Patient p = (Patient) i.next();
            writer.println(p.getName() + " " + p.getId() + " " + p.getAddress() + " " + p.getHeight() + " " + p.getWeight() + " " + (p.getBirth().getMonth() + 1) + "/" + p.getBirth().getDate() + "/" + (p.getBirth().getYear()+1900) + " " + (p.getFirstVisit().getMonth()+ 1) + "/" + p.getFirstVisit().getDate() + "/" + (p.getFirstVisit().getYear()+1900) + " " + (p.getLastVisit().getMonth()+ 1) + "/" + p.getLastVisit().getDate() + "/" + (p.getLastVisit().getYear()+1900));
        }
        writer.close();
    }

    boolean exists(LinkedList<Patient> Patients, int id) {
        Iterator i = Patients.iterator();
        while (i.hasNext()) {
            Patient p = (Patient) i.next();
            if (id == Integer.parseInt(p.getId())) {
                return true;
            }
        }
        return false;
    }

}
