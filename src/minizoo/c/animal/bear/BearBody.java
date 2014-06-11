package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearBody extends Entity {
    public class PandaBodyInternal extends Entity {
        public PandaBodyInternal(String name) {
            super(name);
        }

        @Override
        public void visit(Graphics2D g2) {
            g2.setColor(getTintedColor(Bear.OutSkinColor));
            g2.fillOval(50, 0, 400, 500);
            g2.setColor(getTintedColor(Bear.InSkinColor));
            g2.fillOval(80, 20, 350, 450);
        }
    }

    public BearBody(String name) {
        super(name);

        this.setContentSize(new Vector2d(400, 500)); // width height

        RightArm = new BearRightArm(name + ":RightArm");
        RightArm.setPosition(new Vector2d(450, 100));
        addChild(RightArm);

        LeftLeg = new BearLeftLeg(name + ":LeftLeg");
        LeftLeg.setPosition(new Vector2d(100, 250));
        addChild(LeftLeg);

        RightLeg = new BearRightLeg(name + ":RightLeg");
        RightLeg.setPosition(new Vector2d(200, 280));
        addChild(RightLeg);

        ski = new BearSki(name + ":Ski");
        ski.setPosition(new Vector2d(200, 800));
        addChild(ski);

        bodyInternel = new PandaBodyInternal(name + ":bodyInternel");
        addChild(bodyInternel, 0);

        LeftArm = new BearLeftArm(name + ":LeftArm");
        LeftArm.setPosition(new Vector2d(500, 100));
        addChild(LeftArm, 1);

        head = new BearHead(name + ":head");
        head.setPosition(new Vector2d(250, -50));
        addChild(head, 1);
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    public BearHead getHead() {
        return head;
    }

    public PandaBodyInternal getBodyInternel() {
        return bodyInternel;
    }

    public BearLeftArm getLeftArm() {
        return LeftArm;
    }

    public BearRightArm getRightArm() {
        return RightArm;
    }

    public BearLeftLeg getLeftLeg() {
        return LeftLeg;
    }

    public BearRightLeg getRightLeg() {
        return RightLeg;
    }

    public BearSki getSki() {
        return ski;
    }


    BearHead head;
    PandaBodyInternal bodyInternel;
    BearLeftArm LeftArm;
    BearRightArm RightArm;
    BearLeftLeg LeftLeg;
    BearRightLeg RightLeg;
    BearSki ski;
}
