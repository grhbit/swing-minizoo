package minizoo.c.action;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

public class MoveBy extends Finite {

    public MoveBy(Entity target, float duration, Vector2d rel) {
        setTarget(target);
        this.duration = duration;
        relativePos = rel.clone();
    }
    public MoveBy(Entity target, float duration, float rx, float ry) {
        this(target, duration, new Vector2d(rx, ry));
    }

    @Override
    public void sample(float t) {
        if (getTarget() != null) {
            Vector2d res = new Vector2d(relativePos);
            res.mul(t-prevT);
            res.add(getTarget().getPosition());

            getTarget().setPosition(res);

            prevT = t;
        }
    }

    float prevT = 0f;
    Vector2d beginPos = new Vector2d(0, 0);
    Vector2d relativePos;
}
