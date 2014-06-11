package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearMouse extends Entity {
    public BearMouse(String name) {
        super(name);

        this.setContentSize(new Vector2d(23, 16));
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }
    

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(Bear.MouthColor);
        g2.fillOval(25, 25, 50, 50);
        
        g2.setColor(Bear.BlackColor);
        g2.fillOval(60,-20,30,30);
        
        g2.setColor(Bear.InSkinColor); //요놈이 코에요 수정 부탁드려요
        g2.fillOval(30, 20, 40, 30);
        
        //g2.setColor(Panda.MouthColor);
       // g2.fillRect(1, 21, 45, 27);
    }
}
