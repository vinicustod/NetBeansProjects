/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeup.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lucasmarques
 */
public class MakeUpProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String num1 = br.readLine();
            String num2 = br.readLine();
            SumRetValue result = AddNumber.addLargeNumbers(num1, num2);
            if(result.isSucess()){
                System.out.println(result.getResult()); //result
            }else{
                System.out.println(result.getError_message()); //errors
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    
}
