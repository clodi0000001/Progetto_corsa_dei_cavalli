/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
/**
 *
 * @author Sony
 */
public class MyaCanvas extends Canvas{
    Toolkit tk =Toolkit.getDefaultToolkit();
    Image img= tk.getImage("image/cavallo.gif");
    int d_c1=20,d_c2=20,d_c3=20,d_c4=20,d_c5=20,d_c6=20,d_c7=20,d_c8=20,d_c9=20;
    boolean win=false;
    Corsa corsa;
    
    
    public MyaCanvas(Corsa c){
        corsa=c;
    }

    public void paint(Graphics g){
        g.setColor(Color.white);//base di partenza
        g.fillRect(5,15,880,680);
           
        g.setColor(Color.GREEN);
        g.fillRect(90,15,880,680);
        
        g.setColor(Color.black); //barre sopra il verde
        g.fillRect(5,2,965,10);
        
        g.fillRect(5,75,965,10);
        g.fillRect(5,150,965,10);
        g.fillRect(5,220,965,10);
        g.fillRect(5,300,965,10);
        g.fillRect(5,380,965,10);
        g.fillRect(5,460,965,10);
        g.fillRect(5,540,965,10);
        g.fillRect(5,620,965,10);
        
        g.setColor(Color.BLACK);//barra di partenza
        g.fillRect(80,15,10,680);
        
        int h=0,l=0;
        boolean c=false;
        while(h<880){ //genera la bandiera a scacchi
            for(int i=0;i<5;i++){
                if(c==false){
                    g.setColor(Color.BLACK);
                    c=true;
                }else{
                    g.setColor(Color.WHITE);
                    c=false;
                }
                g.fillRect((880+l),(15+h),10,10);
                l+=10;
            }
            l=0;
            h+=10;
        }
        
        //immagine dei cavalli
        g.drawImage(img,d_c1,10,60,60,Color.RED,null);
        g.drawImage(img,d_c2,90,60,60,Color.ORANGE,this);
        g.drawImage(img,d_c3,160,60,60,Color.YELLOW,this);
        g.drawImage(img,d_c4,235,60,60,Color.GREEN,this);
        g.drawImage(img,d_c5,320,60,60,Color.CYAN,this);
        g.drawImage(img,d_c6,395,60,60,Color.BLUE,this);
        g.drawImage(img,d_c7,470,60,60,Color.MAGENTA,this);
        g.drawImage(img,d_c8,545,60,60,Color.PINK,this);
        g.drawImage(img,d_c9,545,60,60,Color.white,this);

    }
    public void move(String n_c,int a){
        for(int i=1;i<=a;i++){
            if(n_c.equals("cavallo1")){d_c1++;}
            if(n_c.equals("cavallo2")){d_c2++;}
            if(n_c.equals("cavallo3")){d_c3++;}
            if(n_c.equals("cavallo4")){d_c4++;}
            if(n_c.equals("cavallo5")){d_c5++;}
            if(n_c.equals("cavallo6")){d_c6++;}
            if(n_c.equals("cavallo7")){d_c7++;}
            if(n_c.equals("cavallo8")){d_c8++;}
            if(n_c.equals("cavallo8")){d_c9++;}
        }
        repaint();
        
        String win_n="";
        if(win==false){
            if(d_c1>=900){win=true;win_n="corsia 1";}
            if(d_c2>=900){win=true;win_n="corsia 2";}
            if(d_c3>=900){win=true;win_n="corsia 3";}
            if(d_c4>=900){win=true;win_n="corsia 4";}        
            if(d_c5>=900){win=true;win_n="corsia 5";}
            if(d_c6>=900){win=true;win_n="corsia 6";}
            if(d_c7>=900){win=true;win_n="corsia 7";}
            if(d_c8>=900){win=true;win_n="corsia 8";}
            if(d_c9>=900){win=true;win_n="corsia 8";}
            if(win==true){
                corsa.win(win_n);   
            }
        }
        
        
    }
}
