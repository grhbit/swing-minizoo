package minizoo.i;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

// for Collision
public interface Collider {

    public Rectangle2D getBoundingBox();
	public boolean intersect(Point2D point, AffineTransform base);
}
