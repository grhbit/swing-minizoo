package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearSki extends Entity {
    public BearSki(String name) {
        super(name);

        this.setContentSize(new Vector2d(62, 112));

        this.runAction(
                new Forever(
                        new Sequence(
                                new EaseInSine(
                                        new MoveBy(2f, -400f, 0f)),
                                new Instant(
                                        new MoveBy(0.0000001f, 400f, 0f))
                        )
                )
        );
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Bear.BlackColor));
        g2.fillRect(0, 0, 700, 40);
    }
}
