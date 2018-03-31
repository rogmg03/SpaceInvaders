package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Cada vez que se presione una tecla, se invoca esta funcion
//Es una clase Adapter de KeyInput/KeyAdapter

public class KeyInput extends KeyAdapter{

    Game game;

    public KeyInput(Game game){ //Queremos que detecte la tecla presionada dentro de la clase game, que es la mas general
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.keyReleased(e);
    }
}
