package Tools;

import Game.Controller;
import Game.GameObject;
import Game.Textures;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface EntityB{
    public void tick();
    public void render(Graphics g);
    public void changeTex(BufferedImage style);
    public Rectangle getBounds();
    public void changeBounds(Rectangle boundy);

    public double getX();
    public double getY();
    public int getLife();
    public Controller getC();
    public Textures getTex();
    public boolean getBoss();
    public void changeX(double nuevo);
    public void relife(int nuevo);
}
