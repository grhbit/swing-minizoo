package minizoo.i;

import java.awt.geom.Point2D;

// for Collision
public interface Collider {
	
	public boolean intersect(Point2D point);
}
