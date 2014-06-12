package minizoo.c.animal.lion;

import java.awt.Graphics2D;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

public class LionBody extends Entity
{
	private LionBodyInternal bodyinternal;
	private LionHead head;
	private LionLegs leftnearleg;
	private LionLegs leftfarleg;
	private LionLegs rightnearleg;
	private LionLegs rightfarleg;
	private LionTail tail;
	
	public class LionBodyInternal extends Entity
	{

		public LionBodyInternal(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
		
		public void visit(Graphics2D g2)
		{
			g2.setColor(getTintedColor(Lion.BODYCOLOR));
			g2.fillRoundRect(0, 0, 600, 400, 200, 200);
		}
	}
	
	public LionBody(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
		
		this.setContentSize(new Vector2d(600,400));

		leftfarleg = new LionLegs(name + "Leftfarleg");
		leftfarleg.setPosition(new Vector2d(50,400));
		leftfarleg.IsNear(false);
		addChild(leftfarleg);
		
		leftnearleg = new LionLegs(name + "Leftnearleg");
		leftnearleg.setPosition(new Vector2d(170,430));
		leftnearleg.IsNear(true);
		addChild(leftnearleg);
		
		rightfarleg = new LionLegs(name + "Rightfarleg");
		rightfarleg.setPosition(new Vector2d(400,400));
		rightfarleg.IsNear(false);
		addChild(rightfarleg);
		
		rightnearleg = new LionLegs(name + "Rightnearleg");
		rightnearleg.setPosition(new Vector2d(520,430));
		rightnearleg.IsNear(true);
		addChild(rightnearleg);
		
		bodyinternal = new LionBodyInternal(name + "Body");
		addChild(bodyinternal,7);
		
		head = new LionHead(name + "Head");
		head.setPosition(new Vector2d(40,40));
		addChild(head,8);
		
		tail = new LionTail(name + "Tail");
		tail.setPosition(new Vector2d(550,100));
		addChild(tail);
	}
	
	public LionLegs getLeftfarleg()
	{
		return leftfarleg;
	}
	public LionLegs getRightfarleg()
	{
		return rightfarleg;
	}
	public LionLegs getLeftnearleg()
	{
		return leftnearleg;
	}
	public LionLegs getRightnearleg()
	{
		return rightnearleg;
	}
	public LionBodyInternal getBodyInternal()
	{
		return bodyinternal;
	}
	public LionTail getTail()
	{
		return tail;
	}
	public LionHead getHead()
	{
		return head;
	}
	
	public void setLeftfarleg(LionLegs leftfarleg)
	{
		this.leftfarleg = leftfarleg;
	}
	public void setRightfarleg(LionLegs rightfarleg)
	{
		this.rightfarleg = rightfarleg;
	}
	public void setLeftnearleg(LionLegs leftnearleg)
	{
		this.leftnearleg = leftnearleg;
	}
	public void setRightnearleg(LionLegs rightnearleg)
	{
		this.rightnearleg = rightnearleg;
	}
	public void setBodyInternal(LionBodyInternal bodyinternal)
	{
		this.bodyinternal = bodyinternal;
	}
	public void setTail(LionTail tail)
	{
		this.tail = tail;
	}
	public void setHead(LionHead head)
	{
		this.head = head;
	}
}
