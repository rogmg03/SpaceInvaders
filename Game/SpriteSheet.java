package Game;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage ss){
        this.image = ss;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col * 128) - 128, (row * 128) - 128, width , height );
        return img;
    }


}
