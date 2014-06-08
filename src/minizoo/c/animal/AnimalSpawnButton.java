package minizoo.c.animal;

import minizoo.App;
import minizoo.c.Animal;
import minizoo.c.Entity;
import minizoo.c.action.ScaleTo;
import minizoo.c.action.Spawn;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;
import minizoo.i.AnimalFactory;
import minizoo.i.TouchListener;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class AnimalSpawnButton extends Entity implements TouchListener {
    public AnimalSpawnButton(AnimalFactory factory) {
        super("AnimalSpawnButton:" + factory.toString());

        this.factory = factory;
        this.setScale(0.3f, 0.3f);

        this.addChild(factory.build());
    }

    BufferedImage image;

    @Override
    public void beforeDraw(Graphics2D g2) {
        super.beforeDraw(g2);
    }

    @Override
    public void Hover(boolean isHover) {
        if (isHover) {
            this.stopAction("hover:false");
            this.stopAction("press:true");
            this.runAction(Spawn.c(EaseInOutSine.c(ScaleTo.c(0.2f, 1f, 1f))), "hover:true");
        } else {
            this.stopAction("hover:true");
            this.stopAction("press:true");
            this.runAction(Spawn.c(EaseInOutSine.c(ScaleTo.c(0.2f, 0.3f, 0.3f))), "hover:false");
        }
    }

    @Override
    public void Drag(Point2D point) {

    }

    @Override
    public void Press(boolean isPress, Point2D point) {
        if (isPress) {
            this.stopAction("hover:true");
            Animal animal = factory.build();
            animal.setPosition(new Vector2d(App.Instance().getTouch().getCurrent()));
            Entity.add(animal);

            App.Instance().getTouch().setCurrentDrag(animal);

        } else {
            this.Hover(true);
        }
    }

    @Override
    public void Click() {
    }

    @Override
    public void DoubleClick() {

    }

    @Override
    public boolean isNeededSupportingDoubleClicking() {
        return false;
    }

    AnimalFactory factory;
}
