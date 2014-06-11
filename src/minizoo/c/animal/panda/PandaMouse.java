package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class PandaMouse extends Entity {
    public PandaMouse(String name) {
        super(name);

        this.setContentSize(new Vector2d(23, 16));
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }
    

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(Panda.MouthColor);
        g2.fillOval(0, 0, 50, 50);
        g2.setColor(Panda.WhiteColor);
        g2.fillOval(0, -30, 50, 50);
        
        //g2.setColor(Panda.MouthColor);
       // g2.fillRect(1, 21, 45, 27);
    }
}
