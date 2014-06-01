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

	double px = 0, py = 0;
	
	@Override
	public void Update(float elapsed) {
		super.Update(elapsed);
	}
	
	@Override
	public boolean intersect(Point2D point) {
		Rectangle2D rect2d = new Rectangle2D.Double(px, py, 100, 100);
		return rect2d.contains(point);
	}

	@Override
	public void Hover(boolean isHover) {
		// TODO Auto-generated method stub
		System.out.println("Hover " + isHover);
		
		if (isHover) {
			scaleX = 1.2;
			scaleY = 1.2;
		} else {
			scaleX = 1.0;
			scaleY = 1.0;
		}
	}

	@Override
	public void Drag(Point2D point) {
		// TODO Auto-generated method stub
		System.out.println("Drag " + point);
		px = point.getX() - sx;
		py = point.getY() - sy;
	}
	
	double sx, sy;

	@Override
	public void Press(boolean isPress, Point2D point) {
		// TODO Auto-generated method stub
		System.out.println("Press " + isPress + " " + point);
		sx = point.getX() - px;
		sy = point.getY() - py;
	}

	@Override
	public void Click() {
		System.out.println("Click");		
	}

	@Override
	public void DoubleClick() {
		System.out.println("Double Click");
	}
	
	double scaleX = 1, scaleY = 1;
	
	void drawChildren(Graphics g) {
		for (Entity child : getChildren()) {
			if (child!=null && child instanceof Drawable) {
				Drawable drawable = (Drawable)child;
				drawable.beforeDraw(g);
				drawable.Draw(g);
				drawable.afterDraw(g);
			}
		}
	}

	AffineTransform lastAffineTransform;
	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.translate(px+50, py+50);
		g2.scale(scaleX, scaleY);
		g2.translate(-px-50, -py-50);
		g2.drawRect((int)px, (int)py, 100, 100);
		
		drawChildren(g);
	}

	@Override
	public void beforeDraw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		lastAffineTransform = g2.getTransform();
	}

	@Override
	public void afterDraw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setTransform(lastAffineTransform);
	}
	
}
