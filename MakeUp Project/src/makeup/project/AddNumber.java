/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeup.project;

import java.util.Stack;

/**
 *
 * @author lucasmarques
 */
public class AddNumber {

    public static SumRetValue addLargeNumbers(String number1, String number2) {
        SumRetValue sumValue = new SumRetValue();

        char[] num1 = number1.toCharArray(); //converting string to char
        char[] num2 = number2.toCharArray(); //converting string to char
        int rvalue, value1 = 0, value2, sum, carry = 0;
        String fresult = new String();

        Stack s1 = new Stack(); //first stack
        Stack s2 = new Stack(); //second stack
        Stack result = new Stack();

        if (num1[0] == '-' || num2[0] == '0') { // checking for errors (negative/starting with 0)
            sumValue.setError_message("Negative Number");
            sumValue.setSucess(false);
            return sumValue;
        } else if (num1[0] == '0' || num2[0] == '0') {
            sumValue.setError_message("Number starting with 0 not allowed");
            sumValue.setSucess(false);
            return sumValue;
        }

        for (int i = 0; i < num1.length; i++) {
            if (Character.isDigit(num1[i])) { //check for non-numbers
                int number = Character.getNumericValue(num1[i]);
                s1.add(number);
            } else {
                sumValue.setError_message("Non-number");
                sumValue.setSucess(false);
                return sumValue;

            }
        }

        for (int i = 0; i < num2.length; i++) {
            if (Character.isDigit(num2[i])) { //check for non-numbers
                int number = Character.getNumericValue(num2[i]);
                s2.add(number);
            } else {
                sumValue.setError_message("Non-number");
                sumValue.setSucess(false);
                return sumValue;

            }
        }

        while (!s1.empty() || !s2.empty()) { //check if the both list are empty
            value1 = value2 = sum = 0;
            if (!s2.empty() && !s1.empty()) { 
                value2 = (int) s2.pop();
                value1 = (int) s1.pop();
            }else if(!s2.empty()){
                value2 = (int) s2.pop();
            }else{
                value1 = (int) s1.pop();
            }
            
            sum = value1 + value2 + carry;

            if (0 < ((int) sum / 10)) { // case sum > 9 than you have a carry 1, carry will never be bigger than 1 ( 9 + 9 = 18)
                carry = 1;
                result.add(sum - 10);
            } else { //without carry
                carry = 0;
                result.add(sum);
            }
        }
        
        while (!result.isEmpty()) { //remove from stack and add to a string
            rvalue = (int) result.pop();
            fresult = fresult + rvalue;
        }
        sumValue.setResult(fresult); //set in the variable
        sumValue.setSucess(true);
        return sumValue; 
    }
}
