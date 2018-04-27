package Game;

import Enemies.*;
import Tools.*;

import java.util.Random;
import java.awt.*;

public class Controller {

    public static ListaEnlazada <EntityA> ea = new ListaEnlazada<EntityA>();
    public static Lista<EntityB> eb = new ListaEnlazada<EntityB>();

    Random r = new Random();

    Game game;
    EntityA enta;
    EntityB entb;
    Wave type;
    Textures tex;


    public Controller(Textures tex, Game game) {
        this.tex = tex;
        this.game = game;
    }

    public void createEnemy(int type){
        if (type==1){
            Basic waveb = new Basic(tex,this,game);
            this.type = waveb;
            update(this.type.getLista());
        }else if(type==2){
            EnemyA waveA = new EnemyA(tex, this, game);
            this.type = waveA;
            update(this.type.getLista());
        }else if(type==4){
            EnemyB waveB = new EnemyB(tex,this,game);
            this.type = waveB;
            update(this.type.getLista());
        }else if(type==3){
            EnemyC waveC = new EnemyC(tex,this,game);
            this.type = waveC;
            update(this.type.getListaC());
        }
    }

    public void update(ListaEnlazada<EntityB> lista){
        eb = lista;
    }

    public void update(ListaCircular<EntityB> lista){
        eb = lista;
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
        this.type.tick();
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
        this.type.render(g);
    }

    public void addEntity (EntityA block ){
        ea.add(block);
    }

    public void addEntity(EntityB block){
        eb.add(block);
    }

    public void removeEntity(EntityA block) {
        ea.removeValue(block, false);
    }

    public void removeEntity(EntityB block){
        eb.removeValue(block,false);
    }

    public ListaEnlazada<EntityA> getEntityA() {
        return ea;
    }

    public Lista<EntityB> getEntityB() {
        return eb;
    }
}