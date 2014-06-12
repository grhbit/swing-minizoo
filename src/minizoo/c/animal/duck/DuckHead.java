package minizoo.c.animal.duck;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import minizoo.c.Entity;
import minizoo.c.animal.lion.LionEyes;
import minizoo.c.animal.lion.LionMouth;
import minizoo.c.animal.lion.LionNose;
import minizoo.c.animal.lion.LionHead.LionHeadInternal;
import minizoo.c.core.Vector2d;

public class DuckHead extends Entity
{
	private DuckMouth mouth;
	private DuckHeadInternal headinternal;
	private DuckEyes eye;
	
	public DuckHead(String name) {
		super(name);
		
		this.setContentSize(new Vector2d(210,210));
		
		headinternal = new DuckHeadInternal(name);
        headinternal.setPosition(new Vector2d(100-100,100-100));
        addChild(headinternal);
        
        eye = new DuckEyes(name + ":Eye");
        eye.setPosition(new Vector2d(150-100,150-100));
        addChild(eye);
        
        mouth = new DuckMouth(name + ":Mouth");
        mouth.setPosition(new Vector2d(30-100-50, 230-100));
        addChild(mouth);
        
	}

	public class DuckHeadInternal extends Entity
	{
		public DuckHeadInternal(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}

		public void visit(Graphics2D g2)
		{
			g2.setColor(getTintedColor(Duck.SUBBODYCOLOR));
			g2.fill(new Ellipse2D.Double(0,-1,221,221));
			g2.setColor(getTintedColor(Duck.BODYCOLOR));
			g2.fill(new Ellipse2D.Double(0,10,210,210));
			int [] x1 = {100,90,110};
			int [] y1 = {10,-20,-20};
			g2.fillPolygon(x1, y1, 3);
			int [] x2 = {90,90,70};
			int [] y2 = {-20,-30,-30};
			g2.fillPolygon(x2,y2,3);
			g2.fillRoundRect(90, -30, 22, 12, 5, 5);
		}
	}
	public DuckHeadInternal getHeadinternal()
	{
		return headinternal;
	}
	public DuckEyes getEye()
	{
		return eye;
	}
	public DuckMouth getMouth()
	{
		return mouth;
	}
	
	public void setHeadinternal(DuckHeadInternal headinternal)
	{
		this.headinternal = headinternal;
	}
	public void setRighteye(DuckEyes eye)
	{
		this.eye = eye;
	}
	public void setMouth(DuckMouth mouth)
	{
		this.mouth = mouth;
	}
}
