/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package april11;

import java.util.Stack;

/**
 *
 * @author viniciuscustodio
 */
public class April11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int item1 = 4, item3 = 0, item2 = item1+1;
        Stack s = new Stack();
        s.push(item2);
        s.push(item2+1);
        s.push(item1);
        item2 = (int) s.peek();
        s.pop();
        item1 = item2 + 1;
        s.push(item1);
        s.push(item3);
        
        while(!s.isEmpty()){
            item3 = (int) s.peek();
            s.pop();
            System.out.println(item3);
        }
        System.out.println(item1 + " " + item2 + " " + item3);
        
        // TODO code application logic here
    }
    
}
