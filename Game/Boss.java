package Game;

import Tools.EntityA;
import Tools.EntityB;
import Tools.Physics;

import java.awt.*;

public class Boss extends GameObject implements EntityB {

    private Textures tex;
    private int life;
    private Game game;
    private Controller c;

    public Boss(double x, double y, Textures tex, int life, Controller c, Game game) {
        super(x, y);
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
        g.drawImage(tex.boss, (int)x, (int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)this.getX(),(int)this.getY(),64,64);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public int getLife(){
        return this.life;
    }

    public Controller getC(){
        return c;
    }

    public void hit(){
        this.life--;
    }
}
