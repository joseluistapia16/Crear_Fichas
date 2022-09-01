/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcrear.dao;

import com.fcrear.dao.Conectar;
import com.fcrear.domain.Persona;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author USER
 */

public class Crud {
    Conectar con = new Conectar();
    Connection conect = null;
    ResultSet rs;
    java.sql.Statement st = null;
    public String guardar(String base, Persona obj) {
        var msg="";
        try {
            String sql = "INSERT INTO persona (cedula,apellido,telefono,direccion,fecha,porcentaje,representante,foto,foto_firma) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            conect=con.Conexion(base);
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setString(1, obj.getCedula());
            statement.setString(2, obj.getApellido());
            statement.setString(3, obj.getTelefono());
            statement.setString(4, obj.getDireccion());
            statement.setDate(5, obj.getFecha());
            statement.setInt(6, obj.getPorcentaje());
            statement.setString(7,obj.getRepresentante());
            statement.setString(8, obj.getFoto());
            statement.setString(9,obj.getFoto_firma());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               msg="LOS DATOS HAN SIDO GUARDADO CON EXITO!";
            }else{
                 msg="NO SE HAN GUARDADO LOS DATOS!";
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    
    public String eliminar(String base, Persona obj) {
        var msg="";
        try {
            String sql = "delete from persona where cedula=?";
                conect=con.Conexion(base);
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setString(1, obj.getCedula());
            int resultado = statement.executeUpdate();
            if (resultado > 0) {
               msg="LOS DATOS HAN SIDO ELIMINADOS CON EXITO!";
            }else{
                 msg="NO SE HAN GUARDADO LOS DATOS!";
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    public String editar(String base, Persona obj) {
        var msg="";
        try {
            String sql = "UPDATE persona SET apellido=?,telefono=?,direccion=?, fecha=?, porcentaje=?, representante=?, foto=?, foto_firma=?"
                    + "WHERE cedula=?";
            conect=con.Conexion(base);
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setString(1, obj.getApellido());
            statement.setString(2, obj.getTelefono());
            statement.setString(3, obj.getDireccion());
            statement.setDate(4, obj.getFecha());
            statement.setInt(5, obj.getPorcentaje());
            statement.setString(6,obj.getRepresentante());
            statement.setString(7, obj.getFoto());
            statement.setString(8,obj.getFoto_firma());
            statement.setString(9, obj.getCedula());
        
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               msg="LOS DATOS HAN SIDO EDITADOS CON EXITO!";
            }else{
                 msg="NO SE HAN EDITADO LOS DATOS!";
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    

}



