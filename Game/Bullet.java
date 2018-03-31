package Game;

import Tools.Nodo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends Nodo<Bullet>{

    private double x;
    private double y;
    private BufferedImage image;


    public Bullet(double x, double y, Game game){
        this.x = x;
        this.y = y;

        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        image = ss.grabImage(4,1,128,128);
    }


    public void tick(){
        y-=10;
        }

    public void render(Graphics g){
            g.drawImage(image,(int)x,(int)y,null);
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
}
