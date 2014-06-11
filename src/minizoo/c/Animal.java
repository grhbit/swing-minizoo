package minizoo.c;

import java.awt.*;
import java.awt.geom.Point2D;

import minizoo.e.State;
import minizoo.i.DancingMachine;
import minizoo.i.TouchListener;

public class Animal extends Entity implements TouchListener, DancingMachine {

	public Animal(String name) {
		super(name);
	}

	@Override
	public void update(float elapsed) {
		super.update(elapsed);
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

	@Override
	public void Press(boolean isPress, Point2D point) {
		System.out.println("Press " + isPress + " " + point);
		sx = point.getX() - position.x;
		sy = point.getY() - position.y;
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
		g2.setColor(getTintedColor(Color.white));
		g2.fillRect(0, 0, (int)getContentSize().x, (int)getContentSize().y);
	}

    State currState = State.Default;
    State prevState = null;

    @Override
    public void doDance(boolean begin) {

    }
}
