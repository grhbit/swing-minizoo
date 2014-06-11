package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.RotateBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearLeftArm extends Entity {
    public BearLeftArm(String name) {
        super(name);

        this.setContentSize(new Vector2d(112, 62));
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
        g2.rotate(Math.PI * 1 / 2.0);
        g2.fillRoundRect(30, 150, 150, 100, 30, 30);

        g2.rotate(Math.PI * -0.5);
        g2.fillRoundRect(-250, 120, 200, 100, 30, 30);

        g2.setColor(getTintedColor(Bear.InSkinColor));
        g2.fillOval(-100, 100, 150, 150);

        g2.rotate(Math.PI * 0.7);
        g2.setColor(getTintedColor(Bear.WhiteColor));
        g2.fillRect(0, -100, 650, 30);

        g2.rotate(Math.PI * -0.5);
        g2.setColor(getTintedColor(Color.red));
        g2.fillRect(0, 0, 200, 30);
    }
}
