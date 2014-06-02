package minizoo.c.core;

import java.awt.geom.Point2D;

public class Vector2d {
	public Vector2d() {
		x = 0.0;
		y = 0.0;
	}
	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D toPoint2D() {
		return new Point2D.Double(x, y);
	}
	
	public double x = 0.0;
	public double y = 0.0;
	
	public static final Vector2d zero = new Vector2d(0.0, 0.0);
	public static final Vector2d one = new Vector2d(1.0, 1.0);
}
