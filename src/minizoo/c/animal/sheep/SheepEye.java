package minizoo.c.animal.sheep;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class SheepEye extends Entity {
    public SheepEye(String name) {
        super(name);

        this.setContentSize(new Vector2d(60, 35));
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
        g2.setColor(getTintedColor(Sheep.whiteOfTheEyeColor));
        g2.fillRect(0, 0, 60, 35);

        g2.setColor(getTintedColor(Sheep.softBlackColor));
        g2.fillRect(0, 0, 30, 35);
    }

    float blinkFactor = 0f;
    float blinkBeginTime = 0f;
    float blinkEndTime = 0f;
}
