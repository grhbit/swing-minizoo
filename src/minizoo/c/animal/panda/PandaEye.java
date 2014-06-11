package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;
//import java.awt.geom.Ellipse2D;

public class PandaEye extends Entity {
    public PandaEye(String name) {
        super(name);

        this.setContentSize(new Vector2d(100, 80));
    }

    public void blink() {
        blinkBeginTime = getUpdatedTime();
        blinkEndTime = getUpdatedTime() + 0.3f;
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(Panda.BlackColor);
      //  g2.fillRect(0, 0, 60, 35);
        g2.fillOval(0, 0, 120, 100);
        g2.setColor(Panda.WhiteColor);
        g2.fillOval(10, 20, 80, 60);
        
        g2.setColor(Panda.BlackColor);
        g2.fillOval(13, 30, 50, 50);
        //
    }

    float blinkFactor = 0f;
    float blinkBeginTime = 0f;
    float blinkEndTime = 0f;
}
