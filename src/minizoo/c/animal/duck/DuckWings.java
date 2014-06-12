package minizoo.c.animal.duck;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import minizoo.c.Entity;

public class DuckWings extends Entity
{

	public DuckWings(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void visit(Graphics2D g2)
	{
		g2.setColor(getTintedColor(Duck.WINGCOLOR));
		g2.fill(new Ellipse2D.Double(50,0,400,60));
		g2.fill(new Ellipse2D.Double(50,40,360,60));
		g2.fill(new Ellipse2D.Double(50,90,290,60));
		g2.fill(new Ellipse2D.Double(-10,20,200,120));
	}
}
