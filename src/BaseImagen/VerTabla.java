
package BaseImagen;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VerTabla {
    
public void visualizar_tabla(JTable tabla){
    Conexion conn = new Conexion();
    Connection con = conn.conectar();
    ResultSet rs = conn.visualizar();
    //Image img = null;   
    tabla.setDefaultRenderer(Object.class, new TablaImagen());
    DefaultTableModel dt = new DefaultTableModel();
    dt.addColumn("Nombre");
    dt.addColumn("Foto");
    
    try{
        
        while(rs.next()){
                Object[] fila = new Object[2];
                fila[0] = rs.getObject(2);
                
                Blob blob = rs.getBlob(3);

                if(blob != null){
                   try{
                        byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                        try{
                        img = ImageIO.read(new ByteArrayInputStream(data));
                        }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        }
                    ImageIcon icono = new ImageIcon(img);
                    fila[1] = new JLabel(icono);
                        }catch(Exception ex){
                            fila[1] = "No Imagen";
                        }
                }
                else{
                    fila[1] = "No Imagen";
                }
                
                dt.addRow(fila);  
            }
        
        tabla.setModel(dt);
        tabla.setRowHeight(64);
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();   
    }  
}
    
}
