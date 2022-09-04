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
            lista = consu.allPersona(base, query);
            if (lista.size() < 1) {
                res = true;
            } else {
                lista.clear();
                JOptionPane.showMessageDialog(null, "Cedula ya existe!");
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

    public String validateForm(Persona obj) {
        String msg = "";
        if (validateString(obj.getApellido()) == null) {
            msg = msg + "Apellido ";
        }
        if (validateString(obj.getTelefono()) == null) {
            msg = msg + "Telefono ";
        }
        if (validateString(obj.getDireccion()) == null) {
            msg = msg + "Direccion ";
        }
        if (validateString("" + obj.getFecha()) == null) {
            msg = msg + "Fecha ";
        }
        if (validateString("" + obj.getPorcentaje()) == null) {
            msg = msg + "Porcentaje ";
        }
        if (validateString(obj.getRepresentante()) == null) {
            msg = msg + "Representante ";
        }
        if (validateString(obj.getFoto()) == null) {
            msg = msg + "Foto ";
        }
        if (validateString(obj.getFoto_firma())== null) {
            msg = msg + "Firma ";
        }
        return msg;
    }
        public String validateForm(String obj[]) {
        String msg = "";
        if (validateString(obj[0]) == null) {
            msg = msg + "Apellido ";
        }
        if (validateString(obj[1]) == null) {
            msg = msg + "Telefono ";
        }
        if (validateString(obj[2]) == null) {
            msg = msg + "Direccion ";
        }
        if (validateString(obj[3]) == null) {
            msg = msg + "Fecha ";
        }
        if (validateString(obj[4]) == null) {
            msg = msg + "Porcentaje ";
        }
        if (validateString(obj[5]) == null) {
            msg = msg + "Representante ";
        }
        if (validateString(obj[6]) == null) {
            msg = msg + "Foto ";
        }
        if (validateString( obj[7])== null) {
            msg = msg + "Firma ";
        }
        return msg;
    }

    public String validateString(String valor) {
        var cad = valor.trim();
        if (cad.length() < 1 || cad == null) {
            cad = null;
        }
        return cad;
    }

}
