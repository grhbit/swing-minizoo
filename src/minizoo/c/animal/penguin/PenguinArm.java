package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

public class PenguinArm extends Entity {
    public PenguinArm(String name) {
        super(name);

        this.setContentSize(57, 303);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Penguin.brandColor));
        g2.fillOval(0, 0, 57, 303);
    }
}
