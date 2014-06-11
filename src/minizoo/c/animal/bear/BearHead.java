package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.action.*;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearHead extends Entity {
    public BearHead(String name) {
        super(name);

        this.setContentSize(new Vector2d(330, 380));

      //  leftEye = new BearEye(name + ":leftEye");
       // leftEye.setPosition(new Vector2d(280, 150));
        
     //   this.addChild(leftEye);
        
        
        
        rightEye = new BearEye(name + ":rightEye");
        rightEye.setPosition(new Vector2d(230, 140));
       rightEye.setScale(new Vector2d(-1, 1));
       this.addChild(rightEye);

        

        mouse = new BearMouse(name + ":mouse");
        mouse.setPosition(new Vector2d(200, 250));
        this.addChild(mouse);
        
        leftEar = new BearEar(name + ":leftEar");
        leftEar.setPosition(new Vector2d(30, 30));
        this.addChild(leftEar);

    /*    rightEar = new BearEar(name + ":rightEar");
        rightEar.setPosition(new Vector2d(350, 30));
        rightEar.setScale(new Vector2d(-1, 1));
        this.addChild(rightEar);
      */  

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

    @Override
    public void visit(Graphics2D g2) {
      
        g2.setColor(Bear.OutSkinColor);
        g2.fillOval(0, 0, 330, 380);
        
        g2.setColor(Bear.InSkinColor);
        g2.fillOval(20, 20, 290, 330);

      /*  g2.setColor(Panda.brandColor);
        g2.fillRect(0, 19, 186, 184);
        g2.fillRect(6, 24, 175, 175);

        g2.setColor(Panda.skinColor);
        g2.fillRect(6, 48, 176, 106);
        g2.fillRect(31, 48, 122, 150);*/
    }

   // public BearEye getLeftEye() {
   //     return leftEye;
  //  }
    public BearEye getRightEye() {
        return rightEye;
    }
    public BearMouse getMouse() {
        return mouse;
    }
    public BearEar getleftEar() {
        return leftEar;
    }
    public BearEar getrightEar(){
    	return rightEar;
    }
    
    
   // BearEye leftEye;
    BearEye rightEye;
    BearMouse mouse;
    BearEar leftEar;
    BearEar rightEar;
}
