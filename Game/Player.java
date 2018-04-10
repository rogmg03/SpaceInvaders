package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private double velX;
    private double velY;

    private Textures tex;


    public Player(double x, double y, Textures tex){
        super(x,y);
        this.tex = tex;

    }

    public void tick(){
        x += velX;
        y += velY;

        if (x<0)
            x=0;
        if (x>670)
            x=670;
    }

    public void render(Graphics g){
        g.drawImage(tex.type,(int)x,(int)y,null);
    }

    //###########Getter y Setters#############

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public void setVelX (double velX){
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    /*public void changeType(String side){
        if (side == "LEFT"){
            type = player1;
        } else if (side == "RIGHT") {
            type = player2;
        } else if (side == "NORMAL"){
            type = player;
        }
    }*/



}
