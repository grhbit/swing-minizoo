package minizoo.c.animal.lion;

import java.awt.Color;
import java.awt.geom.Point2D;

import minizoo.c.Animal;
import minizoo.c.action.Delay;
import minizoo.c.action.Forever;
import minizoo.c.action.MoveBy;
import minizoo.c.action.RotateTo;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.core.Vector2d;
import minizoo.e.State;

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

		currState = State.Normal;
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
        getBody().getHead().stopAllAction();
        getBody().getTail().stopAllAction();
        getBody().getLeftfarleg().stopAllAction();
        getBody().getLeftnearleg().stopAllAction();
        getBody().getRightfarleg().stopAllAction();
        getBody().getRightnearleg().stopAllAction();
        getBody().getBodyinternal().stopAllAction();
        getBody().getHead().getLefteye().stopAllAction();
        getBody().getHead().getRighteye().stopAllAction();
        getBody().getHead().getNose().stopAllAction();
        getBody().getHead().getMouth().stopAllAction();
    }

    public void normalAction (boolean isStart) {
        prevState = currState;
        currState = State.Normal;

        if (prevState != State.Normal) 
        {
            allActionStop();
            this.getBody().getTail().runAction
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
            this.runAction(new Forever(new Sequence(new Delay(0.5f),new EaseInSine(MoveBy.c(1f,-200f,0f)),new Delay(2f))));
            this.getBody().getLeftfarleg().runAction
            (
            	new Forever
            	(
            		new Sequence
            		(
            			new EaseInSine
            			(
            				new RotateTo(0.5f, 1f)
            			),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, -1f)
            			),
            			new Delay(2.5f)
            		)
            	)
            );
            this.getBody().getLeftnearleg().runAction
            (
            	new Forever
            	(
            		new Sequence
            		(
            			new EaseInSine
            			(
            				new RotateTo(0.5f, 1f)
            			),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, -1f)
            			),
            			new Delay(2.5f)
            		)
            	)
            );
            this.getBody().getRightfarleg().runAction
            (
            	new Forever
            	(
            		new Sequence
            		(
            			new Delay(0.5f),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, -1f)
            			),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, 1f)
            			),
            			new Delay(2f)
            		)
            	)
            );
            this.getBody().getRightnearleg().runAction
            (
            	new Forever
            	(
            		new Sequence
            		(
            			new Delay(0.5f),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, -1f)
            			),
            			new EaseInSine
            			(
            				new RotateTo(0.5f, 1f)
            			),
            			new Delay(2f)
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
this.allActionStop();
        	
        	this.getBody().runAction(new MoveBy(0.5f, 0f, 25f));
        	this.getBody().runAction(new RotateTo(0.5f, 1f));
        	this.getBody().getLeftfarleg().runAction(new RotateTo(0.5f,0.5f));
        	this.getBody().getLeftnearleg().runAction(new RotateTo(0.5f,0.5f));
        	this.getBody().getRightfarleg().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getRightnearleg().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getRightfarleg().runAction(new MoveBy(0.5f, 90f, 20f));
        	this.getBody().getLeftfarleg().runAction(new MoveBy(0.5f, 50f, 0f));
        	this.getBody().getHead().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getTail().runAction
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
        	this.getBody().runAction
        	(
        		new Forever
        		(	
        			new Sequence
        			(
        				new EaseInSine
        				(
        					new MoveBy(0.5f, 0f, -50f)
        				),
        				new EaseInSine
        				(
        					new MoveBy(0.5f, 0f, 50f)
        				)
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
        	this.allActionStop();
        	
        	this.getBody().runAction(new MoveBy(0.5f, 0f, 25f));
        	this.getBody().runAction(new RotateTo(0.5f, 1f));
        	this.getBody().getLeftfarleg().runAction(new RotateTo(0.5f,0.5f));
        	this.getBody().getLeftnearleg().runAction(new RotateTo(0.5f,0.5f));
        	this.getBody().getRightfarleg().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getRightnearleg().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getRightfarleg().runAction(new MoveBy(0.5f, 90f, 20f));
        	this.getBody().getLeftfarleg().runAction(new MoveBy(0.5f, 50f, 0f));
        	this.getBody().getHead().runAction(new RotateTo(0.5f,-1f));
        	this.getBody().getTail().runAction
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
        	this.getBody().runAction
        	(
        		new Forever
        		(	
        			new Sequence
        			(
        				new EaseInSine
        				(
        					new MoveBy(0.5f, 0f, -50f)
        				),
        				new EaseInSine
        				(
        					new MoveBy(0.5f, 0f, 50f)
        				)
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
