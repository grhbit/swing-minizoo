package minizoo.c.animal.panda;

import minizoo.c.Animal;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.RotateBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.action.easing.EaseLinear;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class Panda extends Animal {
	public final static Color WhiteColor = new Color(225, 225, 225); // Entity
																		// body,
																		// face
																		// color
	public final static Color MouthColor = new Color(255, 0, 0); // fur
																	// sub-color
	// public final static Color skinColor = new Color(192, 157, 123); // skin
	// color
	public final static Color BlackColor = new Color(0, 0, 0); // white of the
																// eye color
	// public final static Color softBlackColor = new Color(43, 43, 43); // eyes
	// color
	// public final static Color mouseColor = new Color(234, 143, 143); // mouse
	// color
	// public final static Color tougueColor = new Color(202, 105, 105); //
	// tougue color
	// public final static Color hoofColor = new Color(64, 43, 21); // hoof
	// color
	public final static Color DarkWhiteColor = new Color(181, 181, 181);

	public Panda(String name) {
		super(name);

		
		this.setScale(new Vector2d(0.24f, 0.24f));

		body = new PandaBody(name + ":Body");
		addChild(body);

		//this.stopAllAction();
		/*this.getBody().stopAllAction();
		this.getBody().getLeftArm().stopAllAction();
		this.getBody().getRightArm().stopAllAction();
		this.getBody().getLeftLeg().stopAllAction();
		this.getBody().getRightLeg().stopAllAction();
		this.getBody().getHead().stopAllAction();
		//this.getBody().getHead().stopAllAction();
		
		this.getBody().runAction(
				new Forever(new Sequence(
						new EaseLinear(new RotateBy(0.5f, 1f)), new EaseLinear(
								new RotateBy(0.5f, -1f)))));

		this.getBody()
				.getRightArm()
				.runAction(
						new Forever(new Sequence(new Instant(new MoveBy(0.5f,
								40f, 10f)), new EaseInOutSine(new MoveBy(0.5f,
								-40f, -10f)))));
		this.getBody()
				.getLeftArm()
				.runAction(
						new Forever(new Sequence(new Instant(new MoveBy(0.13f,
								30f, 0f)), new EaseInOutSine(new MoveBy(0.13f,
								-30f, 0f)))));*/

	}

	public void doDance(boolean begin) {

		if (begin) {
			this.stopAllAction();
			this.getBody().stopAllAction();
			this.getBody().getLeftArm().stopAllAction();
			this.getBody().getRightArm().stopAllAction();
			this.getBody().getLeftLeg().stopAllAction();
			this.getBody().getRightLeg().stopAllAction();
			this.getBody().getHead().stopAllAction();
			
			this.getBody().runAction(
					new Forever(new Sequence(new EaseLinear(new RotateBy(0.5f,
							1f)), new EaseLinear(new RotateBy(0.5f, -1f)))));

			this.getBody()
					.getRightArm()
					.runAction(
							new Forever(new Sequence(new Instant(new MoveBy(
									0.5f, 40f, 10f)), new EaseInOutSine(
									new MoveBy(0.5f, -40f, -10f)))));
			this.getBody()
					.getLeftArm()
					.runAction(
							new Forever(new Sequence(new Instant(new MoveBy(
									0.13f, 30f, 0f)), new EaseInOutSine(
									new MoveBy(0.13f, -30f, 0f)))));
		} else {
			this.stopAllAction();
			this.getBody().stopAllAction();
			this.getBody().getLeftArm().stopAllAction();
			this.getBody().getRightArm().stopAllAction();
			this.getBody().getLeftLeg().stopAllAction();
			this.getBody().getRightLeg().stopAllAction();
			this.getBody().getHead().stopAllAction();
			
			this.getBody().getHead().runAction(
	                new Forever(
	                        new Sequence(
	                                new EaseLinear(
	                                        new RotateBy(1f, 0.5f)),
	                                new EaseLinear(
	                                        new RotateBy(1f, -0.5f))
	                        )
	                )
	        );
			
			this.getBody().getLeftArm().runAction(
	                new Forever(
	                        new Sequence(
	                                new Instant(
	                                        new MoveBy(0.13f, 20f, 0f)),
	                                new EaseInOutSine(
	                                        new MoveBy(0.13f, -20f, 0f))
	                        )
	                )
	        );
			
			this.getBody().getRightArm().runAction(new Forever(
                        new Sequence(
                                new Instant(
                                        new MoveBy(0.13f, 20f, 0f)),
                                new EaseInOutSine(
                                        new MoveBy(0.13f, -20f, 0f))
                        )
                )
			);
			
			this.getBody().getLeftLeg().runAction(
	                new Forever(
	                        new Sequence(
	                                new EaseInOutSine(
	                                        new RotateBy(1f, 2f)),
	                                new EaseInSine(
	                                        new RotateBy(1f, -2f))
	                        )
	                )
	        );
			
			this.getBody().getRightLeg().runAction(
	                new Forever(
	                        new Sequence(
	                                new EaseInOutSine(
	                                        new RotateBy(1f, 2f)),
	                                new EaseInSine(
	                                        new RotateBy(1f, -2f))
	                        )
	                )
	        );
			
		}

	}

	public PandaBody getBody() {
		return body;
	}

	public void setBody(PandaBody body) {
		this.body = body;
	}

	PandaBody body;
}
