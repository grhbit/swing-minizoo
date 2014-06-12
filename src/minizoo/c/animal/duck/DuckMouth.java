package minizoo.c.animal.duck;

import java.awt.Graphics2D;
import minizoo.c.Entity;

public class DuckMouth extends Entity
{
	public DuckMouth(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void visit(Graphics2D g2)
	{
		g2.setColor(getTintedColor(Duck.MOUTHCOLOR));
		g2.fillRect(0, 0, 170, 30);
		g2.fillRect(50, 30, 120, 20);
	}
}
