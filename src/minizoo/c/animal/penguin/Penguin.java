package minizoo.c.animal.penguin;

import minizoo.c.Animal;
import minizoo.c.action.*;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.action.easing.EaseOutSine;
import minizoo.e.State;

import java.awt.*;
import java.awt.geom.Point2D;

public class Penguin extends Animal {
    public static final Color brandColor = new Color(49, 56, 82);
    public static final Color subBrandColor = new Color(32, 39, 62);
    public static final Color bodyPointColor = new Color(250, 215, 27);
    public static final Color legPointColor = new Color(255, 153, 51);
    public static final Color mouseColor = new Color(221, 43, 83);
    public static final Color innerMouseColor = new Color(85, 17, 32);
    public static final Color whiteColor = new Color(255, 252, 249);
    public static final Color blackColor = new Color(37, 37, 37);

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    public Penguin(String name) {
        super(name);

        this.setScale(0.3f, 0.3f);

        body = new PenguinBody(name + ":body");
        this.addChild(body);

        movingStart();
    }

    @Override
    public void doDance(boolean isEnabled) {
        if (isEnabled) {
            normalAction(false);
            pickingAction(false);
            dancingAction(true);
        } else {
            dancingAction(false);
            pickingAction(false);
            normalAction(true);
        }
    }

    @Override
    public void Press(boolean isPress, Point2D pos) {
        if (isPress) {
            normalAction(false);
            dancingAction(false);
            pickingAction(true);
        } else {
            pickingAction(false);
            dancingAction(false);
            normalAction(true);
        }

        super.Press(isPress, pos);
    }

    void allActionStop() {
        this.stopAllAction();
        this.setScale(0.3f, 0.3f);
        movingStop();
        getBody().stopAllAction();
        getBody().getLeftLeg().stopAllAction();
        getBody().getRightLeg().stopAllAction();
        getBody().getLeftArm().stopAllAction();
        getBody().getRightArm().stopAllAction();
        getBody().getBodyInternal().stopAllAction();
        getBody().getHead().setRotation(0);
        getBody().getHead().stopAllAction();
        getBody().getHead().getLeftEye().stopAllAction();
        getBody().getHead().getRightEye().stopAllAction();
        getBody().getHead().getMouse().stopAllAction();
    }

    public void normalAction (boolean isStart) {
        prevState = currState;
        currState = State.Normal;

        if (prevState != State.Normal) {
            allActionStop();

            float stepWidth = 30f;
            getBody().getHead().runAction(Forever.c(Sequence.c(MoveBy.c(1, 10, 0), MoveBy.c(1, -10, 0))));
            getBody().getLeftLeg().runAction(Forever.c(Sequence.c(
                    Delay.c(0f), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0))
            )));
            getBody().getRightLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), Delay.c(0f)
                    )));

            movingStart();
        } else if (!isStart) {
            allActionStop();
        }
    }

    public void dancingAction(boolean isStart) {
        prevState = currState;
        currState = State.Dancing;

        if (prevState != State.Dancing) {
            allActionStop();

            float stepWidth = 30f;

            getBody().runAction(Forever.c(Sequence.c(EaseInOutSine.c(MoveBy.c(0.2f, 0f, 40f)), RandomDelay.c(0.01f, 0.2f), EaseInOutSine.c(MoveBy.c(0.2f, 0f, -40f)))));
            getBody().getHead().runAction(Forever.c(Sequence.c(RotateTo.c(0.3f, (float)Math.toRadians(-360)))));
            getBody().getHead().runAction(Forever.c(Sequence.c(MoveBy.c(0.3f, -100f, -100f), MoveBy.c(0.3f, 100f, 100f), MoveBy.c(0.3f, -100f, 0f), MoveBy.c(0.3f, 100f, 0f))));
            getBody().getLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), RandomDelay.c(0.3f, 1f)
            )));
            getBody().getLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), RandomDelay.c(0.3f, 1f)
            )));
            getBody().getRightLeg().runAction(Forever.c(Sequence.c(
                    RandomDelay.c(0.3f, 1f), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0))
            )));
            getBody().getRightLeg().runAction(Forever.c(Sequence.c(
                    RandomDelay.c(0.3f, 1f), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0))
            )));

        } else if (!isStart) {
            allActionStop();
            getBody().getHead().setRotation(0);
        }
    }

    public void pickingAction(boolean isStart) {
        prevState = currState;
        currState = State.Picking;

        if (prevState != State.Picking) {
            allActionStop();
        } else if (!isStart) {
            allActionStop();
        }
    }
    public PenguinBody getBody() {
        return body;
    }
    PenguinBody body;
}
