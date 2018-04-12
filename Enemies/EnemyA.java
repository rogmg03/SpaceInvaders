package Enemies;

import Game.Boss;
import Game.Controller;
import Game.Game;
import Tools.EntityA;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class EnemyA implements Wave {
    Textures tex;
    Game game;
    Controller c;
    Basic A;
    Random rand = new Random();
    int r = rand.nextInt(6);


    public EnemyA (Textures tex, Controller c, Game game){
        this.tex = tex;
        this.game = game;
        this.c = c;
        A = new Basic(tex,c,game);
        this.setBoss();
    }


    public void setBoss(){
        Boss b = new Boss((A.e.get(r).getX()),(A.e.get(r).getY()), tex, 50,c,game);
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
