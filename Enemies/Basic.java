package Enemies;

import Game.Controller;
import Game.Enemy;
import Game.Game;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

import static Game.Game.lifeScale;

public class Basic implements Wave {

    public ListaEnlazada<EntityB> e = new ListaEnlazada<EntityB>();

    Textures tex;
    Game game;
    EntityB ent;

    public Basic (Textures tex,Controller c, Game game){
        this.tex = tex;
        this.game = game;
        for (int i = 0; i < 7; i++){
            addEntity(new Enemy(i*110, 10, tex, lifeScale*10, c,game));
        }
    }

    public void tick(){

        for (int i = 0; i < e.getSize(); i++){
            if (e.get(i).getLife()<=0){
                if (e.getSize()==1){
                    game.reload();
                }else if (e.getSize()>1){
                    if(e.get(i).getBoss()){
                        game.reload();
                    }/*else {
                        e.removePos(i);
                    }*/
                }
            }
            ent = e.get(i);
            ent.tick();
        }
        System.out.println(e.getSize());
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
