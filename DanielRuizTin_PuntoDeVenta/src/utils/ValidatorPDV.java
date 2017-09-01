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
}
