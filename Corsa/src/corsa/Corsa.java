/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Sony
 */
public class Corsa extends JFrame implements ActionListener {

    MyaCanvas canvas=new MyaCanvas(this);
    JButton start=new JButton("BANG");
    JLabel count=new JLabel("     ");
    JPanel pan=new JPanel();
    
    Cavallo c1,c2,c3,c4,c5,c6;
    
    public Corsa(){
        add(canvas,"Center");
        add(pan,"South");
        pan.add(start);
        pan.add(count);
        canvas.repaint();
        
        start.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Corsa dei cavalli");
        setSize(990,690);
        setLocation(15,139);
        setVisible(true);
        show();
    }
    
    public void actionPerformed(ActionEvent e){
        boolean corretto = false;        
        int numCavalli = 0;
        while (!corretto) {
            try {
                numCavalli = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il numero di cavalli"));
                if (numCavalli > 0)
                    corretto = true;
                else{
                    JOptionPane.showMessageDialog(null, "Inserire un numero maggiore di 0!","Errore!", JOptionPane.ERROR_MESSAGE);}
                if(numCavalli > 8){
                    JOptionPane.showMessageDialog(null, "Inserire un numero minore di 8!","Errore!", JOptionPane.ERROR_MESSAGE);}
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Inserire un numero intero!","Errore!", JOptionPane.ERROR_MESSAGE);
            }
        }

         Thread []cavalli = new Thread[numCavalli];
            for (int i = 1; i <= numCavalli; i++) {// fa partire tutti i corridori
             cavalli[i] = new Thread(new Cavallo(canvas,"cavallo"+i));
             cavalli[i].start();
        }
         try{Thread.sleep(100);}catch(Exception ex){}
         count.setText("GOOOO!!!");
         for (int i = 1; i <= numCavalli; i++) {
             cavalli[i].start();
         }
    }

       
    public void win(String win_n){
        JOptionPane.showMessageDialog(null,"Ha vinto il cavallo della "+win_n+"!!!",
                    "MESSAGGIO:", JOptionPane.ERROR_MESSAGE);   
    }
}
  

