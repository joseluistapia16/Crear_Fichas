/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fcrear.domain;
//import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author USER
 */
public class Persona {  /*implements Serializable*/
    //private Long id_persona;
    private String cedula;
    private String apellido;
    private String telefono;
    private String direccion;
    private Date fecha;
    private int porcentaje;
    private String representante;
    private String foto;
    private String foto_firma;


    public Persona(String cedula) {
       this.cedula = cedula;
    }

    

    public Persona(String cedula, String apellido, String telefono, String direccion, Date fecha, int porcentaje, String representante, String foto, String foto_firma) {
        this.cedula = cedula;
        this.apellido = apellido;
       this.telefono = telefono;
       this.direccion = direccion;
       this.fecha = fecha;
       this.porcentaje = porcentaje;
       this.representante = representante;
        this.foto = foto;
        this.foto_firma = foto_firma;
    }


    
    public Persona(String cedula1, String apellido1, String telefono1, String direccion1, Date fecha_nacimiento, int porcentaje, String representante, String foto1) {
       this.cedula = cedula1;
        this.apellido = apellido1;
        this.telefono = telefono1;
        this.direccion = direccion1;
        this.fecha = fecha_nacimiento;
        this.porcentaje = porcentaje;
        this.representante = representante;
        this.foto = foto1;
       
    }
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto_firma() {
        return foto_firma;
    }

    public void setFoto_firma(String foto_firma) {
        this.foto_firma = foto_firma;
    }
    
    

    }
