package Enemies;

import Game.Boss;
import Game.Controller;
import Game.Game;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaDoble;
import Tools.ListaEnlazada;

import java.awt.*;
import java.util.Random;

public class EnemyC extends EnemyA implements Wave {
    Textures tex;
    Game game;
    Controller c;
    Basic A;
    Random rand = new Random();
    public ListaDoble<EntityB> n = new ListaDoble<EntityB>();
    int r;
    public EnemyC(Textures tex, Controller c, Game game){
        super(tex,c,game);
        this.A = super.A;
        this.changeList(A.e,n);
    }



    EntityB ent;
    @Override
    public void tick() {
        for (int i = 0; i < n.getSize(); i++){
            if (n.get(i).getLife()==0) {
                n.removePos(i);
                if (i == r) {
                    r = rand.nextInt(n.getSize() - 1);
                    this.setBoss(r);
                }
            }
            ent = n.get(i);
            ent.tick();
        }
    }

    public void setBoss(int pos){
        Boss b = new Boss((n.get(pos).getX()),(n.get(pos).getY()), tex, 50,c,game);
        n.change(pos,b);
    }

    @Override
    public void render(Graphics g) {
        A.render(g);
    }

    @Override
    public void addEntity(EntityB block) {
    }

    public void changeList(ListaEnlazada<EntityB> e, ListaDoble<EntityB> n){
        for (int i = 0; i < (e.getSize());i++){
            n.add(e.get(i));
        }
    }
    public ListaEnlazada<EntityB> getLista(){
        return this.n;
    }

}
