package Game;

import Enemies.Basic;
import Enemies.EnemyA;
import Tools.ListaEnlazada;
import java.util.Random;
import java.awt.*;

public class Controller {

    private ListaEnlazada <Entity> e = new ListaEnlazada<Entity>();

    Random r = new Random();


    Game game;
    Textures tex;
    private Entity type;
    public Controller(Textures tex, String type) {
        if (type.equals("Basic")){
            Basic wave = new Basic(tex);
            this.type = wave;
        } else if(type.equals("EnemyA")){
            EnemyA wave = new EnemyA(tex);
            this.type = wave;
            wave.setBoss();
        }
    }

    Entity ent;

    public void tick(){
        for (int i = 0; i < e.getSize(); i++){
            ent = e.get(i);
            ent.tick();
        }
        type.tick();
    }

    public void render(Graphics g) {
        for (int i = 0; i < e.getSize(); i++) {
            ent = e.get(i);

            ent.render(g);
        }
        type.render(g);
    }

    public void addEntity (Entity block){
            e.add(block);
        }
    private void removeEntity(Enemy block){
            e.removeValue(block,false);
        }

}
