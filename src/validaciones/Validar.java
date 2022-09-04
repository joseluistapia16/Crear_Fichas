/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import com.fcrear.dao.Consultas;
import com.fcrear.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Validar {

    Consultas consu = new Consultas();

    public boolean Celular(String cel) {
        boolean Celular;
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(cel);

        if (matcher.matches()) {

            Celular = true;
        } else {
            System.out.println("Numero Invalido");
            Celular = false;
        }
        return Celular;
    }

    public boolean validarCedula(String cedula, String base, String query) {
        boolean res = false;       
       List<Persona> lista = null;
        if (cedula.length() < 10) {
            res = false;
        } else {
            lista =    consu.allPersona(base, query);
            if (lista.size() < 1) {
                res = true;
            } else {
                lista.clear();
                JOptionPane.showMessageDialog(null, "Cedula ya existe!" );
                res = false;
            }

        }

        return res;
    }

    public boolean validarCorreo(String co) {
        boolean u;
        u = isEmail(co);
        return u;

    }

   private boolean isEmail(String valor) {
        return validar("^[\\w-\\.]+\\@[\\w\\.-]+\\.[a-z]{2,4}$", valor);
    }

    public boolean validar(String expReg, String valor) {
        Pattern patron = Pattern.compile(expReg);
        Matcher encajador = patron.matcher(valor);
        return encajador.matches();
    }

}
