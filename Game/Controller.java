package Game;

import Tools.ListaEnlazada;
import java.util.Random;
import java.awt.*;

public class Controller {

    private ListaEnlazada <Bullet> b = new ListaEnlazada<Bullet>();
    private ListaEnlazada <Enemy> e = new ListaEnlazada<Enemy>();

    Random r = new Random();

    Bullet TempBullet;
    Enemy TempEnemy;

    Game game;
    Textures tex;

    public Controller(Game game, Textures tex){
        this.game = game;
        this.tex = tex;

        addEnemy(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE),0,tex));
    }

    public void tick(){
        for (int i = 0; i < b.getSize(); i++){
            TempBullet = b.get(i);

            if (TempBullet.getY() < 0){
                removeBullet(TempBullet);
            }

            TempBullet.tick();
        }
        for (int i = 0; i < e.getSize(); i++){
            TempEnemy = e.get(i);

            TempEnemy.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < b.getSize(); i++){
            TempBullet = b.get(i);
            TempBullet.render(g);
        }
        for (int i = 0; i < e.getSize(); i++){
            TempEnemy = e.get(i);
            TempEnemy.render(g);
        }
    }

    public void addBullet(Bullet block){
        b.add(block);
    }
    private void removeBullet(Bullet block){
        b.removeValue(block,false);
    }

    public void addEnemy(Enemy block){
        e.add(block);
    }
    private void removeEnemy(Enemy block){
        e.removeValue(block,false);
    }

}
