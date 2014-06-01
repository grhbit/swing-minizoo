package minizoo;

import java.awt.Graphics;
import javax.swing.JComponent;

import minizoo.c.Entity;
import minizoo.i.Drawable;

public class Canvas extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	public void Update(float elapsed) {
		for (Entity entity : Entity.list) {
			entity.Update(elapsed);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		for (Entity entity : Entity.list) {
			if (entity instanceof Drawable) {
				Drawable drawable = (Drawable)entity;
				drawable.beforeDraw(g);
				drawable.Draw(g);
				drawable.afterDraw(g);
			}
		}
	}
}
