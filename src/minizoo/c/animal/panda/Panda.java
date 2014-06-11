package minizoo.c.animal.panda;

import minizoo.c.Animal;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class Panda extends Animal {
    public final static Color WhiteColor = new Color(225, 225, 225); // Entity body, face color
    public final static Color MouthColor = new Color(255, 0, 0); // fur sub-color
    //public final static Color skinColor = new Color(192, 157, 123); // skin color
    public final static Color BlackColor = new Color(0, 0, 0); // white of the eye color
    //public final static Color softBlackColor = new Color(43, 43, 43); // eyes color
    //public final static Color mouseColor = new Color(234, 143, 143); // mouse color
    //public final static Color tougueColor = new Color(202, 105, 105); // tougue color
    //public final static Color hoofColor = new Color(64, 43, 21); // hoof color
    public final static Color DarkWhiteColor = new Color(181, 181, 181);

    public Panda(String name) {
        super(name);

        this.setScale(new Vector2d(0.24f, 0.24f));

        body = new PandaBody(name + ":Body");
        addChild(body);
    }

    public PandaBody getBody() {
        return body;
    }

    public void setBody(PandaBody body) {
        this.body = body;
    }

    PandaBody body;
}
