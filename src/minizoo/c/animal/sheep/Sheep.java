package minizoo.c.animal.sheep;

import minizoo.c.Animal;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class Sheep extends Animal {
    public final static Color brandColor = new Color(227, 227, 227); // fur color
    public final static Color subBrandColor = new Color(209, 204, 204); // fur sub-color
    public final static Color skinColor = new Color(192, 157, 123); // skin color
    public final static Color whiteOfTheEyeColor = new Color(229, 229, 229); // white of the eye color
    public final static Color softBlackColor = new Color(43, 43, 43); // eyes color
    public final static Color mouseColor = new Color(234, 143, 143); // mouse color
    public final static Color tougueColor = new Color(202, 105, 105); // tougue color
    public final static Color hoofColor = new Color(64, 43, 21); // hoof color

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    public Sheep(String name) {
        super(name);

        this.setScale(new Vector2d(0.3f, 0.3f));

        body = new SheepBody(name + ":Body");
        addChild(body);
    }

    public SheepBody getBody() {
        return body;
    }
    public void setBody(SheepBody body) {
        this.body = body;
    }
    SheepBody body;
}
