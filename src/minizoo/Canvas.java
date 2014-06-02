package minizoo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import minizoo.c.Entity;
import minizoo.i.Drawable;

public class Canvas extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	public Canvas() {
		setOpaque(true);
		setDoubleBuffered(true);
	}
	
	public void Update(float elapsed) {
		for (Entity entity : Entity.list) {
			entity.Update(elapsed);
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		// Clear color-buffer
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		g2.setColor(Color.BLACK);
		
		// Anti-aliasing
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	
		
		for (Entity entity : Entity.list) {
			if (entity instanceof Drawable) {
				Drawable drawable = (Drawable)entity;
				drawable.draw(g);
			}
		}
	}
}
