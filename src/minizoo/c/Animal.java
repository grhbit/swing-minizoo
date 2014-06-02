package minizoo.c;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import minizoo.i.Collider;
import minizoo.i.Drawable;
import minizoo.i.TouchListener;

public class Animal extends Entity implements TouchListener, Collider, Drawable {

	@Override
	public void Update(float elapsed) {
		super.Update(elapsed);
	}

	@Override
	public void Hover(boolean isHover) {
		// TODO Auto-generated method stub
		System.out.println("Hover " + isHover);
		
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
		// TODO Auto-generated method stub
		System.out.println("Drag " + point);
		position.x = point.getX() - sx;
		position.y = point.getY() - sy;
	}
	
	double sx, sy;

	@Override
	public void Press(boolean isPress, Point2D point) {
		// TODO Auto-generated method stub
		System.out.println("Press " + isPress + " " + point);
		sx = point.getX() - position.x;
		sy = point.getY() - position.y;
	}

	@Override
	public void Click() {
		System.out.println("Click");		
	}

	@Override
	public void DoubleClick() {
		System.out.println("Double Click");
	}
	
	@Override
	public void visit(Graphics g) {
		super.visit(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawRect(0, 0, (int)getContentSize().x, (int)getContentSize().y);
	}
	
}
