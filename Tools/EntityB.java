package Tools;

import Game.Controller;
import Game.GameObject;

import java.awt.*;

public interface EntityB{
    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();

    public double getX();
    public double getY();
    public int getLife();
    public Controller getC();
}
