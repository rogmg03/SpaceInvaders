package Enemies;

import Tools.EntityB;
import Tools.ListaCircular;
import Tools.ListaEnlazada;

import java.awt.*;

public interface Wave {
    void tick();
    void render(Graphics g);
    void addEntity(EntityB block);
    ListaEnlazada<EntityB> getLista();
    ListaCircular<EntityB> getListaC();
}
