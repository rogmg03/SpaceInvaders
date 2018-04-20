package Game;

import Tools.EntityA;
import Tools.Nodo;
import Tools.Physics;
import Tools.Timer;

import java.awt.*;

public class Bullet extends GameObject/*Nodo<Bullet>*/ implements EntityA {

    private int life;
    private Textures tex;
    private Game game;

    public Bullet(double x, double y, Textures tex, Game game){
        super(x,y);
        this.tex = tex;
        this.game = game;
        this.life = 1;
    }


    public void tick(){
        y-=10;

        if (Physics.Collision(this, game.eb)){
            System.out.println("SHOOT");
            this.life--;
            //removeBullet();
        }

    }

    public void removeBullet(){
        super.y = -100;
    }

    public void render(Graphics g){
        g.drawImage(tex.image,(int)x,(int)y,null);
    }

    public Rectangle getBounds() {
        return super.getBounds(32,32);
    }

    //###########Getter y Setters#############
    public int getLife(){
        return this.life;
    }
    public double getX(){
            return x;
        }
    public double getY(){
            return y;
    }
    public void hit(){
        this.life--;
    }
    public void setX(double x){
            this.x = x;
        }
    public void setY(double y){
            this.y = y;
        }
}
