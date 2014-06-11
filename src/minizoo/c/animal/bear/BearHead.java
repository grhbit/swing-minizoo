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

        g2.setColor(getTintedColor(Bear.OutSkinColor));
        g2.fillOval(0, 0, 330, 380);

        g2.setColor(getTintedColor(Bear.InSkinColor));
        g2.fillOval(20, 20, 290, 330);
    }

    public BearEye getRightEye() {
        return rightEye;
    }

    public BearMouse getMouse() {
        return mouse;
    }

    public BearEar getleftEar() {
        return leftEar;
    }

    public BearEar getrightEar() {
        return rightEar;
    }


    BearEye rightEye;
    BearMouse mouse;
    BearEar leftEar;
    BearEar rightEar;
}
