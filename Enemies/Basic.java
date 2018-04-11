package Enemies;

import Game.Enemy;
import Game.GameObject;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class Basic implements Wave {


    public ListaEnlazada<EntityB> e = new ListaEnlazada<EntityB>();

    Textures tex;
    Random r = new Random();

    public Basic (Textures tex){
        this.tex=tex;
        for (int i = 0; i < 7; i++){
            addEntity(new Enemy(i*110, 10, tex, 1));
        }
    }

    EntityB ent;

    public void tick(){
        for (int i = 0; i < e.getSize(); i++){
            ent = e.get(i);
            ent.tick();

            if (e.get(i).getLife()==0){
                e.removePos(i);
            }
        }

    }

    public void render(Graphics g) {
        for (int i = 0; i < e.getSize(); i++) {
            ent = e.get(i);

            ent.render(g);
        }
    }


    public void addEntity (EntityB block){
        e.add(block);
    }

    public ListaEnlazada<EntityB> getLista(){
        return this.e;
    }

}
