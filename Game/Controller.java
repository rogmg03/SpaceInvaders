package Game;

import Enemies.Basic;
import Enemies.EnemyA;
import Enemies.Wave;
import Tools.EntityA;
import Tools.EntityB;
import Tools.ListaEnlazada;
import java.util.Random;
import java.awt.*;

public class Controller {

    private static ListaEnlazada <EntityA> ea = new ListaEnlazada<EntityA>();
    private static ListaEnlazada <EntityB> eb = new ListaEnlazada<EntityB>();
    Random r = new Random();


    EntityA enta;
    EntityB entb;
    Wave type;
    Game game;
    Textures tex;
    public Controller(Textures tex) {
        this.tex = tex;
    }

    public void createEnemy(String type){
        if (type.equals("Basic")){
            Basic wave = new Basic(tex);
            this.type = wave;
        } else if(type.equals("EnemyA")){
            EnemyA wave = new EnemyA(tex);
            this.type = wave;
            wave.setBoss();
        }
        this.eb = this.type.getLista();
    }

    public void tick(){
        //A class
        for (int i = 0; i < ea.getSize(); i++){
            enta = ea.get(i);
            enta.tick();
        }

        //B class
        for (int i = 0; i < eb.getSize(); i++){
            entb = eb.get(i);
            entb.tick();
        }


        type.tick();
    }

    public void render(Graphics g) {
        for (int i = 0; i < ea.getSize(); i++) {
            enta = ea.get(i);
            enta.render(g);
        }

        for (int i = 0; i < eb.getSize(); i++) {
            entb = eb.get(i);
            entb.render(g);
        }



        type.render(g);
    }

    public void addEntity (EntityA block ){
        ea.add(block);
    }
    public void addEntity(EntityB block){
        eb.add(block);
    }
    private void removeEntity(EntityA block) {
        ea.removeValue(block, false);
    }

    private void removeEntity(EntityB block){
        eb.removeValue(block,false);
    }

    public ListaEnlazada<EntityA> getEntityA() {
        return ea;
    }

    public ListaEnlazada<EntityB> getEntityB() {
        return eb;
    }
}
