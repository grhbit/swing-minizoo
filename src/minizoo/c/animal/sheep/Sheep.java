package minizoo.c.animal.sheep;

import minizoo.c.Animal;
import minizoo.c.action.*;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.action.easing.EaseOutSine;
import minizoo.c.core.Vector2d;
import minizoo.e.State;

import java.awt.*;
import java.awt.geom.Point2D;

@SuppressWarnings("UnusedDeclaration")
public class Sheep extends Animal {
    public final static Color brandColor = new Color(227, 227, 227); // fur color
    public final static Color subBrandColor = new Color(209, 204, 204); // fur sub-color
    public final static Color skinColor = new Color(192, 157, 123); // skin color
    public final static Color whiteOfTheEyeColor = new Color(229, 229, 229); // white of the eye color
    public final static Color softBlackColor = new Color(43, 43, 43); // eyes color
    public final static Color mouseColor = new Color(234, 143, 143); // mouse color
    public final static Color tougueColor = new Color(202, 105, 105); // tougue color
    public final static Color hoofColor = new Color(64, 43, 21); // hoof color

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    public Sheep(String name) {
        super(name);

        this.setScale(new Vector2d(0.3f, 0.3f));

        body = new SheepBody(name + ":Body");
        addChild(body);

        normalAction(true);
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
        getBody().reset();
        getBody().stopAllAction();
        getBody().getBackLeftLeg().stopAllAction();
        getBody().getBackRightLeg().stopAllAction();
        getBody().getFrontLeftLeg().stopAllAction();
        getBody().getFrontRightLeg().stopAllAction();
        getBody().getBodyInternel().stopAllAction();
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
            getBody().getFrontLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), Delay.c(0.3f), Delay.c(0.3f)
            )));
            getBody().getBackLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), Delay.c(0.3f), Delay.c(0.3f)
            )));
            getBody().getFrontRightLeg().runAction(Forever.c(Sequence.c(
                    Delay.c(0.3f), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), Delay.c(0.3f)
            )));
            getBody().getBackRightLeg().runAction(Forever.c(Sequence.c(
                    Delay.c(0.3f), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), Delay.c(0.3f)
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
            getBody().getFrontLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), RandomDelay.c(0.3f, 1f)
            )));
            getBody().getBackLeftLeg().runAction(Forever.c(Sequence.c(
                    EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0)), RandomDelay.c(0.3f, 1f)
            )));
            getBody().getFrontRightLeg().runAction(Forever.c(Sequence.c(
                    RandomDelay.c(0.3f, 1f), EaseOutSine.c(MoveBy.c(0.3f, -stepWidth, 0)), EaseOutSine.c(MoveBy.c(0.3f, stepWidth, 0))
            )));
            getBody().getBackRightLeg().runAction(Forever.c(Sequence.c(
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

    public SheepBody getBody() {
        return body;
    }
    public void setBody(SheepBody body) {
        this.body = body;
    }
    SheepBody body;
}
