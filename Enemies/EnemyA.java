package Enemies;

import Game.Boss;
import Game.Enemy;
import Game.Entity;
import Game.Textures;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class EnemyA implements Entity{
    Textures tex;
    Basic A;
    Random rand = new Random();
    int r = rand.nextInt(6);
    public EnemyA (Textures tex){
        this.tex = tex;
        A = new Basic(tex);
    }


    public void setBoss(){
        Boss b = new Boss((A.e.get(r).getX()),(A.e.get(r).getY()), tex);
        A.e.change(r,b);
    }

    @Override
    public void tick() {
        A.tick();
    }

    @Override
    public void render(Graphics g) {
        A.render(g);
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }
}
