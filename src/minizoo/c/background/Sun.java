package minizoo.c.background;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

import java.awt.*;

public class Sun extends Entity {
    public Sun(String name) {
        super(name);

        setContentSize(new Vector2d(100, 100));
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillOval(0, 0, 100, 100);
    }
}
