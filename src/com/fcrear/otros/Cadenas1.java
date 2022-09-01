/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcrear.otros;

/**
 *
 * @author USER
 */
public class Cadenas1 {
    public static String devuelvePathMsql(String cadena) {
        String c1 = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '\\') {
                c1 = c1 + "\\\\";
            } else {
                c1 = c1 + cadena.charAt(i);
            }
        }
        return c1;
    }

    public static boolean validaCadena(String cadena) {
        int val = validacionNulos(cadena);
        if (val == cadena.length()) {
            return false;
        } else {
            return true;
        }
    }

    private static int validacionNulos(String cadena) {
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                c++;
            }
        }
        return c;
    }

    private static int firstPositionNull(String cadena) {
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                c++;          
            }else
                break;
        }
        return c;
    }
    
    
        public static String limpiarNulos(String cadena) {
        String  c="";
        int pos = firstPositionNull(cadena);
        System.out.println(" nulo "+pos);
        for (int i = pos; i < cadena.length(); i++) {
                c=c+cadena.charAt(i);
            
        }
        return c;
    }

}
