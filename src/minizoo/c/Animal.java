package minizoo.c;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import minizoo.e.State;
import minizoo.i.Collider;
import minizoo.i.Drawable;
import minizoo.i.TouchListener;

public class Animal extends Entity implements TouchListener {

	public Animal(String name) {
		super(name);
	}

	@Override
	public void update(float elapsed) {
		super.update(elapsed);
	}

	@Override
	public void Hover(boolean isHover) {
		// TODO Auto-generated method stub
		System.out.println("Hover " + isHover + " " + this.name);

		if (isHover) {
			scale.x = 1.2;
			scale.y = 1.2;
		} else {
			scale.x = 1.0;
			scale.y = 1.0;
		}
	}

	@Override
	public void Drag(Point2D point) {
		//System.out.println("Drag " + point);
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
		setRotation(getRotation() + 20);
	}

	@Override
	public void DoubleClick() {
		System.out.println("Double Click");
	}

	@Override
	public void visit(Graphics2D g2) {
		super.visit(g2);
		g2.setColor(getColor());
		g2.fillRect(0, 0, (int)getContentSize().x, (int)getContentSize().y);
	}

    State currState = State.Default;
    State prevState = null;
}
