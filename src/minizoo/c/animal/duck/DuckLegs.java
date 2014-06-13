package minizoo.c.animal.duck;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import minizoo.c.Entity;

public class DuckLegs extends Entity
{
	private boolean isNear;
	
	public DuckLegs(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void setNearLeg(boolean isNear) {
        this.isNear = isNear;
    }
	
	public void visit(Graphics2D g2)
	{
		if(isNear)
		{
			g2.setColor(getTintedColor(Duck.FRONTLEGCOLOR));
			g2.fillRect(60,0,20,160);
			g2.fillRect(-10, 140, 120, 40);
			g2.fill(new Ellipse2D.Double(-30,140,50,40));
		}
		else
		{
			g2.setColor(getTintedColor(Duck.BACKLEGCOLOR));
			g2.fillRect(60, 0, 20, 120);
			g2.fillRect(-10, 100, 120, 40);
			g2.fill(new Ellipse2D.Double(-30,100,50,40));
		}
	}
	public boolean getIsNear()
	{
		return isNear;
	}
	public void setIsNear(boolean isNear)
	{
		this.isNear = isNear;
	}
}
