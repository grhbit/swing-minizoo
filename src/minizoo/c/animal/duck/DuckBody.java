package minizoo.c.animal.duck;

import java.awt.Graphics2D;
import java.awt.geom.*;

import minizoo.c.Entity;
import minizoo.c.animal.lion.LionHead;
import minizoo.c.animal.lion.LionLegs;
import minizoo.c.animal.lion.LionTail;
import minizoo.c.animal.lion.LionBody.LionBodyInternal;
import minizoo.c.core.Vector2d;

public class DuckBody extends Entity
{
	private DuckBodyInternal bodyinternal;
	private DuckLegs nearleg;
	private DuckLegs farleg;
	private DuckNeck neck;
	private DuckWings frontwing;
	
	public class DuckBodyInternal extends Entity
	{

		public DuckBodyInternal(String name) 
		{
			super(name);
		}
		
		@Override
        public void visit(Graphics2D g2)
		{
			g2.setColor(getTintedColor(Duck.SUBBODYCOLOR));
			g2.fill(new Ellipse2D.Double(100,-10,610,100));
			g2.setColor(getTintedColor(Duck.BODYCOLOR));
			g2.fill(new Ellipse2D.Double(100,0,600,90));
			g2.fill(new Ellipse2D.Double(100,0+80,500,90));
			g2.fill(new Ellipse2D.Double(100,0+160,400,90));
			g2.fill(new Ellipse2D.Double(0,20,400,220));
			g2.rotate(Math.toRadians(-10));
			g2.fill(new Ellipse2D.Double(430,140,200,100));
			g2.fill(new Ellipse2D.Double(340,200,200,100));
			g2.fill(new Ellipse2D.Double(550,130,200,40));
		}
	}
	
	public DuckBody(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
		
		this.setContentSize(new Vector2d(600,240));
        
		farleg = new DuckLegs(name + ":backLeg");
	    farleg.setPosition(new Vector2d(200, 230));
	    farleg.setNearLeg(false);
	    addChild(farleg,1);
	        
	    nearleg = new DuckLegs(name + ":frontLeg");
	    nearleg.setPosition(new Vector2d(170, 246));
	    nearleg.setNearLeg(true);
	    addChild(nearleg,2);
	    
		bodyinternal = new DuckBodyInternal(name + ":bodyInternal");
        addChild(bodyinternal,3);

        frontwing = new DuckWings(name + ":frontWing");
        frontwing.setPosition(new Vector2d(160, 10));
        addChild(frontwing,5);
        
        neck = new DuckNeck(name + ":Neck");
        neck.setPosition(new Vector2d(165, 90));
        addChild(neck);
	}
	
	public DuckLegs getFarleg()
	{
		return farleg;
	}
	public DuckLegs getNearleg()
	{
		return nearleg;
	}
	public DuckBodyInternal getBodyinternal()
	{
		return bodyinternal;
	}
	public DuckWings getFrontwing()
	{
		return frontwing;
	}
	public DuckNeck getNeck()
	{
		return neck;
	}
	public void setFarleg(DuckLegs farleg)
	{
		this.farleg = farleg;
	}
	public void setNearleg(DuckLegs nearleg)
	{
		this.nearleg = nearleg;
	}
	public void setBodyinternal(DuckBodyInternal bodyinternal)
	{
		this.bodyinternal = bodyinternal;
	}
	public void getFrontwing(DuckWings frontwing)
	{
		this.frontwing = frontwing;
	}
	public void setNeck(DuckNeck neck)
	{
		this.neck = neck;
	}
}
