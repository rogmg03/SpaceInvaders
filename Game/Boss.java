package Game;

import Tools.EntityA;
import Tools.EntityB;

import java.awt.*;

public class Boss extends Enemy implements EntityB {

    private double x, y;
    private int life;
    private Textures tex;

    public Boss(double x, double y, Textures tex, int life) {
        super(x, y, tex, life);
        this.x = x;
        this.y = y;
        this.tex = tex;
        this.life = life;
    }

    @Override
    public void tick() {
        y += 0.5;
    }

    public void render(Graphics g){
        g.drawImage(tex.boss, (int)x, (int)y, null);
    }

    public int getLife(){
        return this.life;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,128, 128);
    }
}
