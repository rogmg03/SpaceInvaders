package Game;

import java.awt.*;
import java.util.Random;

public class Enemy implements Entity{

    private double x, y;
    private Textures tex;

    public Enemy(double x, double y, Textures tex){
         this.x = x;
         this.y = y;
         this.tex = tex;
         //Random rand = new Random();
         //tex.style= rand.nextInt(2)+5;
    }

    public void tick(){
        y += 0.5;

    }

    public void render(Graphics g){
        g.drawImage(tex.enemy, (int)x, (int)y, null);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }


}
