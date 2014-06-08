package minizoo.c.animal.sheep;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class SheepLeg extends Entity {
    public SheepLeg(String name) {
        super(name);

        this.setContentSize(new Vector2d(64, 128));
    }

    public void setNearLeg(boolean isNear) {
        this.isNear = isNear;
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Sheep.hoofColor));
        g2.fillRect(7, 116, 52, 12);

        g2.setColor(getTintedColor(Sheep.skinColor));
        g2.fillRect(4, 41, 55, 76);

        g2.setColor(getTintedColor(isNear? Sheep.brandColor : Sheep.subBrandColor));
        g2.fillRect(0, 0, 64, 59);
    }

    boolean isNear;
}
