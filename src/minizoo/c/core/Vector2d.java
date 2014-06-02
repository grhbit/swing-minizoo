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

	public String toString() {
		return "x=> " + x + " y=> " + y;
	}

	public Point2D toPoint2D() {
		return new Point2D.Double(x, y);
	}

	public double x = 0.0;
	public double y = 0.0;
}
