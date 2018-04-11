package Game;

import Tools.EntityA;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements EntityA{

    private double velX;
    private double velY;
    private int life;
    private Textures tex;


    public Player(double x, double y, Textures tex){
        super(x,y);
        this.tex = tex;
        this.life = 1;
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

    @Override
    public Rectangle getBounds() {
        return null;
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

    public void setVelX (double velX){
        this.velX = velX;
    }

    public int getLife(){
        return this.life;
    }
}
