package Game;

import Enemies.EnemyC;
import Tools.Physics;

public class BossC extends Boss{

    EnemyC enemy;

    public BossC (double x, double y, Textures tex, int life, Controller c, Game game, EnemyC enemy){
        super(x,y,tex,life,c,game);
        this.enemy = enemy;
    }

    @Override
    public void tick(){
        y += 0.2;
        if (Physics.Collision(this, game.ea)){
            this.hit();
        }
        if (this.getLife()== 0){
            c.removeEntity(this);
            this.updateBoss(enemy);
        }
    }

    public void updateBoss(EnemyC enemy){
        enemy.setBoss();
    }

}
