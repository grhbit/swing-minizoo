package minizoo.c.object;

import minizoo.App;
import minizoo.c.Animal;
import minizoo.c.Audio;
import minizoo.c.Entity;
import minizoo.c.Sprite;
import minizoo.c.action.Action;
import minizoo.c.action.ScaleTo;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;
import minizoo.i.DancingMachine;
import minizoo.i.TouchListener;

import java.awt.geom.Point2D;
import java.util.Iterator;

public class AnimalClear extends Entity implements TouchListener {
    public AnimalClear(String name) {
        super(name);

        spr = new Sprite("resources/ok.png");
        this.addChild(spr);
    }

    @Override
    public void Hover(boolean isHover) {
        if (isHover) {
            spr.stopAction("hover:false");
            spr.stopAction("press:true");
            spr.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1.1f, 1.1f))), "hover:true");
        } else {
            spr.stopAction("hover:true");
            spr.stopAction("press:true");
            spr.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1f, 1f))), "hover:false");
        }
    }

    @Override
    public void Drag(Point2D point) {

    }

    @Override
    public void Press(boolean isPress, Point2D point) {
        if (isPress) {
            spr.stopAction("hover:true");
            spr.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1.05f, 1.05f))), "press:true");
        } else {
            this.Hover(true);
        }
    }

    @Override
    public void Click() {
        for (Iterator<Entity> it = Entity.list.iterator(); it.hasNext(); ) {
            Entity next = it.next();
            if (next instanceof Animal) {
                it.remove();
            }
        }
    }

    @Override
    public void DoubleClick() {

    }

    @Override
    public boolean isNeededSupportingDoubleClicking() {
        return false;
    }

    Sprite spr;
}
