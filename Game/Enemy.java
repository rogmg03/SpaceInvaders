package Game;

import Tools.EntityB;
import Tools.Physics;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Enemy extends GameObject implements EntityB {


    private Textures tex;
    private int life;
    private Game game;
    private Controller c;
    private Random rand;
    private Rectangle bound;
    private int tipo;

    //private boolean isBoss;

    public Enemy(double x, double y, Textures tex, int life, Controller c, Game game){
        super(x,y);
        this.tex = tex;
        this.life = life;
        this.c = c;
        this.game = game;
        //this.isBoss = false;
    }

    public void tick(){
        y += 0.2;

        if (Physics.Collision(this, game.ea)){
            this.hit();
        }
        if (this.getLife()== 0){
            c.removeEntity(this);
        }
    }

    public void render(Graphics g){
        g.drawImage(/*randomTex()*/this.tex.enemy, (int)x, (int)y, null);
    }

    private BufferedImage randomTex(){
        int a = rand.nextInt(1)+1;
        //tipo =
        if (a==1){
            return this.tex.enemy2;
        }else if (a==2){
            return this.tex.enemy3;
        }else{
        return this.tex.enemy;}
    }

    @Override
    public Rectangle getBounds() {
        this.bound = new Rectangle((int)this.getX(),(int)this.getY(),64,64);
        return bound;
    }

    public void changeBounds(Rectangle boundy){
        this.bound = boundy;
    }

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

    @Override
    public Textures getTex() {
        return this.tex;
    }

    public void hit(){
        this.life--;
    }

    public int getLife(){
        return this.life;
    }

    public void changeTex(BufferedImage style){
        Textures.changeStyle(style);
    }

    public boolean getBoss(){
        return false;
    }

    public void changeX(double nuevo){
        super.x = nuevo;
    }

    public void relife(int nuevo){
        this.life = nuevo;
    }
}
