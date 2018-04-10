package Enemies;

import Game.Enemy;
import Game.Entity;
import Game.Game;
import Game.Textures;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class Basic implements Entity{


    public ListaEnlazada<Entity> e = new ListaEnlazada<Entity>();

    Textures tex;
    Random r = new Random();

    public Basic (Textures tex){
        this.tex=tex;
        for (int i = 0; i < 7; i++){
            addEntity(new Enemy(i*110, 10, tex));
        }
    }

    Entity ent;

    public void tick(){
        for (int i = 0; i < e.getSize(); i++){
            ent = e.get(i);

            ent.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < e.getSize(); i++) {
            ent = e.get(i);

            ent.render(g);
        }
    }

    public void addEntity (Entity block){
        e.add(block);
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
