/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import com.fcrear.domain.Persona;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TapiaSoftware
 */
public class Tablas {

    static DefaultTableModel model;

    public static DefaultTableModel VaciarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        return modelo;
    }

    public static void cargarPersonas(List<Persona> lista, JTable Tabla) {
        int[] a = {10, 100, 52, 52, 52, 52, 52};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"Cedula", "Nombres y Apellidos", "Telefono", "Direccion", "Fecha", "Porcentaje", "Representante"};
        String[] Filas = new String[7];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getCedula();
            Filas[1] = lista.get(i).getApellido();
            Filas[2] = lista.get(i).getTelefono();
            Filas[3] = lista.get(i).getDireccion();
            Filas[4] = "" + lista.get(i).getFecha();
            Filas[5] = "" + lista.get(i).getPorcentaje();
            Filas[6] = lista.get(i).getRepresentante();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);

            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
        }

    }

    public static void filtro(String valor, JTable Tabla) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        Tabla.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + valor));
    }

    public static String getStringFecha(Date fecha) {
        if (fecha != null) {
            String cad[] = fecha.toString().split("-");
            return cad[2] + "/" + getStringMes(Integer.parseInt(cad[1])) + "/" + cad[0];
        } else {
            return "";
        }

    }

    public static String getStringMes(int mes) {

        String gui = null;

        if (mes == 1) {
            gui = "Enero";
        }
        if (mes == 2) {
            gui = "Febrero";
        }
        if (mes == 3) {
            gui = "Marzo";
        }
        if (mes == 4) {
            gui = "Abril";
        }
        if (mes == 5) {
            gui = "Mayo";
        }
        if (mes == 6) {
            gui = "Junio";
        }
        if (mes == 7) {
            gui = "Julio";
        }
        if (mes == 8) {
            gui = "Agosto";
        }
        if (mes == 9) {
            gui = "Septiembre";
        }
        if (mes == 10) {
            gui = "Octubre";
        }
        if (mes == 11) {
            gui = "Noviembre";
        }
        if (mes == 12) {
            gui = "Diciembre";
        }

        return gui;
    }

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
    
    public static int comparacionFecha(Date fecha1, Date fecha2) {
        int val = 0;
        try{
        val = fecha1.compareTo(fecha2);
        }catch(Exception e){
            
        }
        //  fecha 1 mayor a 2 = -1   // fecha 2 es mayor a fecha 1 = 1 // fecha 1 es igual es fecha 2 = 0
        return val;
    }
    
    public static Date FechaSql() {
        String dias = "" + Dia(), mes = "" + Mes();
        if (dias.length() == 1) {
            dias = "0" + dias;
        }
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        return java.sql.Date.valueOf("" + Anio() + "-" + mes + "-" + dias);
    }
    
    public static int Anio() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.YEAR);
    }

    public static int Mes() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.MONTH) + 1;
    }

    public static int Dia() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.DATE);
    }

}
