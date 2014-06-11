package minizoo.c.animal.bear;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class BearEar extends Entity {
    public BearEar(String name) {
        super(name);

        this.setContentSize(new Vector2d(150, 100));
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
        g2.fillOval(0, 0, 150, 150);

        g2.setColor(getTintedColor(Bear.InSkinColor));
        g2.fillOval(20, 20, 110, 110);
    }

    float blinkFactor = 0f;
    float blinkBeginTime = 0f;
    float blinkEndTime = 0f;
}
