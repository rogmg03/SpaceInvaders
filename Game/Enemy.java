package Game;

import Tools.EntityB;
import java.awt.*;
import java.awt.Rectangle;

public class Enemy extends GameObject implements EntityB {


    private Textures tex;
    private int life;

    public Enemy(double x, double y, Textures tex, int life){
        super(x,y);
        this.tex = tex;
        this.life = life;
    }

    public void tick(){
        y += 0.5;

    }

    public void render(Graphics g){
        g.drawImage(tex.enemy, (int)x, (int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)this.getX(),(int)this.getY(),128,128);
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

    public void hit(){
        this.life--;
    }

    public int getLife(){
        return this.life;
    }

}
