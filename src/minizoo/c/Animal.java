package minizoo.c;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import minizoo.App;
import minizoo.c.animal.duck.Duck;
import minizoo.c.animal.lion.Lion;
import minizoo.c.animal.penguin.Penguin;
import minizoo.c.animal.sheep.Sheep;
import minizoo.c.core.Vector2d;
import minizoo.e.State;
import minizoo.i.DancingMachine;
import minizoo.i.TouchListener;

public class Animal extends Entity implements TouchListener, DancingMachine {

    public boolean isLDir = true;
	public Animal(String name) {
        super(name);
        ent = (new Random()).nextFloat();
	}
    float ent = 0f;

	@Override
	public void update(float elapsed) {
        super.update(elapsed);

        float targetX = ((float)Math.sin(getUpdatedTime()/3f - ent) + 1) * App.ScreenWidth * 0.5f;
        Vector2d pos = getPosition();
        if (this instanceof Lion || this instanceof Duck) {
            if (pos.x < 0) {
                setPosition(App.ScreenWidth, (float)getPosition().y);
            }

            return;
        } else if (currState == State.Picking) {
            ent = (new Random()).nextFloat() * 10f;
            return;
        }

        if (this instanceof Sheep) {
            targetX = ((float)Math.sin(getUpdatedTime()/30f - ent) + 1) * App.ScreenWidth * 0.5f;
        }

        if (pos.x < targetX) {
            setScale((float)Math.abs(getScale().x) * (isLDir? -1f:1f), (float)getScale().y);
        } else if (pos.x > targetX) {
            setScale((float)Math.abs(getScale().x) * (isLDir? 1f:-1f), (float)getScale().y);
        }
        pos.x = (targetX-pos.x)*elapsed + pos.x;

        setPosition(pos);
	}

	@Override
	public void Hover(boolean isHover) {
		System.out.println("Hover " + isHover + " " + this.name);

		if (isHover) {
			scale.x *= 1.05;
			scale.y *= 1.05;
		} else {
			scale.x /= 1.05;
			scale.y /= 1.05;
		}
	}

	@Override
	public void Drag(Point2D point) {
		position.x = point.getX() - sx;
		position.y = point.getY() - sy;
	}

	double sx, sy;
    boolean isMoving = false;

    public void movingStop() {
        isMoving = false;
        // stopAction("moving");
    }

    public void movingStart() {
        isMoving = true;
        /*
        float stepWidth = 30f;
        int maxCount = (int)((App.ScreenWidth)/stepWidth);
        this.runAction(
                Forever.c(
                        Sequence.c(
                                Repeat.c((int) (getPosition().x / stepWidth), EaseLinear.c(MoveBy.c(1.2f, -stepWidth, 0))),
                                ScaleTo.c(0f, -(float)getScale().x, (float)getScale().y),
                                Repeat.c(maxCount, EaseLinear.c(MoveBy.c(1.2f, stepWidth, 0))),
                                ScaleTo.c(0f, (float)getScale().x, (float)getScale().y),
                                Repeat.c(maxCount - (int) (getPosition().x / stepWidth), EaseLinear.c(MoveBy.c(1.2f, -stepWidth, 0))))), "moving");
                                */
    }

	@Override
	public void Press(boolean isPress, Point2D point) {
		System.out.println("Press " + isPress + " " + point);
		sx = point.getX() - position.x;
		sy = point.getY() - position.y;

        if (isPress) {
            movingStop();
        } else {
            if (App.isDancingTime) {
                doDance(true);
            } else {
                movingStart();
            }
        }
	}

	@Override
	public void Click() {
	}

	@Override
	public void DoubleClick() {
		System.out.println("Double Click");
	}

    @Override
    public boolean isNeededSupportingDoubleClicking() {
        return false;
    }

    @Override
	public void visit(Graphics2D g2) {
		super.visit(g2);
//		g2.setColor(getTintedColor(Color.white));
//		g2.fillRect(0, 0, (int)getContentSize().x, (int)getContentSize().y);
	}

    protected State currState = State.Default;
    protected State prevState = State.Default;

    @Override
    public void doDance(boolean begin) { }
}
