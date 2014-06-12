package minizoo.c.background;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import minizoo.App;
import minizoo.c.Entity;
import minizoo.c.Sprite;
import minizoo.c.action.Delay;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateTo;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.*;
import minizoo.c.core.Vector2d;

public class Background extends Entity {

	@Override
	public void update(float elapsed) {
        super.update(elapsed);

        int fac = 255 - Math.max(0, (int)(55 * (Math.sin(this.getRotation() - Math.PI/2)+1)));
        App.Instance().getCanvas().setGlobalTint(new Color(fac, fac, fac));
	}

	@Override
	public boolean intersect(Point2D point, AffineTransform base) {
		return false;
	}

	public Background(String name) {
		super(name);

        this.setPosition(new Vector2d(App.ScreenWidth/2, App.ScreenHeight));
        this.setAnchor(new Vector2d(0.5, 1));
        this.setContentSize(new Vector2d(App.ScreenWidth, App.ScreenHeight));

        sun = new Sun(name + ":Sun");
        sun.setPosition(new Vector2d(1136, 108));
        this.addChild(sun, 0);

        this.runAction(Forever.c(Sequence.c(EaseInSine.c(RotateTo.c(0.8f, (float) -Math.PI)), Delay.c(3f))));
	}

    @Override
    public void visit(Graphics2D g2) {
        Color dayColor = new Color(208, 244, 247);
        g2.setColor(dayColor);
        g2.fillRect(-240, 0, App.ScreenWidth * 2 + 240, App.ScreenHeight);

        Color nightColor = new Color(94, 63, 107);
        g2.setColor(nightColor);
        g2.fillRect(-240, App.ScreenHeight, App.ScreenWidth * 2 + 240, App.ScreenHeight);
    }

    Sprite sprBackground;
    Sun sun;
}
