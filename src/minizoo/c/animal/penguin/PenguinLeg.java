package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

public class PenguinLeg extends Entity {
    public PenguinLeg(String name) {
        super(name);

        this.setContentSize(73, 63);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Penguin.legPointColor));
        g2.fillRect(41, 0, 17, 64);
        g2.fillRoundRect(0, 47, 73, 19, 32, 32);
    }
}
