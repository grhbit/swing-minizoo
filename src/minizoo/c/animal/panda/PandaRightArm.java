package minizoo.c.animal.panda;

import minizoo.c.Entity;
import minizoo.c.action.Forever;
import minizoo.c.action.Instant;
import minizoo.c.action.MoveBy;
import minizoo.c.action.Sequence;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class PandaRightArm extends Entity {
    public PandaRightArm(String name) {
        super(name);

        this.setContentSize(new Vector2d(112, 62));
        this.runAction(
                new Forever(
                        new Sequence(
                                new Instant(
                                        new MoveBy(0.13f, 20f, 0f)),
                                new EaseInOutSine(
                                        new MoveBy(0.13f, -20f, 0f))
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
        g2.setColor(getTintedColor(Panda.BlackColor));
        g2.rotate(Math.PI * -1 / 6.0);
        g2.fillRoundRect(-30, 50, 200, 100, 30, 30);

        g2.setColor(getTintedColor(Panda.DarkWhiteColor));
        g2.fillOval(100, 30, 150, 150);

        g2.setColor(getTintedColor(Panda.WhiteColor));
        g2.fillOval(120, 50, 100, 100);
    }
}
