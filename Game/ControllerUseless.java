/*package Game;

import Enemies.*;
import Tools.EntityA;
import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class ControllerUseless {

    private static ListaEnlazada <EntityA> ea = new ListaEnlazada<EntityA>();
    private static ListaEnlazada <EntityB> eb = new ListaEnlazada<EntityB>();
    Random r = new Random();

    Game game;
    EntityA enta;
    EntityB entb;
    Wave type;
    Textures tex;
    public static boolean function;
    int alpha;


    public ControllerUseless(Textures tex, Game game) {
        this.tex = tex;
        this.game = game;
        alpha=1;
    }


    public void enemyFactory (int level){
        if (level==1){
            this.createEnemy("Basic");
        }else if (level==2){
            this.createEnemy("EnemyA");
        }else if (level==3){
            this.createEnemy("EnemyB");
        }else if (level==4){
            this.createEnemy("EnemyA");
        }
        function = false;
    }


    public void createEnemy(String type){
        if (type.equals("Basic")){
            Basic wave = new Basic(tex,this,game);
            this.type = wave;
        } else if(type.equals("EnemyA")){
            EnemyA wave = new EnemyA(tex,this,game);
            this.type = wave;
        } else if(type.equals("EnemyB")){
            EnemyB wave = new EnemyB(tex,this,game);
            this.type = wave;
        } else if(type.equals("EnemyC")){
            EnemyC wave = new EnemyC(tex,this,game);
            this.type = wave;
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
    public void removeEntity(EntityA block) {
        ea.removeValue(block, false);
    }

    public void removeEntity(EntityB block){
        eb.removeValue(block,false);
    }

    public ListaEnlazada<EntityA> getEntityA() {
        return ea;
    }

    public ListaEnlazada<EntityB> getEntityB() {
        return eb;
    }
}
*/