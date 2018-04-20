package Enemies;

import Game.Controller;
import Game.Game;
import Game.Boss;
import Game.Textures;
import Tools.EntityB;
import Tools.ListaDoble;
import Tools.ListaEnlazada;
import Tools.Timer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class EnemyB implements Wave {

    Textures tex;
    Game game;
    Controller c;
    Basic A;
    Random rand = new Random();
    public ListaDoble<EntityB> n = new ListaDoble<EntityB>();
    int r = rand.nextInt(6);
    int pos = r;

    private Timer delay = new Timer();

    public EnemyB (Textures tex, Controller c, Game game){
        this.tex = tex;
        this.game = game;
        this.c = c;
        A = new Basic(tex,c,game);
        this.changeList(A.e, n);
        this.setBoss();
    }

    public void setBoss(){
        Boss b = new Boss((n.get(pos).getX()),(n.get(pos).getY()), tex, 50,c,game);
        n.change(pos,b);
    }

    public void changeBoss(){
        //BufferedImage enemy = tex.enemy;
        //BufferedImage boss = tex.boss;
        if (n.getSize()==1){
            return;
        }
        int temp = rand.nextInt(n.getSize()-1);
        if (temp!=pos) {
            int l1 = this.n.get(pos).getLife();
            int l2 = this.n.get(temp).getLife();

            this.n.get(pos).relife(l2);
            this.n.get(temp).relife(l1);

            double a = this.n.get(temp).getX();
            double b = this.n.get(pos).getX();

            this.n.get(pos).changeX(a);
            this.n.get(temp).changeX(b);


            this.pos = temp;
        }else{
            return;
        }
    }

    public void changeList(ListaEnlazada<EntityB> e, ListaDoble<EntityB> n){
        for (int i = 0; i < (e.getSize());i++){
            n.add(e.get(i));
        }
    }

    EntityB ent;
    public void tick() {
        for (int i = 0; i < n.getSize(); i++){
            if (delay.delay(200)){
                this.changeBoss();
                //System.out.println("done");
            }

            ent = n.get(i);
            ent.tick();
        }
        //ent.tick();
    }

    public void render(Graphics g) {
        for (int i = 0; i < n.getSize(); i++) {
            ent = n.get(i);
            ent.render(g);
        }
    }

    @Override
    public void addEntity(EntityB block) {

    }


    @Override
    public ListaDoble<EntityB> getLista() {
        return n;
    }
}
