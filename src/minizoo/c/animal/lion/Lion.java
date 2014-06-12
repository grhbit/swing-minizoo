package minizoo.c.animal.lion;

import java.awt.Color;

import minizoo.c.Animal;
import minizoo.c.core.Vector2d;

public class Lion extends Animal
{
	private LionBody body;
	
	public static Color BODYCOLOR = new Color(255,255,0);
	public static Color SUBHEADCOLOR = new Color(170,160,0);
	public static Color BACKLEGCOLOR = new Color(245,235,0);
	public static Color NOSECOLOR = new Color(255,0,0);
	public static Color EYECOLOR = new Color(0,0,0);
	public static Color LINECOLOR = new Color(0,0,0);
	public static Color MOUTHCOLOR = new Color(255,0,0);
	
	public Lion(String name) 
	{
		super(name);
		
		this.setScale(new Vector2d(0.2f, 0.2f));

        body = new LionBody(name + ":Body");
        addChild(body);
    }

    public LionBody getBody() 
    {
        return body;
    }
    public void setBody(LionBody body) 
    {
        this.body = body;
    }
}
