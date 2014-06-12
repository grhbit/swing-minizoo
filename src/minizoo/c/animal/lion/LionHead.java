package minizoo.c.animal.lion;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import minizoo.c.Entity;
import minizoo.c.animal.lion.LionBody.LionBodyInternal;
import minizoo.c.core.Vector2d;

public class LionHead extends Entity
{
	private LionHeadInternal headinternal;
	private LionEyes lefteye;
	private LionEyes righteye;
	private LionMouth mouth;
	private LionNose nose;
	
	public class LionHeadInternal extends Entity
	{

		public LionHeadInternal(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
		
		public void visit(Graphics2D g2)
		{
			g2.setColor(getTintedColor(Lion.SUBHEADCOLOR));
			
			g2.fill(new Ellipse2D.Double(180,-150,250,250));
			g2.fill(new Ellipse2D.Double(-20,-150,250,250));
			g2.fill(new Ellipse2D.Double(-150,0,250,250));
			g2.fill(new Ellipse2D.Double(-150,170,250,250));
			g2.fill(new Ellipse2D.Double(-20,280,250,250));
			g2.fill(new Ellipse2D.Double(180,280,250,250));
			g2.fill(new Ellipse2D.Double(310,0,250,250));
			g2.fill(new Ellipse2D.Double(310,170,250,250));
			
			g2.setColor(getTintedColor(Lion.BODYCOLOR));
			g2.fill(new Ellipse2D.Double(0,0,400,400));
		}
	}
	public LionHead(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
		
		this.setContentSize(new Vector2d(450,450));
		
		headinternal = new LionHeadInternal(name);
		headinternal.setPosition(new Vector2d(0,0));
		addChild(headinternal,0);
		
		lefteye = new LionEyes(name + "Eyes");
		lefteye.setPosition(new Vector2d(95,80));
		addChild(lefteye,4);
		
		righteye = new LionEyes(name + "Eyes");
		righteye.setPosition(new Vector2d(255,80));
		addChild(righteye,5);
		
		mouth = new LionMouth(name + "Mouth");
		mouth.setPosition(new Vector2d(160,190));
		addChild(mouth,7);
		
		nose = new LionNose(name + "Nose");
		nose.setPosition(new Vector2d(175,180));
		addChild(nose,8);
	}

	public LionHeadInternal getHeadinternal()
	{
		return headinternal;
	}
	public LionEyes getLefteye()
	{
		return lefteye;
	}
	public LionEyes getRighteye()
	{
		return righteye;
	}
	public LionMouth getMouth()
	{
		return mouth;
	}
	public LionNose getNose()
	{
		return nose;
	}
	
	public void setHeadinternal(LionHeadInternal headinternal)
	{
		this.headinternal = headinternal;
	}
	public void setLefteye(LionEyes lefteye)
	{
		this.lefteye = lefteye;
	}
	public void setRighteye(LionEyes righteye)
	{
		this.righteye = righteye;
	}
	public void setMouth(LionMouth mouth)
	{
		this.mouth = mouth;
	}
	public void setNose(LionNose nose)
	{
		this.nose = nose;
	}
}
