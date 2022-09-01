
package BaseImagen;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {
    
    public Connection conectar(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/crear";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root","root");
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return con;
    }
    
    public ResultSet visualizar(){
        Connection con = conectar();
        ResultSet rs = null;
        try{
            PreparedStatement ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
        }catch(Exception ex){
            System.out.println("Error de consulta");
        }
        return rs;
    }
    
    public void guardar(String ruta, String nombre){
        Connection con = conectar();
        String insert = "insert into persona(cedula,apellido,telefono ,foto) values(?,?,?,?,?,?,?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            File file = new File(ruta);
            fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);

            ps.setBinaryStream(1, fi);
            
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error al agregar usuario "+ex.getMessage());
        }
    }
    
}
