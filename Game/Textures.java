package Game;

import java.awt.image.BufferedImage;


public class Textures {

    public static BufferedImage player;
    public static BufferedImage player2;
    public static BufferedImage player1;
    public BufferedImage image;
    public static BufferedImage type;
    public BufferedImage enemy;
    public BufferedImage boss;
    public int style;

    private SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }

    private void getTextures(){
        player = ss.grabImage(1,1,128,128);
        player2 = ss.grabImage(2,1,128,128);
        player1 = ss.grabImage(3,1,128,128);
        image = ss.grabImage(4,1,128,128);
        enemy = ss.grabImage(5,1,128,128);
        boss = ss.grabImage(1,2,128,128);
        type = player;
    }
    static void changeType(String side){
        if (side == "LEFT"){
            type = player1;
        } else if (side == "RIGHT") {
            type = player2;
        } else if (side == "NORMAL"){
            type = player;
        }
    }

}
