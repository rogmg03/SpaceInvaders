package Game;

import Tools.ListaEnlazada;

import java.awt.*;

public class Controller {

    private ListaEnlazada <Bullet> b = new ListaEnlazada<Bullet>();

    Bullet TempBullet;

    Game game;

    public Controller(Game game){
        this.game = game;
    }

    public void tick(){
        for (int i = 0; i < b.getSize(); i++){
            TempBullet = b.get(i);

            if (TempBullet.getY() < 0){
                removeBullet(TempBullet);
            }

            TempBullet.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < b.getSize(); i++){
            TempBullet = b.get(i);
            TempBullet.render(g);
        }
    }

    public void addBullet(Bullet block){
        b.add(block);
    }
    private void removeBullet(Bullet block){
        b.removeValue(block,false);
    }

}