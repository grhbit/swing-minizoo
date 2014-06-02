package minizoo.c;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.PriorityQueue;

import minizoo.c.core.Vector2d;
import minizoo.i.Collider;
import minizoo.i.Drawable;

public abstract class Entity implements Comparable<Entity>, Collider, Drawable {

	@Override
	public boolean intersect(Point2D point) {
		Rectangle2D rect2d = new Rectangle2D.Double(position.x, position.y, getContentSize().x, getContentSize().y);
		return rect2d.contains(point);
	}

	@Override
	public void draw (Graphics g) {
		beforeDraw(g);
		visit(g);
		afterDraw(g);
	}
	
	protected void beforeDraw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		// Push Matrix
		lastAffineTransform = g2.getTransform();
		
		AffineTransform transform = new AffineTransform();
		
		// Anchor Apply
		transform.translate(-contentSize.x * anchor.x, -contentSize.y * anchor.y);
		
		// Scale
		transform.scale(scale.x, scale.y);
		
		// Rotation
		// transform.rotate(rotation);

		// Translation
		transform.translate(position.x, position.y);
		
		g2.transform(transform);
	}
	
	protected void visit(Graphics g) {
		
	}
	
	protected void afterDraw(Graphics g) {
		drawChildren(g);
		
		// Pop Matrix
		Graphics2D g2 = (Graphics2D)g;
		g2.setTransform(lastAffineTransform);	
	}
	
	protected void drawChildren(Graphics g) {
		for (Entity child : getChildren()) {
			if (child!=null && child instanceof Drawable) {
				Drawable drawable = (Drawable)child;
				drawable.draw(g);
			}
		}
	}

	@Override
	public int compareTo(Entity entity) {
		return this.zOrder <= entity.zOrder ? -1 : 1;
	}

	public void addChild(Entity entity) {
		addChild(entity, -1);
	}

	public void addChild(Entity entity, int zOrder) {
		entity.zOrder = zOrder;
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
	
	public void setContentSize(Vector2d contentSize) {
		this.contentSize = contentSize;
	}
	public Vector2d getContentSize() {
		return contentSize;
	}

	public void setPosition(Vector2d position) {
		this.position = position;
	}
	public Vector2d getPosition() {
		return position;
	}
	
	public void setAnchor(Vector2d anchor) {
		this.anchor = anchor;
	}
	public Vector2d getAnchor() {
		return anchor;
	}
	
	public void setScale(Vector2d anchor) {
		this.scale = anchor;
	}
	public Vector2d getScale() {
		return scale;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	public double getRotation() {
		return rotation;
	}
	
	public void setZOrder(int zOrder) {
		this.zOrder = zOrder;
	}
	public int getZOrder() {
		return zOrder;
	}

	// Entity property
	Vector2d contentSize = Vector2d.zero;
	Vector2d position = Vector2d.zero;
	Vector2d anchor = new Vector2d(0.5, 0.5);
	Vector2d scale = Vector2d.one;
	double rotation = 0.0;
	int zOrder = -1;

	float updatedTime;	
	AffineTransform lastAffineTransform;

	// Entity hierarchy
	public PriorityQueue<Entity> children = new PriorityQueue<Entity>();
	public static PriorityQueue<Entity> list = new PriorityQueue<Entity>();
	public static void add(Entity entity) {
		Entity.add(entity, -1);
	}
	public static void add(Entity entity, int zOrder) {
		entity.zOrder = zOrder;
		Entity.list.add(entity);
	}
}
