package Tools;

import Game.GameObject;

public class Physics {


    public static boolean Collision(EntityA enta, Lista<EntityB> entb) {

        for (int i = 0; i < entb.getSize(); i++){
            if (enta.getBounds().intersects(entb.get(i).getBounds())){
                return true;
            }
        }

        return false;
    }

    public static boolean Collision(EntityB entb, Lista<EntityA> enta) {

        for (int i = 0; i < enta.getSize(); i++){
            if (entb.getBounds().intersects(enta.get(i).getBounds())){
                return true;
            }
        }

        return false;
    }

}
