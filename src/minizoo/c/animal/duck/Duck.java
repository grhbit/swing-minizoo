package minizoo.c.animal.duck;

import java.awt.Color;

import minizoo.c.Animal;
import minizoo.c.core.Vector2d;

public class Duck extends Animal
{
	private DuckBody body;
	public static final Color BODYCOLOR = new Color(255,255,255);
	public static final Color FRONTLEGCOLOR = new Color(255,200,0);
	public static final Color BACKLEGCOLOR = Color.ORANGE;
	public static final Color MOUTHCOLOR = new Color(255,200,0);
	public static final Color SUBBODYCOLOR = new Color(220,220,220);
	public static final Color EYECOLOR = new Color(0,0,0);
	public static final Color WINGCOLOR = new Color(220,220,220);
	
	public Duck(String name) 
	{
		super(name);
		
		this.setScale(new Vector2d(0.2f, 0.2f));

        body = new DuckBody(name + ":Body");
        addChild(body);
    }

    public DuckBody getBody() 
    {
        return body;
    }
    public void setBody(DuckBody body) 
    {
        this.body = body;
    }
}
