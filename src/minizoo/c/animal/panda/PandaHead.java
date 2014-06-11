package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseLinear;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class PandaHead extends Entity {
    public PandaHead(String name) {
        super(name);

        this.setContentSize(new Vector2d(400, 300));

        leftEye = new PandaEye(name + ":leftEye");
        leftEye.setPosition(new Vector2d(280, 150));

        this.addChild(leftEye);


        rightEye = new PandaEye(name + ":rightEye");
        rightEye.setPosition(new Vector2d(140, 150));
        rightEye.setScale(new Vector2d(-1, 1));
        this.addChild(rightEye);

        mouse = new PandaMouse(name + ":mouse");
        mouse.setPosition(new Vector2d(200, 250));
        this.addChild(mouse);

        leftEar = new PandaEar(name + ":leftEar");
        leftEar.setPosition(new Vector2d(50, 30));
        this.addChild(leftEar);

        rightEar = new PandaEar(name + ":rightEar");
        rightEar.setPosition(new Vector2d(350, 30));
        rightEar.setScale(new Vector2d(-1, 1));
        this.addChild(rightEar);


        this.runAction(
                new Forever(
                        new Sequence(
                                new EaseLinear(
                                        new RotateBy(1f, 0.5f)),
                                new EaseLinear(
                                        new RotateBy(1f, -0.5f))
                        )
                )
        );
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Panda.WhiteColor));
        g2.fillOval(0, 0, 400, 300);
    }

    public PandaEye getLeftEye() {
        return leftEye;
    }

    public PandaEye getRightEye() {
        return rightEye;
    }

    public PandaMouse getMouse() {
        return mouse;
    }

    public PandaEar getleftEar() {
        return leftEar;
    }

    public PandaEar getrightEar() {
        return rightEar;
    }


    PandaEye leftEye;
    PandaEye rightEye;
    PandaMouse mouse;
    PandaEar leftEar;
    PandaEar rightEar;
}
