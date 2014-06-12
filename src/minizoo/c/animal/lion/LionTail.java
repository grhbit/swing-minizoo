package minizoo.c.animal.lion;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateTo;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.core.Vector2d;

public class LionTail extends Entity
{

	public LionTail(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
		
		this.setContentSize(new Vector2d(160,30));
		
		this.runAction
        (
        	new Forever
        	(
        		new Sequence
        		(
        			new EaseInSine
        			(
        				new RotateTo(0.5f, -0.3f)
        			),
        			new EaseInSine
        			(
        				new RotateTo(0.5f, 0.3f)
        			),
        			new EaseInSine
        			(
        				new RotateTo(0.5f, 0.3f)
        			),
        			new EaseInSine
        			(
        				new RotateTo(0.5f, -0.3f)
        			)
        		)
        	)
        );
	}

	public void visit(Graphics2D g2)
	{
		g2.setColor(getTintedColor(Lion.BODYCOLOR));
		g2.fillRoundRect(0,0,300,30,80,10);
		g2.fill(new Ellipse2D.Double(280,-40,70,70));
		g2.fill(new Ellipse2D.Double(280,0,70,70));
		g2.fill(new Ellipse2D.Double(310,-60,70,70));
		g2.fill(new Ellipse2D.Double(310,20,70,70));
		g2.fill(new Ellipse2D.Double(340,-40,70,70));
		g2.fill(new Ellipse2D.Double(340,0,70,70));
	}
}
