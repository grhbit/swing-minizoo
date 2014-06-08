package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

public class PenguinMouse extends Entity {
    public PenguinMouse(String name) {
        super(name);

        this.setContentSize(57, 38);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Penguin.mouseColor));
        g2.fillOval(0, 0, 57, 38);

        g2.setColor(getTintedColor(Penguin.innerMouseColor));
        g2.fillOval(0, 5, 57, 28);
    }
}
