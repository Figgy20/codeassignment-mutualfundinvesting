/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uc.edu.ph.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author m303user
 */
public class Reader {
    private static BufferedReader getReader(){
        return new BufferedReader(new InputStreamReader(System.in));
    }
    public static String readString(String message) throws IOException{
        System.out.print("Enter "+message+": ");
        
        return getReader().readLine();
    }
    public static double readDouble(String message) throws IOException{
        System.out.print("Enter "+message+": ");
        
        return Double.parseDouble(getReader().readLine());
    }
}
