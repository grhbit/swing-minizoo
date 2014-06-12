package minizoo;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import minizoo.c.Animal;
import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;
    BufferedImage backBuffer;

	public Canvas() {
		setOpaque(true);
		setDoubleBuffered(true);

        backBuffer = new BufferedImage(App.ScreenWidth, App.ScreenHeight, BufferedImage.TYPE_INT_RGB);
	}

	public void update(float elapsed) {
		for (Entity entity : Entity.list) {
			entity.update(elapsed);

            if (entity instanceof Animal && (entity != App.Instance().getTouch().getCurrentDrag())) {
                Vector2d pos = entity.getPosition();

                float groundY = App.ScreenHeight - (float)entity.getBoundingBox().getMinY() - 200f;
                if (pos.y < groundY) {
                    pos.y += (groundY - pos.y) * elapsed;
                } else {
                    pos.y -= 10f * elapsed;
                }

                entity.setPosition(pos);
            }
		}
	}

	@Override
	public void paint(Graphics g) {
        super.paint(g);

		Graphics2D g2 = (Graphics2D)g;

        Graphics backBufferGraphic = backBuffer.createGraphics();
        Graphics2D backBufferGraphics2D = (Graphics2D)backBufferGraphic;

		// Anti-aliasing
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        backBufferGraphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);


		for (Entity entity : Entity.list) {
            entity.setTint(getGlobalTint());
            entity.draw(backBufferGraphics2D);
		}

        // Stretch to design resolution.
        g2.scale((double) getWidth() / App.ScreenWidth, (double) getHeight() / App.ScreenHeight);
        g2.drawRenderedImage(backBuffer, null);
	}

    public void setGlobalTint(Color globalTint) {
        this.globalTint = globalTint;
    }
    public Color getGlobalTint() {
        return globalTint;
    }

    Color globalTint = new Color(0, 0, 0, 0);
}
