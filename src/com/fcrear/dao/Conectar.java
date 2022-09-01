/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcrear.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conectar {
    //declaramos la conexion a mysql
    public static Connection con;
    //declaramos los datos de conexion a la base
    private static final String url = "jdbc:mysql://localhost:3306/crear?autoReconnect=true&useSSL=false";
    private static final String user = "root"; 
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String pass = "1234";
    
    Connection Conect = null;
    public Connection Conexion(String base) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String str = "jdbc:mysql://192.168.0.14:3306/" + base + "?zeroDateTimeBehavior=convertToNull"; //Ip Local Lenovo Mayra
           str = "jdbc:mysql://localhost:3306/" + base + "?zeroDateTimeBehavior=convertToNull"; //Ip maquina ACER JOSE
            Conect = DriverManager.getConnection(str, "root", "1234");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No hay Conexion!!");
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return Conect;
    }
   
    public Connection conexion(){
        try {
            con = null;
            
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);

           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexión a la base de datos");
            System.exit(0);
        }
        return con;
    }
   
    
    public void desconectar(){
        try {
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos");
        }
    }
      
    }


    
 