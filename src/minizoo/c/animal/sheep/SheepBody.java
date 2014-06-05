package minizoo.c.animal.sheep;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class SheepBody extends Entity {
    public class SheepBodyInternal extends Entity {
        public SheepBodyInternal(String name) {
            super(name);
        }

        @Override
        public void visit(Graphics2D g2) {
            g2.setColor(Sheep.subBrandColor);
            g2.fillRect(0, 0, 439, 241);

            g2.setColor(Sheep.brandColor);
            g2.fillRect(2, 37, 395, 206);
        }
    }

    public SheepBody(String name) {
        super(name);

        this.setContentSize(new Vector2d(439, 241));

        frontLeftLeg = new SheepLeg(name + ":frontLeftLeg");
        frontLeftLeg.setPosition(new Vector2d(82, 293));
        frontLeftLeg.setNearLeg(true);
        addChild(frontLeftLeg);

        frontRightLeg = new SheepLeg(name + ":frontRightLeg");
        frontRightLeg.setPosition(new Vector2d(157, 293));
        frontRightLeg.setNearLeg(false);
        addChild(frontRightLeg);

        backLeftLeg = new SheepLeg(name + ":backLeftLeg");
        backLeftLeg.setPosition(new Vector2d(312, 293));
        backLeftLeg.setNearLeg(true);
        addChild(backLeftLeg);

        backRightLeg = new SheepLeg(name + ":backRightLeg");
        backRightLeg.setPosition(new Vector2d(392, 293));
        backRightLeg.setNearLeg(false);
        addChild(backRightLeg);

        bodyInternel = new SheepBodyInternal(name + ":bodyInternel");
        addChild(bodyInternel, 0);

        head = new SheepHead(name + ":head");
        head.setPosition(new Vector2d(0, 0));
        addChild(head, 1);
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    public SheepHead getHead() {
        return head;
    }
    public SheepBodyInternal getBodyInternel() { return bodyInternel; }
    public SheepLeg getFrontLeftLeg() {
        return frontLeftLeg;
    }
    public SheepLeg getFrontRightLeg() {
        return frontRightLeg;
    }
    public SheepLeg getBackLeftLeg() {
        return backLeftLeg;
    }
    public SheepLeg getBackRightLeg() {
        return backRightLeg;
    }

    SheepHead head;
    SheepBodyInternal bodyInternel;
    SheepLeg frontLeftLeg;
    SheepLeg frontRightLeg;
    SheepLeg backLeftLeg;
    SheepLeg backRightLeg;
}
