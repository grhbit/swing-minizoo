package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.RotateBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.core.Vector2d;

import java.awt.*;
//import java.awt.geom.Ellipse2D;

public class BearLeftArm extends Entity {
    public BearLeftArm(String name) {
        super(name);

        this.setContentSize(new Vector2d(112, 62));
        this.runAction(
                new Forever(
                        new Sequence(
                              //  new Instant(
                             //           new RotateBy(0.13f, -10f)),
                                new EaseInOutSine(
                                        new RotateBy(2f, 5f))
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
        g2.setColor(Bear.OutSkinColor);
        //g2.fillRect(259, 563, 62, 112);
        //g2.rotate(Math.PI*1/4.0);
        //g2.fillOval(0, 0, 200, 150);
        g2.rotate(Math.PI*1/2.0);
        g2.fillRoundRect(30, 150, 150, 100, 30, 30);
        
        g2.rotate(Math.PI*-0.5);
        g2.fillRoundRect(-250, 120, 200, 100, 30, 30);
        
        g2.setColor(Bear.InSkinColor);
        g2.fillOval(-100, 100, 150, 150);
        //g2.setColor(Panda.BlackColor);
        
        g2.rotate(Math.PI*0.7);
        g2.setColor(Bear.WhiteColor);
        g2.fillRect(0, -100, 650,30);
        
        g2.rotate(Math.PI*-0.5);
        g2.setColor(Color.red);
        g2.fillRect(0, 0, 200, 30);
        
        //g2.fillRect(387, 563, 62, 112);
        //g2.fillOval(387, 563, 62, 112);
       // g2.setColor(isNear? Panda.brandColor : Panda.subBrandColor);
       // g2.fillRect(0, 0, 64, 59);
    }

    boolean isNear;
}
