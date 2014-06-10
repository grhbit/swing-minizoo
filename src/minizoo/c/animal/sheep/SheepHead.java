package minizoo.c.animal.sheep;

import minizoo.c.Entity;
import minizoo.c.action.*;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class SheepHead extends Entity {
    public SheepHead(String name) {
        super(name);

        this.setContentSize(new Vector2d(205, 203));

        leftEye = new SheepEye(name + ":leftEye");
        leftEye.setPosition(new Vector2d(36, 98));
        this.addChild(leftEye);

        rightEye = new SheepEye(name + ":rightEye");
        rightEye.setPosition(new Vector2d(153, 98));
        rightEye.setScale(new Vector2d(-1, 1));
        this.addChild(rightEye);

        mouse = new SheepMouse(name + ":mouse");
        mouse.setPosition(new Vector2d(91, 176));
        this.addChild(mouse);

        this.runAction(Forever.c( Sequence.c(
                                Instant.c( MoveBy.c(0.13f, 20f, 0f)),
                                EaseInOutSine.c( MoveBy.c(0.13f, -20f, 0f)))));
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Sheep.subBrandColor));
        g2.fillRect(0, 0, 205, 196);

        g2.setColor(getTintedColor(Sheep.brandColor));
        g2.fillRect(0, 19, 186, 184);
        g2.fillRect(6, 24, 175, 175);

        g2.setColor(getTintedColor(Sheep.skinColor));
        g2.fillRect(6, 48, 176, 106);
        g2.fillRect(31, 48, 122, 150);
    }

    public SheepEye getLeftEye() {
        return leftEye;
    }
    public SheepEye getRightEye() {
        return rightEye;
    }
    public SheepMouse getMouse() {
        return mouse;
    }

    SheepEye leftEye;
    SheepEye rightEye;
    SheepMouse mouse;
}
