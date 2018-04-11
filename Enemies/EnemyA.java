package Enemies;

import Game.Boss;
import Tools.EntityA;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class EnemyA implements Wave {
    Textures tex;
    Basic A;
    Random rand = new Random();
    int r = rand.nextInt(6);
    public EnemyA (Textures tex){
        this.tex = tex;
        A = new Basic(tex);
    }


    public void setBoss(){
        Boss b = new Boss((A.e.get(r).getX()),(A.e.get(r).getY()), tex, 3);
        A.e.change(r,b);
    }

    public ListaEnlazada<EntityB> getLista(){
        return A.e;
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
    public void addEntity(EntityB block) {
    }

}
