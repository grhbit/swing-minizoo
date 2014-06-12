package minizoo.c.animal.duck;

import java.awt.Graphics2D;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateTo;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.core.Vector2d;

public class DuckNeck extends Entity
{
	private DuckHead head;
	
	public DuckNeck(String name) 
	{
		super(name);
		
		head = new DuckHead(name + ":Head");
        head.setPosition(new Vector2d(-195+100, -300+100));
        addChild(head);
		
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
        			)
        		)
        	)
        );
	}

	public void visit(Graphics2D g2)
	{
		g2.setColor(getTintedColor(Duck.SUBBODYCOLOR));
		g2.fillRect(-85,-200,95,200);
		g2.setColor(getTintedColor(Duck.BODYCOLOR));
		g2.fillRect(-85,-200,90,200);
	}
	
	public DuckHead getHead()
	{
		return head;
	}
	public void setHead(DuckHead head)
	{
		this.head = head;
	}
}
