package Game;

import Tools.EntityB;
import Tools.Physics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Boss extends GameObject implements EntityB {

    private Textures tex;
    private int life;
    public Game game;
    public Controller c;
    public boolean isBoss;
    private Rectangle bound;

    public Boss(double x, double y, Textures tex, int life, Controller c, Game game) {
        super(x, y);
        this.tex = tex;
        this.life = life;
        this.c = c;
        this.game = game;
        this.isBoss = true;
    }

    public void tick(){
        y += 0.2;
        if (Physics.Collision(this, game.ea)){
            this.hit();
        }
        if (this.getLife()== 0){
            c.removeEntity(this);
            game.reload();
        }
    }

    public void render(Graphics g){
        g.drawImage(tex.boss, (int)x, (int)y, null);
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

    public void changeX(double nuevo){
        super.x = nuevo;
    }

    @Override
    public double getY() {
        return y;
    }

    public int getLife(){
        return this.life;
    }

    public boolean getBoss(){
        return true;
    }

    public Controller getC(){
        return c;
    }

    @Override
    public Textures getTex() {
        return this.tex;
    }

    public void changeTex(BufferedImage style){
        Textures.changeStyle(style);
    }

    public void hit(){
        this.life--;
    }

    public void relife(int nuevo){
        this.life = nuevo;
    }
}
