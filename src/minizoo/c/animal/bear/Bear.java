package minizoo.c.animal.bear;

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

public class Bear extends Animal {
	public final static Color InSkinColor = new Color(162, 99, 18); // Entity
																	// body,
																	// face
																	// color
	public final static Color OutSkinColor = new Color(100, 62, 14);
	public final static Color MouthColor = new Color(255, 0, 0); // fur
																	// sub-color
	public final static Color BlackColor = new Color(0, 0, 0); // white of the
																// eye color
	public final static Color WhiteColor = new Color(255, 255, 255); // white of
																		// the
																		// eye
																		// color

	public Bear(String name) {
		super(name);

		this.setScale(new Vector2d(0.20f, 0.20f));
        this.setContentSize(300, 300);
        isLDir = false;

		body = new BearBody(name + ":Body");
		addChild(body);

        movingStart();
	}

	public void doDance(boolean begin) {

		if (begin) {
            this.stopAllAction();
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

			this.getBody()
					.getHead()
					.runAction(
							new Forever(new Sequence(new EaseLinear(
									new RotateBy(0.5f, 1f)), new EaseLinear(
									new RotateBy(0.5f, -1f)))));

			this.getBody()
					.getRightLeg()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 7f)))));

			this.getBody()
					.getLeftLeg()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 7f)))));

			this.getBody()
					.getSki()
					.runAction(
							new Forever(new Sequence(new EaseInSine(new MoveBy(
									2f, -200f, 0f)), new Instant(new MoveBy(
									0.0000001f, 200f, 0f)))));
            movingStop();
		} else {
			this.stopAllAction();
			this.getBody().getLeftArm().stopAllAction();
			this.getBody().getRightArm().stopAllAction();
			this.getBody().getLeftLeg().stopAllAction();
			this.getBody().getRightLeg().stopAllAction();
			this.getBody().getHead().stopAllAction();
			this.getBody().getSki().stopAllAction();

			this.getBody()
					.getRightArm()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 5f)))));
			this.getBody()
					.getLeftArm()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 5f)))));

			this.getBody()
					.getHead()
					.runAction(
							new Forever(new Sequence(new Instant(new MoveBy(
									0.13f, 20f, 0f)), new EaseInOutSine(
									new MoveBy(0.13f, -20f, 0f)))));

			this.getBody()
					.getRightLeg()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 5f)))));

			this.getBody()
					.getLeftLeg()
					.runAction(
							new Forever(new Sequence(new EaseInOutSine(
									new RotateBy(2f, 5f)))));

			this.getBody()
					.getSki()
					.runAction(
							new Forever(new Sequence(new EaseInSine(new MoveBy(
									2f, -400f, 0f)), new Instant(new MoveBy(
									0.0000001f, 400f, 0f)))));
            movingStart();
        }
	}

	public BearBody getBody() {
		return body;
	}

	public void setBody(BearBody body) {
		this.body = body;
	}

	BearBody body;
}
