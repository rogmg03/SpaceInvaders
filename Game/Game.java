package Game;

import Tools.EntityA;
import Tools.EntityB;
import Tools.ListaEnlazada;
import Tools.Timer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 400;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space Invaders";

    private Boolean running=false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;

    private Timer delay = new Timer();

    private boolean shooting = false;

    //contador de enemigos vivos y muertos

    private Player p;
    private Controller c;
    private Textures tex;

    public ListaEnlazada<EntityA> ea;
    public ListaEnlazada<EntityB> eb;

    public void init(){
        requestFocus(); //Evita tener que darle click a la ventana

        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/SpriteSheet.png"); //La imagen Spritesheet, texturas del juego
            background = loader.loadImage("/background.png");
        }catch(IOException e){
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));

        tex = new Textures(this);

        p = new Player(300,450,tex);
        c = new Controller(tex,this);

        c.createEnemy("EnemyA");

        ea = c.getEntityA();
        eb = c.getEntityB();

    }

    //synchronized se utiliza para el manejo de hilos
    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if (!running)
            return;
        running = false;
        try { //try porque esto no puede fallar
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double fps = 60.0;
        double ns = 1000000000 / fps;
        double delta = 0; //tiempo transcurrido en ejecucion
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();


        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, FPS " + frames);
                updates = 0; //reiniciar contador y que nos muestre el actual, no la suma de cada update
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){ //lo que el juego actualice
        p.tick();
        c.tick();
    }

    private void render(){ //lo que el juego renderice

        BufferStrategy bs = this.getBufferStrategy(); //buffer carga la escena anterior

        if (bs == null){
            createBufferStrategy(3); //Al darle 3, tenemos una escena actual, carga la anterior, y además
            return;                             //carga una antes de esta, incrementando el rendimiento del juego.
        }

        Graphics g = bs.getDrawGraphics();
        //########################################
        //Aqui dentro se puede dibujar lo que sea\


        g.drawImage(image, 0, 0, getWidth(),getHeight(),this);

        g.drawImage(background, 0, 0, null);

        p.render(g);
        c.render(g);

        //########################################
        g.dispose();
        bs.show();


    }

    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();


        if (key == KeyEvent.VK_RIGHT){
            p.setVelX(5);
            Textures.changeType("RIGHT");
        }else if (key == KeyEvent.VK_LEFT){
            p.setVelX(-5);
            Textures.changeType("LEFT");
        }else if (key == KeyEvent.VK_SPACE && !shooting && delay.delay(500)){
            shooting = true;
            c.addEntity(new Bullet(p.getX(),p.getY(),tex,this));
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getExtendedKeyCode();


        if (key == KeyEvent.VK_RIGHT) {
            p.setVelX(0);
            Textures.changeType("NORMAL");
        } else if (key == KeyEvent.VK_LEFT) {
            p.setVelX(0);
            Textures.changeType("NORMAL");
        } else if (key == KeyEvent.VK_SPACE){
            shooting = false;
        }
    }


    public static void main(String[] args) {

        Game game = new Game();
        //Dimension encapsula altura y ancho
        game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack(); //Acomoda las cosas en la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Al cerrar la ventana, termina de ejecutar el codigo
        frame.setResizable(false); //Evita que cambie el tamaño de la ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        game.start();
    }


    //########Getter y Setters##########


    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

}
