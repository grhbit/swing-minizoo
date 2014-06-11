package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearEye extends Entity {
    public BearEye(String name) {
        super(name);

        this.setContentSize(new Vector2d(100, 80));
    }

    public void blink() {
        blinkBeginTime = getUpdatedTime();
        blinkEndTime = getUpdatedTime() + 0.3f;
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Bear.OutSkinColor));
        g2.fillOval(0, 0, 100, 120);
        g2.setColor(getTintedColor(Bear.WhiteColor));
        g2.fillOval(10, 25, 80, 60);

        g2.setColor(getTintedColor(Bear.BlackColor));
        g2.fillOval(-0, 40, 50, 40);
    }

    float blinkFactor = 0f;
    float blinkBeginTime = 0f;
    float blinkEndTime = 0f;
}
