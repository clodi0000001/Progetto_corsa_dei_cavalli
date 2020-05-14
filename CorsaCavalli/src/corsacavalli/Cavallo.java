/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsacavalli;

/**
 *
 * @author Sony
 */
public class Cavallo implements Runnable{
   private final String nome;
   private final static int METRI = 100;
   private final ContatoreSincronizzato pronti;
   private final Bang bang;
   
   public Cavallo(String nome, ContatoreSincronizzato pronti, Bang bang) {
    this.nome = nome;
    this.bang = bang;
    this.pronti = pronti;
   }
   @Override
   public void run() {
       int spazio = 0, posizione=0 ;
       try {
           while (spazio < METRI) {
               if (spazio == 0) {// E’ la prima iterazione
                   System.out.println(nome + " pronto a partire");
                   pronti.incrementa();
                   bang.attendiBang();
               } 
               spazio++;
               Thread.sleep(10);
               System.out.println(nome + " " + spazio + " metri");

           }
           System.out.println("Il cavallo " + nome + " e’ arrivato");
       } catch (InterruptedException err) {
           err.printStackTrace();
       }
   }
   
   public String getNome() {
       return nome;
   } 
}
