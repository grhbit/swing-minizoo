package minizoo.c.animal.lion;

import java.awt.Graphics2D;

import minizoo.c.Entity;

public class LionNose extends Entity
{

	public LionNose(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void visit(Graphics2D g2)
	{
		g2.setColor(getTintedColor(Lion.LINECOLOR));
		g2.fillOval(-70, -10, 100, 100);
		g2.fillOval(0, -10, 100, 100);
		g2.setColor(getTintedColor(Lion.BODYCOLOR));
		g2.fillOval(-65, -5,90,90);
		g2.fillOval(5, -5, 90, 90);
		g2.setColor(getTintedColor(Lion.LINECOLOR));
		g2.fillRect(15, 0, 5, 70);
		g2.setColor(getTintedColor(Lion.NOSECOLOR));
		g2.fillOval(0,-30,40,40);
	}
}
