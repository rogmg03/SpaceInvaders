package Game;

import java.awt.*;

public class Boss extends Enemy implements Entity {

    private double x, y;
    private Textures tex;

    public Boss(double x, double y, Textures tex) {
        super(x, y, tex);
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    @Override
    public void tick() {
        y += 0.5;
    }

    public void render(Graphics g){
        g.drawImage(tex.boss, (int)x, (int)y, null);
    }

}
