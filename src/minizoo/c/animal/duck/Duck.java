package minizoo.c.animal.duck;

import java.awt.Color;
import java.awt.geom.Point2D;

import minizoo.c.Animal;
import minizoo.c.action.Delay;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.RotateTo;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.action.easing.EaseOutSine;
import minizoo.c.core.Vector2d;
import minizoo.e.State;

public class Duck extends Animal
{
	private DuckBody body;
	public static final Color BODYCOLOR = new Color(255,255,255);
	public static final Color FRONTLEGCOLOR = new Color(255,210,0);
	public static final Color BACKLEGCOLOR = Color.ORANGE;
	public static final Color MOUTHCOLOR = new Color(255,200,0);
	public static final Color SUBBODYCOLOR = new Color(220,220,220);
	public static final Color EYECOLOR = new Color(0,0,0);
	public static final Color WINGCOLOR = new Color(220,220,220);
	
	public Duck(String name) 
	{
		super(name);
		
		this.setScale(new Vector2d(0.2f, 0.2f));

		currState = State.Normal;
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
    public void doDance(boolean isEnabled) {
        if (isEnabled) {
            normalAction(false);
            pickingAction(false);
            dancingAction(true);
        } else {
            dancingAction(false);
            pickingAction(false);
            normalAction(true);
        }
    }

    @Override
    public void Press(boolean isPress, Point2D pos) {

        if (isPress) {
            normalAction(false);
            dancingAction(false);
            pickingAction(true);
        } else {
            pickingAction(false);
            dancingAction(false);
            normalAction(true);
        }
    }

    void allActionStop() {
        this.stopAllAction();
        getBody().reset();
        getBody().stopAllAction();
        getBody().getFarleg().stopAllAction();
        getBody().getNearleg().stopAllAction();
        getBody().getNeck().stopAllAction();
        getBody().getFrontwing().stopAllAction();
        getBody().getBackwing().stopAllAction();
        getBody().getBodyinternal().stopAllAction();
        getBody().getNeck().getHead().stopAllAction();
        getBody().getNeck().getHead().getEye().stopAllAction();
        getBody().getNeck().getHead().getMouth().stopAllAction();
    }

    public void normalAction (boolean isStart) {
        prevState = currState;
        currState = State.Normal;

        if (prevState != State.Normal) 
        {
            allActionStop();
            System.out.println(1);
            this.getBody().getNeck().runAction
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
            this.getBody().getFarleg().runAction
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
            this.getBody().getNearleg().runAction
            (
            	new Forever
                (
                	new Sequence
                	(
                		new EaseInSine
                		(
                			new RotateTo(0.5f, 0.3f)
                		),
                		new EaseInSine
                		(
                			new RotateTo(0.5f, -0.3f)
                		),
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
            this.runAction
            (
            	new Forever
                (
                	new Sequence
                	(
                		new EaseInSine
                		(
                			new MoveBy(1f, -40f, 0f)
                		)
               
                	)
                )
            );
        } else if (!isStart)
        {
            allActionStop();
        }
    }
    public void dancingAction(boolean isStart)
    {
    	prevState = currState;
        currState = State.Dancing;

        if (prevState != State.Dancing) 
        {
        	this.getBody().getNeck().stopAllAction();
        	this.getBody().runAction(MoveBy.c(0f,0f,200f));
    		this.getBody().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        		new EaseInSine
    	        		(
    	        			new MoveBy(1f, 0f, -200f)
    	        		),
    	        		new EaseInSine
    	        		(
    	        			new MoveBy(1f, 0f, 200f)
    	        		)
    	        	)
    	        )
    	     );
    		this.getBody().getFrontwing().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        			new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
    	        			new Delay(1f)
    	        	)
    	        )
    	     );
    		this.getBody().getBackwing().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        			new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
    	        			new Delay(1f)
    	        	)
    	        )
    	     );
        }
        else if (!isStart) 
        {
            allActionStop();
        }
    }
    public void pickingAction(boolean isStart)
    {
    	prevState = currState;
        currState = State.Picking;

        if (prevState != State.Picking) 
        {
        	this.getBody().getNeck().stopAllAction();
        	this.getBody().runAction(MoveBy.c(0f,0f,200f));
    		this.getBody().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        		new EaseInSine
    	        		(
    	        			new MoveBy(1f, 0f, -200f)
    	        		),
    	        		new EaseInSine
    	        		(
    	        			new MoveBy(1f, 0f, 200f)
    	        		)
    	        	)
    	        )
    	     );
    		this.getBody().getFrontwing().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        			new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
    	        			new Delay(1f)
    	        	)
    	        )
    	     );
    		this.getBody().getBackwing().runAction
    		(
    			new Forever
    			(
    	        	new Sequence
    	        	(
    	        			new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, -0.6f)
        	        		),
        	        		new EaseInSine
        	        		(
        	        			new RotateTo(0.25f, 0.6f)
        	        		),
    	        			new Delay(1f)
    	        	)
    	        )
    	     );
        }
        else if (!isStart) 
        {
            allActionStop();
        }
    }
}
