/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcrear.dao;

import com.fcrear.dao.Conectar;
import com.fcrear.domain.Persona;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

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
   /* 
    public String generarpdf(String base) {
        Document documento = new Document();
        var msg = "";
        try {

            //String ruta = System.getProperty("user.home");
           // System.out.println("rutita " + ruta);
            PdfWriter.getInstance(documento, new FileOutputStream("\\Fichas Crear\\reportes\\ReporteCrear.pdf"));
            //Orientación de la página:
            documento.setPageSize(PageSize.A4.rotate());
            //Ruta de la imagen del Encabezado:
            Image header = Image.getInstance("\\Fichas Crear\\img\\header.png");
            //Alineación y Tamaño de la imagen del encabezado
            header.scaleToFit(600, 2000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Alineacion de los párrafos
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            //Contenido del párrafo
            parrafo.add("Juntos por la Inclusión\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.ORANGE));
            parrafo.add("Beneficiarios Registrados \n\n");
            //Contenido de la firma del responsable
            Paragraph firma = new Paragraph();
            firma.setAlignment(Paragraph.ALIGN_CENTER);
            firma.add("\n\n");
            firma.add("_____________________________\n");
            firma.add("Firma Responsable");
            firma.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));

            documento.open();

            //Orden de los elementos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(7);
            //TAMAÑO DE LAS COLUMNAS INDIVIDUAL
            tabla.setWidths(new int[]{4, 6, 4, 8, 4, 4, 6});
            tabla.setWidthPercentage(100); //TAMAÑO COLUMNAS GENERAL
            tabla.setSpacingBefore(0f);
            tabla.setSpacingAfter(0f);

            tabla.addCell("Cédula");
            tabla.addCell("Nombres Completos");
            tabla.addCell("Teléfono");
            tabla.addCell("Dirección");
            tabla.addCell("Fecha de Nacimiento");
            tabla.addCell("Porcentaje Discapacidad");
            tabla.addCell("Nombre Representante");

            try {
                String sql = "SELECT cedula, apellido, telefono, direccion, fecha, porcentaje, representante FROM persona";
                conect = con.Conexion(base);
                PreparedStatement statement = conect.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    msg = "REPORTE CREADO!";
                    do {

                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());

                    documento.add(tabla);
                    documento.add(firma);
                }

            } catch (DocumentException | SQLException e) {
                System.out.println("Error en la conexión ");
            }
            documento.close();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("Error al crear el pdf " + e);
            msg=""+e;
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println("Error en la Imagen");
        }
        return msg;
    }
*/
    
    public String generarpdf(JTable tabla1) {
        var msg = "";
        try {
            Document documento = new Document();

            //String ruta = System.getProperty("user.home");
            // System.out.println("rutita " + ruta);
            PdfWriter.getInstance(documento, new FileOutputStream("\\Fichas Crear\\reportes\\ReporteCrear.pdf"));
            //Orientación de la página:
            documento.setPageSize(PageSize.A4.rotate());
            //Ruta de la imagen del Encabezado:
            Image header = Image.getInstance("\\Fichas Crear\\img\\header.png");
            //Alineación y Tamaño de la imagen del encabezado
            header.scaleToFit(600, 2000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Alineacion de los párrafos
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            //Contenido del párrafo
            parrafo.add("Juntos por la Inclusión\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.ORANGE));
            parrafo.add("Beneficiarios Registrados \n\n");
            //Contenido de la firma del responsable
            Paragraph firma = new Paragraph();
            firma.setAlignment(Paragraph.ALIGN_CENTER);
            firma.add("\n\n");
            firma.add("_____________________________\n");
            firma.add("Firma Responsable");
            firma.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));

            documento.open();

            //Orden de los elementos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(7);
            //TAMAÑO DE LAS COLUMNAS INDIVIDUAL
            tabla.setWidths(new int[]{4, 6, 4, 8, 4, 4, 6});
            tabla.setWidthPercentage(100); //TAMAÑO COLUMNAS GENERAL
            tabla.setSpacingBefore(0f);
            tabla.setSpacingAfter(0f);

            tabla.addCell("Cédula");
            tabla.addCell("Nombres Completos");
            tabla.addCell("Teléfono");
            tabla.addCell("Dirección");
            tabla.addCell("Fecha de Nacimiento");
            tabla.addCell("Porcentaje Discapacidad");
            tabla.addCell("Nombre Representante");

            msg = "REPORTE CREADO!";
            for (int i = 0; i < tabla1.getRowCount(); i++) {
                tabla.addCell("" + tabla1.getValueAt(i, 0));
                tabla.addCell("" + tabla1.getValueAt(i, 1));
                tabla.addCell("" + tabla1.getValueAt(i, 2));
                tabla.addCell("" + tabla1.getValueAt(i, 3));
                tabla.addCell("" + tabla1.getValueAt(i, 4));
                tabla.addCell("" + tabla1.getValueAt(i, 5));
                tabla.addCell("" + tabla1.getValueAt(i, 6));
            }
            documento.add(tabla);
            documento.add(firma);
            documento.close();

            return msg;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    
}



