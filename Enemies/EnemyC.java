package Enemies;

import Game.BossC;
import Game.Controller;
import Game.Game;
import Game.Textures;
import Tools.*;

import java.awt.*;
import java.util.Random;

import static Game.Game.lifeScale;

public class EnemyC /*extends EnemyA*/ implements Wave {
    Textures tex;
    Game game;
    Controller c;
    Basic A;
    Random rand;
    ListaCircular<EntityB> w = new ListaCircular<EntityB>();
    //int a = rand.nextInt(5);
    //int r = 3;

    int r = 3;


    public EnemyC (Textures tex, Controller c, Game game){
        //super(tex,c,game);
        this.tex = tex;
        this.c = c;
        this.game = game;
        A = new Basic(tex,c,game);
        this.changeList(A.e,w);
        this.setBoss();
        //this.r = super.r;

    }

    public void changeList(ListaEnlazada<EntityB> e, ListaCircular<EntityB> n){
        for (int i = 0; i <7 ;i++){
            System.out.println(i);
            EntityB temp = e.get(i);
            n.add(temp);
        }
    }

    EntityB enta;
    @Override
    public void tick()/* throws Exception */{
        for (int i = 0; i < w.getSize(); i++) {
            if (w.get(i).getLife() <= 0) {
                if (w.getSize() == 1) {
                    System.out.println("DONE1");
                    game.reload();
                } else if (w.getSize() > 1) {
                    if (w.get(i).getBoss()) {
                        System.out.println("DONE2");
                        r = rand.nextInt(w.getSize()-1);
                        //game.reload();
                        this.setBoss();
                    }
                }
            }
            enta = w.get(i);
            enta.tick();
        }
    }

    public void setBoss(){
        if(w.getSize()<1){
            game.reload();
        }else {
            r = (r + 3) % w.getSize();
            BossC b = new BossC((w.get(r).getX()), (w.get(r).getY()), tex, lifeScale * 50, c, game, this);
            w.change(r, b);
        }
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < w.getSize(); i++) {
            enta = w.get(i);
            enta.render(g);
        }
    }


    @Override
    public void addEntity(EntityB block) {
    }

    @Override
    public ListaEnlazada<EntityB> getLista() {
        return null;
    }

    @Override
    public ListaCircular<EntityB> getListaC() {
        return w;
    }


}