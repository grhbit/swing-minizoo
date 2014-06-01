package minizoo.c;
import java.awt.geom.Point2D;
import java.util.PriorityQueue;

public abstract class Entity implements Comparable<Entity> {

	@Override
	public int compareTo(Entity entity) {
		return this.zOrder <= entity.zOrder ? -1 : 1;
	}

	public void addChild(Entity entity) {
		addChild(entity, -1);
	}

	public void addChild(Entity entity, int zOrder) {
		children.add(entity);
	}
	
	public void removeChild(Entity entity) {
		children.remove(entity);
	}
	
	public PriorityQueue<Entity> getChildren() {
		return children;
	}
	
	public void Update(float elapsed) {
		updatedTime += elapsed;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
	public Point2D getPosition() {
		return position;
	}
	
	Point2D position;
	int zOrder = -1;
	float updatedTime;
	
	public PriorityQueue<Entity> children = new PriorityQueue<Entity>();
	public static PriorityQueue<Entity> list = new PriorityQueue<Entity>();
}
