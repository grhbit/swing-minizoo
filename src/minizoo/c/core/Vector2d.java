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
    public Vector2d(Vector2d vec2d) {
        this.x = vec2d.x;
        this.y = vec2d.y;
    }
    public Vector2d(Point2D point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public void add(Vector2d rhs) {
        this.x += rhs.x;
        this.y += rhs.y;
    }
    public void sub(Vector2d rhs) {
        this.x -= rhs.x;
        this.y -= rhs.y;
    }
    public void mul(Vector2d rhs) {
        this.x *= rhs.x;
        this.y *= rhs.y;
    }
    public void mul(float factor) {
        this.x *= factor;
        this.y *= factor;
    }

	public String toString() {
		return "x=> " + x + " y=> " + y;
	}

	public Point2D toPoint2D() {
		return new Point2D.Double(x, y);
	}

    public Vector2d clone() { return new Vector2d(x, y); }

	public double x = 0.0;
	public double y = 0.0;
}
