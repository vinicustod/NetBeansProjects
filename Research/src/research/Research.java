/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author viniciuscustodio
 */
public class Research {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // TODO code application logic here
        File neigh = new File("src/research/routes2.txt");
        File distance = new File("src/research/distance.txt");
        File intersect = new File("src/research/intersect.txt");
        File xbus = new File("src/research/bustimes.txt");

        PrintWriter dout = new PrintWriter("distanceout.txt", "UTF-8");
        PrintWriter eout = new PrintWriter("edgesoutput.txt", "UTF-8");
        PrintWriter setout = new PrintWriter("setoutput", "UTF-8");
        PrintWriter cout = new PrintWriter("capoutput", "UTF-8");
        PrintWriter equalbus = new PrintWriter("equalbus.txt", "UTF-8");
        //String region, neighbor;

        HashMap hm = new HashMap();

        try {

            Scanner sneigh = new Scanner(neigh);
            Scanner sdistance = new Scanner(distance);
            Scanner sintersect = new Scanner(intersect);
            Scanner sbus = new Scanner(xbus);

            HashMap<Integer, Integer> eachBus = new HashMap();
            while (sbus.hasNext()) {
                String line = sbus.nextLine();
                String[] lbus = line.split("	");
                eachBus.put(Integer.parseInt(lbus[0]), Integer.parseInt(lbus[1]));
            }

            HashMap<Integer, Pair> distanceList = new HashMap();
            int prev = -99;
            Pair p = new Pair();
            while (sdistance.hasNext()) {
                String line = sdistance.nextLine();
                String[] ldistance = line.split(" ");

                //System.out.println(prev + "<<Prev Now>>"+ (Integer.parseInt(ldistance[0]) - 1));
                if (prev != Integer.parseInt(ldistance[0]) - 1) {

                    p = new Pair();
                    p.distance = new HashMap();
                    p.distance.put(Integer.parseInt(ldistance[1]) - 1, Float.parseFloat(ldistance[2]));
                    prev = p.key = Integer.parseInt(ldistance[0]) - 1;
                    distanceList.put(prev, p);
                    //System.out.println("Interno "+p.distance.get(Integer.parseInt(ldistance[1]) - 1));
                    // System.out.println( ldistance[0] + " " + ldistance[1] + " " + ldistance[2]);

                } else {

                    //System.out.println( ldistance[0] + " " + ldistance[1] + " " + ldistance[2]);
                    p.distance.put(Integer.parseInt(ldistance[1]) - 1, Float.parseFloat(ldistance[2]));
                    //  System.out.println("Externo " + p.distance.get(Integer.parseInt(ldistance[1]) - 1));

                }
            }

            HashMap<Integer, LinkedList> HMintersect = new HashMap();
            while (sintersect.hasNext()) {
                LinkedList llintersect = new LinkedList();
                String line = sintersect.nextLine();
                String[] lintersect = line.split(" ");
                int key = Integer.parseInt(lintersect[0]);
                for (int i = 1; i < lintersect.length; i++) {
                    llintersect.add(Integer.parseInt(lintersect[i]));
                }
                llintersect.sort(null);
                HMintersect.put(key, llintersect);

            }
            dout.println("*********Cost********");
            eout.println("********Edges********");
            setout.println("********Set*********");
            cout.println("*******Capacity******");
            setout.println("sets i nodes /");
            while (sneigh.hasNext()) {
                String line = sneigh.nextLine();
                String[] lneigh = line.split(" ");
                int neighNumber = lneigh.length; //how much words one line has
                int nregion = Integer.parseInt(lneigh[0]);
                int capacity;
                LinkedList llregion = (LinkedList) HMintersect.get(nregion);

                if (!llregion.isEmpty()) {
                    setout.println(lneigh[0]);
                    for (int i = 1; i < neighNumber; i++) {
                        capacity = 0;
                        if (lneigh[i].equals(lneigh[0])) {
                            continue;
                        }

                        LinkedList llneigh = (LinkedList) HMintersect.get(Integer.parseInt(lneigh[i]));

                        if (!llneigh.isEmpty()) {
                            LinkedList llbus = compareList(llregion, llneigh);
                            if (!llbus.isEmpty()) {
                                
                                Pair p2 = distanceList.get(Integer.parseInt(lneigh[0]));
                                float distancia = p2.distance.get(Integer.parseInt(lneigh[i]));
                                dout.println("cost ('" + lneigh[0] + "', '" + lneigh[i] + "', 'bus') = " + distancia + ";");
                                eout.println("e ('" + lneigh[0] + "', '" + lneigh[i] + "', 'bus') = 1;");
                                Iterator ibus = llbus.iterator();
                                equalbus.println(lneigh[0] + " " + lneigh[i]);
                                
                                while (ibus.hasNext()) {
                                    int bustimes = (int) ibus.next();
                                    equalbus.println(bustimes);
                                    capacity = capacity + eachBus.get(bustimes) * 60;
                                }
                                cout.println("cap ('" + lneigh[0] + "', '" + lneigh[i] + "', 'bus') = " + capacity + ";");

                            }
                        }

                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exist");
        } catch (NumberFormatException e) {
            System.out.println("Error What?");
        }
        setout.println("/");
        dout.close();
        eout.close();
        setout.close();
        cout.close();
    }

    private static LinkedList compareList(LinkedList llregion, LinkedList llneigh) {
        int bregion, bneigh;
        Iterator region = llregion.iterator();
        LinkedList equalbus = new LinkedList();
        while (region.hasNext()) {
            Iterator neigh = llneigh.iterator();
            bregion = (int) region.next();
            while (neigh.hasNext()) {
                bneigh = (int) neigh.next();
                if (bregion == bneigh) {
                    equalbus.add(bneigh);
                }
            }
        }
        return equalbus;
    }
}
