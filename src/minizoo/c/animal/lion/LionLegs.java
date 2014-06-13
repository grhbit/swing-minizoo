package minizoo.c.animal.lion;

import java.awt.Graphics2D;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

public class LionLegs extends Entity
{
	private boolean isnear = true;
	
	public LionLegs(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
		
		this.setContentSize(new Vector2d(80,150));
	}
	
	public void IsNear(boolean isnear)
	{
		this.isnear = isnear;
	}
	
	public void visit(Graphics2D g2)
	{
		if(isnear)
			g2.setColor(getTintedColor(Lion.BODYCOLOR));
		else
			g2.setColor(getTintedColor(Lion.BACKLEGCOLOR));
		
		g2.fillRoundRect(0,10,100,170,20,30);
	}
}
