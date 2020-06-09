/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa;

/**
 *
 * @author Sony
 */
public class Cavallo implements Runnable{
    MyaCanvas canvas;
    String n_c;
    int end=0;
    public Cavallo(MyaCanvas c,String cavallo){
        canvas=c;
        n_c =cavallo;
    }

    
    public void run(){
        while(end<900){
            int vs=(int)(Math.random()*10);
            canvas.move(n_c,vs);
            int st=(int)(Math.random()*100);
            end+=vs;
            try{Thread.sleep(st);}catch(Exception e){}
        }
    }
    
    public String getNome() {
       return n_c;
   } 
}
