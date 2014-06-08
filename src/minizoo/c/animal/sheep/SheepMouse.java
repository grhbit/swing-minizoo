package minizoo.c.animal.sheep;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class SheepMouse extends Entity {
    public SheepMouse(String name) {
        super(name);

        this.setContentSize(new Vector2d(47, 49));
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Sheep.mouseColor));
        g2.fillRect(0, 0, 47, 49);

        g2.setColor(getTintedColor(Sheep.tougueColor));
        g2.fillRect(1, 21, 45, 27);
    }
}
