package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;
//import java.awt.geom.Ellipse2D;

public class PandaEar extends Entity {
    public PandaEar(String name) {
        super(name);

        this.setContentSize(new Vector2d(150, 100));
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
       // g2.rotate(Math.PI);
       //g2.fillRect(0, 0, 80, 53);
        //g2.rotate(Math.PI*1/8.0);
        g2.fillOval(0, 0, 130,130 );
      // g2.fillRoundRect(0, 0, 100, 100, 20, 20);
        //g2.fillOval(0, 0, 91, 60);
       // g2.setColor(Panda.WhiteColor);
       // g2.fillOval(0, 0, 67, 26);
        
       // g2.setColor(Panda.BlackColor);
      //  g2.fillOval(0, 0, 32, 24);
        //
    }

    float blinkFactor = 0f;
    float blinkBeginTime = 0f;
    float blinkEndTime = 0f;
}
