package minizoo.c.background;

import minizoo.c.Entity;

import java.awt.*;

public class Moon extends Entity {
    public Moon(String name) {
        super(name);
        this.setContentSize(100, 100);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(new Color(250, 224, 6));
        g2.fillOval(0, 0, 100, 100);
    }
}
