package minizoo.c.animal.penguin;

import minizoo.c.Entity;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class PenguinEye extends Entity {
    public class PenguinPupil extends Entity {
        public PenguinPupil(String name) {
            super(name);
            this.setContentSize(19 + 6, 18 + 5);
        }

        @Override
        public void visit(Graphics2D g2) {
            g2.setColor(getTintedColor(Penguin.blackColor));
            g2.fillOval(0, 0, 19 + 6, 18 + 5);
        }
    }

    public PenguinEye(String name) {
        super(name);

        pupil = new PenguinPupil(name + ":pupil");
        pupil.setPosition(12, 13);
        this.addChild(pupil);

        this.setContentSize(26, 24);
    }

    @Override
    public void visit(Graphics2D g2) {
        g2.setColor(getTintedColor(Penguin.whiteColor));
        g2.fillOval(0, 0, 26, 24);
    }

    public PenguinPupil getPupil() {
        return pupil;
    }
    PenguinPupil pupil;
}
