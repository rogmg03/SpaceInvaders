package Game;

import Tools.EntityB;
import Tools.Physics;

import java.awt.*;
import java.awt.Rectangle;



public class Enemy extends GameObject implements EntityB {


    private Textures tex;
    private int life;
    private Game game;
    private Controller c;

    public Enemy(double x, double y, Textures tex, int life, Controller c, Game game){
        super(x,y);
        this.tex = tex;
        this.life = life;
        this.c = c;
        this.game = game;
    }

    public void tick(){
        y += 0.5;

        if (Physics.Collision(this, game.ea)){
            this.hit();
        }
        if (this.getLife()== 0){
            c.removeEntity(this);
        }

    }

    public void render(Graphics g){
        g.drawImage(tex.enemy, (int)x, (int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)this.getX(),(int)this.getY(),64,64);
    }

    /*@Override
    public Rectangle getBounds(int width, int height) {
        return new Rectangle((int)x,(int)y,width,height);
    }*/



    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public Controller getC(){
        return this.c;
    }

    public void hit(){
        this.life--;
    }

    public int getLife(){
        return this.life;
    }

}
