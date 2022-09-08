/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneles;

import com.fcrear.dao.Conectar;
import com.fcrear.dao.Consultas;
import com.fcrear.dao.Crud;
import com.fcrear.domain.Persona;
import com.fcrear.inicio.Inicio;
import componentes.Tablas;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.*;
;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */


public class pnlDos extends javax.swing.JPanel {

    Conectar con = new Conectar();
    java.sql.Connection cn = con.conexion();
    List<Persona> lista = null;
    Consultas consu = new Consultas();
    Crud crd = null;
//    private Vector<Persona> vectorPersonas;
//    private DefaultTableModel modeloTablaPersonas;
//    

    public pnlDos() {
        crd = new Crud();
        initComponents();

        lista = consu.allPersona("crear", "select * from persona order by apellido");
        Tablas.cargarPersonas(lista, tabla_personas);
        // mostrarDatosPersona(0,null);

//        vectorPersonas = new Vector<Persona>();
//        modeloTablaPersonas = (DefaultTableModel) tabla_personas.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_personas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnSali = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 204, 88));

        jScrollPane1.setAutoscrolls(true);

        tabla_personas.setAutoCreateRowSorter(true);
        tabla_personas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        tabla_personas.setFont(new java.awt.Font("Louis George Cafe", 0, 14)); // NOI18N
        tabla_personas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_personas.setEditingRow(0);
        tabla_personas.setFillsViewportHeight(true);
        tabla_personas.setRowHeight(25);
        tabla_personas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_personasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_personas);

        jButton1.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/imprimir.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/imprimir.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/imprimir1.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSali.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        btnSali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/cerrar (3).png"))); // NOI18N
        btnSali.setText("Salir");
        btnSali.setContentAreaFilled(false);
        btnSali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSali.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/cerrar (3).png"))); // NOI18N
        btnSali.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/cerrar1.png"))); // NOI18N
        btnSali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaliActionPerformed(evt);
            }
        });

        nuevo.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/nuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setContentAreaFilled(false);
        nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/nuevo.png"))); // NOI18N
        nuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/nuevo1.png"))); // NOI18N
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoMouseClicked(evt);
            }
        });
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 204, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Louis George Cafe", 0, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        campoBuscar.setFont(new java.awt.Font("Louis George Cafe", 0, 18)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButton/recargar.png"))); // NOI18N
        btnBuscar.setText("Refrescar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSali, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaliActionPerformed
        // TODO add your handling code here:
        Window w = SwingUtilities.getWindowAncestor(pnlDos.this);
        w.setVisible(true);
        Inicio form = new Inicio();
        form.setVisible(true);
    }//GEN-LAST:event_btnSaliActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        pnlTres panel3 = new pnlTres();
        panel3.setSize(745, 564);
        panel3.setLocation(0, 0);
        Inicio.pnlPrincipal.removeAll();
        Inicio.pnlPrincipal.add(panel3);
        Inicio.pnlPrincipal.revalidate();
        Inicio.pnlPrincipal.repaint();
    }//GEN-LAST:event_nuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        campoBuscar.setText("");
        lista = consu.allPersona("crear", "select * from persona order by apellido");
        Tablas.cargarPersonas(lista, tabla_personas);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabla_personasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_personasMousePressed
        int i = 0;
        try {
            if (evt.getClickCount() == 2) {
                i = tabla_personas.getSelectedRow();
                Persona obj = devuelveObjeto(tabla_personas.getValueAt(i, 0).toString(), lista);
                if (obj != null) {
                    EditPerson gh = new EditPerson(obj, new javax.swing.JFrame(), true);
                    gh.setVisible(true);
                    lista.clear();
                    campoBuscar.setText("");
                    lista = consu.allPersona("crear", "select * from persona order by apellido");
                    Tablas.cargarPersonas(lista, tabla_personas);
                    // System.out.println(obj.getCedula());
                }

            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tabla_personasMousePressed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        String ced = campoBuscar.getText();
        Tablas.filtro(ced, tabla_personas);
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked

    }//GEN-LAST:event_nuevoMouseClicked
public void imprimirPdf() {
        var msg = crd.generarpdf("crear");
        JOptionPane.showMessageDialog(null, msg);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimirPdf();
    }//GEN-LAST:event_jButton1ActionPerformed
    public Persona devuelveObjeto(String cedula, List<Persona> listaobj) {
        Persona objeto1 = null;
        for (int i = 0; i < listaobj.size(); i++) {
            if (cedula.equals(listaobj.get(i).getCedula())) {
                objeto1 = listaobj.get(i);
                break;
            }
        }
        return objeto1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSali;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla_personas;
    // End of variables declaration//GEN-END:variables
}
