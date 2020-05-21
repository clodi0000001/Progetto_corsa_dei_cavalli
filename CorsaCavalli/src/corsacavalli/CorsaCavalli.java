/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsacavalli;
import java.lang.Thread;
import javax.swing.JOptionPane;
/**
 *
 * @author Sony
 */
public class CorsaCavalli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        boolean corretto = false;
        int numCavalli = 0;
        while (!corretto) {
            try {
                numCavalli = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il numero di cavalli"));
                if (numCavalli > 0)
                    corretto = true;
                else
                    JOptionPane.showMessageDialog(null, "Inserire un numero maggiore di 0!","Errore!", JOptionPane.ERROR_MESSAGE);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Inserire un numero intero!","Errore!", JOptionPane.ERROR_MESSAGE);
            }
        }
        ContatoreSincronizzato contatore = new ContatoreSincronizzato(numCavalli);
        Bang bang = new Bang();
        try {
            for (int i = 0; i < numCavalli; i++) {// fa partire tutti i corridori
            Thread t = new Thread(new Cavallo("cavallo " + i, contatore, bang));
            t.start();
        }
      // Attende che tutti i corridori siano pronti (cioe’ ciascuno e’
      // all’inizio della propria iterazione)
      contatore.attendiCompletamento();
      System.out.println("\n----- Cavalli pronti a partire -----\n");
      // Notifica a tutti i corridori che possono partire
      System.out.println("\n----- BANG! -----\n");
      Thread.sleep(300);// Solo per dare il tempo di leggere l’output
      bang.spara();
       }catch (InterruptedException e) {
      e.printStackTrace();
       }

    }
    
}
