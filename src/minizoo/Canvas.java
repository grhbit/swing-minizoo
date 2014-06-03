package minizoo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import minizoo.c.Entity;
import minizoo.i.Drawable;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;

	public Canvas() {
		setOpaque(true);
		setDoubleBuffered(true);

		backBuffer = new BufferedImage(App.ScreenWidth, App.ScreenHeight, BufferedImage.TYPE_INT_RGB);
	}

	public void update(float elapsed) {
		for (Entity entity : Entity.list) {
			entity.update(elapsed);
		}
	}

    double f=0.0;
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		Graphics backBufferGraphic = backBuffer.createGraphics();
		Graphics2D backBufferGraphics2D = (Graphics2D)backBufferGraphic;

		// Clear color-buffer
		backBufferGraphic.setColor(Color.gray);
		backBufferGraphic.fillRect(0, 0, App.ScreenWidth, App.ScreenHeight);
		backBufferGraphic.setColor(Color.white);

		// Anti-aliasing
		backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		for (Entity entity : Entity.list) {
			if (entity instanceof Drawable) {
				Drawable drawable = entity;
				drawable.draw(backBufferGraphic);
			}
		}
		backBufferGraphic.dispose();

        // Stretch to design resolution.
		g2.scale((double)getWidth()/App.ScreenWidth, (double)getHeight()/App.ScreenHeight);

		// Present
		g2.drawImage(backBuffer, new AffineTransform(), null);
	}

	BufferedImage backBuffer;
}
