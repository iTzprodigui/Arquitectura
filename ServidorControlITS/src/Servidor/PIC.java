package Servidor;

import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author to2
 */
public class PIC {
    Com com2;
    Parameters settings;
    
    public void configurar(String Com){
        try {
            settings = new Parameters();
            settings.setPort(Com);
            settings.setBaudRate(Baud._9600);
            settings.setMinDelayWrite(10);

            com2 = new Com(settings);
            JOptionPane.showMessageDialog ( null,"RS232: STATUS: DISPONIBLE" );
        } catch (Exception ex) {
            Logger.getLogger(PIC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviar(String resultado){
        try {
            com2.sendString(String.valueOf(resultado));
            System.out.println(resultado);
            
        } catch (Exception ex) {
            Logger.getLogger(PIC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
