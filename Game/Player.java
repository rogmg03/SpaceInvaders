package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private double x;
    private double y;
    private double velX;
    private double velY;

    private Textures tex;

    /*
    private BufferedImage type;
    private BufferedImage player;
    private BufferedImage player1;
    private BufferedImage player2;
    */

    public Player(double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;

        //SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());

        //player = ss.grabImage(1,1,128,128);
        //player2 = ss.grabImage(2,1,128,128);
        //player1 = ss.grabImage(3,1,128,128);
        //type = player;
    }

    //Implementar factory
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
