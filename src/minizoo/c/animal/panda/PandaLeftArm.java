package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;
//import java.awt.geom.Ellipse2D;

public class PandaLeftArm extends Entity {
    public PandaLeftArm(String name) {
        super(name);

        this.setContentSize(new Vector2d(112, 62));
        
        this.runAction(
                new Forever(
                        new Sequence(
                                new Instant(
                                        new MoveBy(0.13f, 20f, 0f)),
                                new EaseInOutSine(
                                        new MoveBy(0.13f, -20f, 0f))
                        )
                )
        );
    
    }

   // public void setNearLeg(boolean isNear) {
   //     this.isNear = isNear;
   // }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(Panda.BlackColor);
        //g2.fillRect(259, 563, 62, 112);
        //g2.rotate(Math.PI*1/4.0);
        //g2.fillOval(0, 0, 200, 150);
        //g2.fillRoundRect(30, 50, 200, 100, 30, 30);
        g2.rotate(Math.PI*-5/6.0);
        g2.fillRoundRect(60, 80, 200, 100, 30, 30);
        
        g2.setColor(Panda.DarkWhiteColor);
        g2.fillOval(200, 50, 150, 150);
        
        g2.setColor(Panda.WhiteColor);
        g2.fillOval(220, 70, 100, 100);
        
        //g2.setColor(Panda.BlackColor);
        //g2.fillRect(387, 563, 62, 112);
        //g2.fillOval(387, 563, 62, 112);
       // g2.setColor(isNear? Panda.brandColor : Panda.subBrandColor);
       // g2.fillRect(0, 0, 64, 59);
    }
    
    

    boolean isNear;
}
