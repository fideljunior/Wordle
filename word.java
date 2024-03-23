import java.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class word{
    private int x, y, w, l;
    private Color cl;
    private char c;

    public word() {
        x=0;
        y=0;
        w=10;
        l=10;
        cl= Color.BLUE;
        c=65;
    }

    public word (int xl, int yl, int ll, int wl){
        x=xl;
        y=yl;
        w=wl;
        l=ll;
        cl=Color.BLUE;
        c=33;
    }

    public word(int xl, int yl, int, ll, int wl, char nc, Color cll){
        x=xl;
        y=yl;
        w=wl;
        l=ll;
        cl=cll;
        c=nc;
    }


    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public int getLength(){
        return l;
    }

    public int getWidth(){
        return w;
    }

    public char getChar(){
        return c;
    }

    public Color getColor(){
        return cl;
    }


    public void setx(int xl){
        x=xl;
    }

    public void sety(int yl){
        y=yl;
    }

    public void setl(int ll){
        l=ll;
    }

    public void setw(int wl){
        w=wl;
    }

    public void setChar(char nc){
        c=nc;
    }

    public void setColor(Color cll){
        cl=cll;
    }

    
}