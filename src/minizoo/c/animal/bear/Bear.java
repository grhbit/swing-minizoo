package minizoo.c.animal.bear;

import minizoo.c.Animal;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class Bear extends Animal {
    public final static Color InSkinColor = new Color(162, 99, 18); // Entity body, face color
    public final static Color OutSkinColor = new Color(100, 62, 14);
    public final static Color MouthColor = new Color(255, 0, 0); // fur sub-color
    public final static Color BlackColor = new Color(0, 0, 0); // white of the eye color
    public final static Color WhiteColor = new Color(255, 255, 255); // white of the eye color

    public Bear(String name) {
        super(name);

        this.setScale(new Vector2d(0.24f, 0.24f));

        body = new BearBody(name + ":Body");
        addChild(body);
    }

    public BearBody getBody() {
        return body;
    }

    public void setBody(BearBody body) {
        this.body = body;
    }

    BearBody body;
}
