/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JOptionPane1 {

    private static JOptionPane option = new JOptionPane("",
            JOptionPane.INFORMATION_MESSAGE);

    private static JDialog dialogo = null;

    /**
     * Solo hace caso a padre la primera vez que se llama a este método. La
     * llamada a este metodo se queda bloqueada hasta que el usuario cierra el
     * JOptionPane o pasa el timeout.
     *
     * @param padre
     * @param texto
     * @param titulo
     * @param timeout En mili segundos
     */
    public static void visualizaDialogo(Component padre, String texto,
            String titulo, final long timeout) {
        option.setMessage(texto);
        if (null == dialogo) {
            dialogo = option.createDialog(padre, titulo);
        } else {
            dialogo.setTitle(titulo);
        }

        Thread hilo = new Thread() {
            public void run() {
                try {
                    Thread.sleep(timeout);
                    if (dialogo.isVisible()) {
                        dialogo.setVisible(false);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();

        dialogo.setVisible(true);
    }
}
