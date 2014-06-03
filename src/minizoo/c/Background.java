package minizoo.c;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import minizoo.App;

public class Background extends Entity {
	
	@Override
	public void update(float elapsed) {
	}

	@Override
	public boolean intersect(Point2D point) {
		return false;
	}

	BufferedImage image;

	public Background(String name) {
		super(name);
		try {
			image = ImageIO.read(new File("resources/anamanaguchi.png"));
			scale.x = App.ScreenWidth / (double)image.getWidth();
			scale.y = App.ScreenHeight / (double)image.getHeight();
		} catch (Exception e) {
			System.err.println(this + " Image loading failed");
		}
	}

	@Override
	public void visit(Graphics2D g2) {
		super.visit(g2);
		g2.drawImage(image, new AffineTransform(), null);
	}
}
