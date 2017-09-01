/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Grupo Salinas 170828
 */
public class ValidatorPDV {
    static private Scanner sc = new Scanner(System.in);
    
    public static String leerSoloLetras(String mensaje){
        boolean correct = false;
        String cadena;
        do{
            System.out.println(mensaje);          
            cadena = sc.nextLine();   
            // usando expresiones Lamda Character::isAlphabetic 
            correct = cadena.chars().allMatch( Character::isAlphabetic );            
            if (!correct) {
                System.out.println("Solo se permiten letras");
            }            
        } while(!correct);
        return cadena;
    }
    
    public static Double leerSoloDouble(String mensaje){
        boolean correct = false;
        String cadena;
        do{
            System.out.println(mensaje);          
            cadena = sc.nextLine();   
            String regExp = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";
            correct = cadena.matches(regExp);           
            if (!correct) {
                System.out.println("Introduzca un número real o entero (5.55 o 5)");
            }            
        } while(!correct);
        
        try {
            return Double.parseDouble(cadena);
        } catch(PDVException e){
            System.err.println("No se pudo leer el número.");
            return 0.0;
        }
    }
    
}
