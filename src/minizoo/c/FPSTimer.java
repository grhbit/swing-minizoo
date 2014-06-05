package minizoo.c;

import java.awt.Font;
import java.awt.Graphics2D;

import minizoo.c.core.Vector2d;

public class FPSTimer extends Entity {
	Font font;
	int frameCount = 0;
	float displayFrame = 0f;

	public FPSTimer() {
		super("FPS Timer");
		setAnchor(new Vector2d(0, -1));
		font = new Font("Arial", Font.PLAIN, 32);
		setContentSize(new Vector2d(100, 32));
	}

	@Override
	public void update(float elapsed) {
		super.update(elapsed);

		frameCount += 1;

		if (updatedTime >= 1) {
			displayFrame = (frameCount / updatedTime);

			updatedTime = 0;
			frameCount = 0;
		}
	}

	@Override
	public void visit(Graphics2D g2) {
		g2.setFont(font);
		g2.drawString("" + displayFrame, 0, 0);
	}
}
