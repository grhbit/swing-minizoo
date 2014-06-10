package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class PenguinHead extends Entity {
    public PenguinHead(String name) {
        super(name);

        this.setContentSize(134, 121);

        mouse = new PenguinMouse(name + ":mouse");
        mouse.setPosition(59, 86);
        this.addChild(mouse);

        leftEye = new PenguinEye(name + ":rightEye");
        leftEye.setPosition(25, 48);
        this.addChild(leftEye);

        rightEye = new PenguinEye(name + ":leftEye");
        rightEye.setPosition(96, 48);
        this.addChild(rightEye);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Penguin.subBrandColor));
        g2.fillOval(1, 3, 133, 118);

        g2.setColor(getTintedColor(Penguin.brandColor));
        g2.fillOval(7, 0, 118, 85);
        g2.fillOval(0, 2, 133, 118);
    }

    public PenguinEye getLeftEye() {
        return leftEye;
    }
    public PenguinEye getRightEye() {
        return rightEye;
    }
    PenguinEye leftEye;
    PenguinEye rightEye;

    public PenguinMouse getMouse() {
        return mouse;
    }
    PenguinMouse mouse;
}
