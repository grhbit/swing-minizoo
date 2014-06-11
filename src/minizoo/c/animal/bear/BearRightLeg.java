package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearRightLeg extends Entity {
    public BearRightLeg(String name) {
        super(name);

        this.setContentSize(new Vector2d(62, 112));
        this.runAction(
                new Forever(
                        new Sequence(
                                new EaseInOutSine(
                                        new RotateBy(2f, 5f))
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
        g2.setColor(getTintedColor(Bear.OutSkinColor));
        g2.rotate(Math.PI * 1 / 3.0);
        g2.fillOval(275, 180, 190, 112);

        g2.setColor(getTintedColor(Bear.InSkinColor));
        g2.rotate(Math.PI * -2 / 9.0);
        g2.fillRoundRect(50, 180, 130, 200, 30, 30);

    }
}
