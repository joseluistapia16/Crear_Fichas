/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcrear.dao;

import com.fcrear.domain.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Consultas {

    Connection conect = null;

    java.sql.Statement st = null;
    Conectar con = new Conectar();
    java.sql.Connection cn = con.conexion();
    Connection connMY = null;

    public List<Persona> allPersona(String base, String codsql) {
        List<Persona> lista = new ArrayList<Persona>();
        try {
            connMY = con.Conexion(base);
            Statement leer = cn.createStatement();
            ResultSet rs = leer.executeQuery(codsql);
            while (rs.next()) {
                Persona obj = new Persona(rs.getString("cedula"),
                        rs.getString("apellido"), rs.getString("telefono"), rs.getString("direccion"),
                        rs.getDate("fecha"), rs.getInt("porcentaje"), rs.getString("representante"), rs.getString("foto"),
                        rs.getString("foto_firma"));
                lista.add(obj);
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        return lista;
    }
}
