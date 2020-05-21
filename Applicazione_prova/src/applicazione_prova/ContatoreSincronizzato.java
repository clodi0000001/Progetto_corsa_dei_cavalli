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
public class ContatoreSincronizzato {
 private final int max;
    private int valoreCavallo = 0;
    
    public ContatoreSincronizzato(int max) {
        this.max = max;
    }
    public synchronized void incrementa() {
        if (valoreCavallo < max) {
            valoreCavallo++;
        }
        notifyAll();
    }
    
    public synchronized void attendiCompletamento() {
        while (valoreCavallo < max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } 
}
