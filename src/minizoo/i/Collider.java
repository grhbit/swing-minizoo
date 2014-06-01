package minizoo.i;

import java.awt.geom.Point2D;

// 충돌 처리를 위한 인터페이스
public interface Collider {
	
	public boolean intersect(Point2D point);
}
