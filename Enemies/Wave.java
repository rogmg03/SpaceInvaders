package Enemies;

import Tools.EntityB;
import Tools.ListaEnlazada;

import java.awt.*;

public interface Wave {
    public void tick();
    public void render(Graphics g);
    public void addEntity(EntityB block);
    public ListaEnlazada<EntityB> getLista();
}
