/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author lucasmarques
 * 
 */
public class BinaryProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic 
        morseCode mc = new morseCode();
        TreeNode tree = new TreeNode(); //create the first and empty node of the tree
        mc.create("•-", 'A', tree); // the next lines will add the alphabet into the tree
        mc.create("-•••", 'B', tree);
        mc.create("-•-•", 'C', tree);
        mc.create("-••", 'D', tree);
        mc.create("•", 'E', tree);
        mc.create("••-•", 'F', tree);
        mc.create("--•", 'G', tree);
        mc.create("••••", 'H', tree);
        mc.create("••", 'I', tree);
        mc.create("•---", 'J', tree);
        mc.create("-•-", 'K', tree);
        mc.create("•-••", 'L', tree);
        mc.create("--", 'M', tree);
        mc.create("-•", 'N', tree);
        mc.create("---", 'O', tree);
        mc.create("•--•", 'P', tree);
        mc.create("--•-", 'O', tree);
        mc.create("•-•", 'R', tree);
        mc.create("•••", 'S', tree);
        mc.create("–", 'T', tree);
        mc.create("••-", 'U', tree);
        mc.create("•••-", 'V', tree);
        mc.create("•--",'W',tree);
        mc.create("-••-", 'X',tree);
        mc.create("-•--", 'Y',tree);
        mc.create("--••", 'Z',tree);

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine(); //read the morse code
        String result = mc.morseTranslate(code, tree); //translate the morse code
        String fresult = new String();
        String[] words = result.split(" ");
        fresult = words[0].charAt(0) + words[0].substring(1).toLowerCase(); 
        for(int i = 1; i < words.length ; i++){ //capitalize first letter of each word
            fresult = fresult + " " + words[i].charAt(0)  + words[i].substring(1).toLowerCase();
        }
        System.out.println(fresult);
        

        
    }
    
}
