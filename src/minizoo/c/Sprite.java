package minizoo.c;

import minizoo.c.core.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite extends Entity {
    public Sprite(String filename) {
        super("Sprite:" + filename);

        try {
            setImage(ImageIO.read(new File(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;

        if (image == null) {
            setContentSize(new Vector2d(0, 0));
        } else {
            setContentSize(new Vector2d(getImage().getWidth(), getImage().getHeight()));
        }

    }

    @Override
    public void visit(Graphics2D g2) {
        if (image != null) {
            g2.drawRenderedImage(image, null);
        }
    }

    BufferedImage image;
}
