/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicazione_prova;

/**
 *
 * @author Sony
 */
public class Bang {
    private boolean sparato = false;
    public synchronized void spara() {
        sparato = true;
        notifyAll();
    }
    public synchronized void attendiBang() {

        while (!sparato) {
            try { wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}
