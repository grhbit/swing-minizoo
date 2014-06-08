package minizoo;

import java.awt.*;
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

	@Override
	public void paint(Graphics g) {
        super.paint(g);

		Graphics2D g2 = (Graphics2D)g;

		Graphics backBufferGraphic = backBuffer.createGraphics();
		Graphics2D backBufferGraphics2D = (Graphics2D)backBufferGraphic;

        // Backbuffer clearing
        backBufferGraphics2D.clearRect(0, 0, backBuffer.getWidth(), backBuffer.getHeight());

		// Anti-aliasing
		backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        // Stretch to design resolution.
        g2.scale((double) getWidth() / App.ScreenWidth, (double) getHeight() / App.ScreenHeight);

		for (Entity entity : Entity.list) {
			if (entity instanceof Drawable) {
				Drawable drawable = entity;

                drawable.setTint(getGlobalTint());
                drawable.draw(backBufferGraphic);
			}
		}

        // Motion Blur Code
        // backBufferGraphics2D.setTint(new Color(0, 0, 0, 128));
        // backBufferGraphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_OUT));
        // backBufferGraphics2D.fillRect(0, 0, backBuffer.getWidth(), backBuffer.getHeight());

        backBufferGraphic.dispose();

		// Present
        g2.drawRenderedImage(backBuffer, null);
	}

    public void setGlobalTint(Color globalTint) {
        this.globalTint = globalTint;
    }
    public Color getGlobalTint() {
        return globalTint;
    }

    Color globalTint = new Color(0, 0, 0, 0);
	BufferedImage backBuffer;
}
