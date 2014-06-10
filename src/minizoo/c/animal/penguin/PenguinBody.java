package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class PenguinBody extends Entity {
    public class PenguinBodyInternal extends Entity {
        public PenguinBodyInternal(String name) {
            super(name);
        }

        @Override
        public void visit(Graphics2D g2) {
            g2.setColor(getTintedColor(Penguin.brandColor));
            g2.fillRoundRect(0, 0, 182, 250, 128, 128);

            g2.setColor(getTintedColor(Penguin.bodyPointColor));
            g2.fillRoundRect(0, 65, 158, 184, 64, 64);

            g2.setColor(getTintedColor(Penguin.whiteColor));
            g2.fillRoundRect(0, 72, 152, 178, 64, 64);
        }
    }

    public PenguinBody(String name) {
        super(name);

        this.setContentSize(182, 250);

        leftLeg = new PenguinLeg(name + ":leftLeg");
        leftLeg.setAnchor(49f/73f, 14f/66f);
        leftLeg.setPosition(129, 239);
        this.addChild(leftLeg, -3);

        rightLeg = new PenguinLeg(name + ":rightLeg");
        rightLeg.setAnchor(49f/73f, 14f/66f);
        rightLeg.setPosition(43, 239);
        this.addChild(rightLeg, -3);

        rightArm = new PenguinArm(name + ":rightArm");
        rightArm.setAnchor(0.5f, 10f/303f);
        rightArm.setPosition(13, 25);
        this.addChild(rightArm, -2);

        bodyInternal = new PenguinBodyInternal(name + ":bodyInternal");
        this.addChild(bodyInternal, -1);

        head = new PenguinHead(name + ":head");
        head.setPosition(51, -19);
        this.addChild(head, 0);

        leftArm = new PenguinArm(name + ":leftArm");
        leftArm.setAnchor(0.5f, 10f/303f);
        leftArm.setPosition(157, 29);
        this.addChild(leftArm, 1);
    }

    public PenguinBodyInternal getBodyInternal() {
        return bodyInternal;
    }
    PenguinBodyInternal bodyInternal;

    public PenguinHead getHead() {
        return head;
    }
    PenguinHead head;

    public PenguinArm getLeftArm() {
        return leftArm;
    }
    public PenguinArm getRightArm() {
        return rightArm;
    }
    PenguinArm leftArm;
    PenguinArm rightArm;

    public PenguinLeg getLeftLeg() {
        return leftLeg;
    }
    public PenguinLeg getRightLeg() {
        return rightLeg;
    }
    PenguinLeg leftLeg;
    PenguinLeg rightLeg;
}
