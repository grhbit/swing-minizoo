package minizoo.c.animal.penguin;

import minizoo.c.Animal;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateTo;

import java.awt.*;

public class Penguin extends Animal {
    public static final Color brandColor = new Color(49, 56, 82);
    public static final Color subBrandColor = new Color(32, 39, 62);
    public static final Color bodyPointColor = new Color(250, 215, 27);
    public static final Color legPointColor = new Color(255, 153, 51);
    public static final Color mouseColor = new Color(221, 43, 83);
    public static final Color innerMouseColor = new Color(85, 17, 32);
    public static final Color whiteColor = new Color(255, 252, 249);
    public static final Color blackColor = new Color(37, 37, 37);

    public Penguin(String name) {
        super(name);

        this.setScale(0.3f, 0.3f);

        body = new PenguinBody(name + ":body");
        this.addChild(body);

        getBody().getLeftLeg().runAction(Forever.c(RotateTo.c(10f, 10f)));
        getBody().getLeftArm().runAction(Forever.c(RotateTo.c(10f, 10f)));
        getBody().getRightLeg().runAction(Forever.c(RotateTo.c(10f, -10f)));
        getBody().getRightArm().runAction(Forever.c(RotateTo.c(10f, -10f)));
    }

    public PenguinBody getBody() {
        return body;
    }
    PenguinBody body;
}
