package minizoo.c.action;

import minizoo.c.Entity;
import minizoo.c.core.Vector2d;

public class ScaleTo extends Finite {

    public ScaleTo (Entity target, Vector2d to) {
        setTarget(target);
        this.to = to.clone();
        from = getTarget().getScale().clone();
    }
    public ScaleTo (Entity target, float duration, float sx, float sy) {
        this(target, new Vector2d(sx, sy));
        this.duration = duration;
    }

    @Override
    public void clear() {
        super.clear();
        from = getTarget().getScale().clone();
    }

    @Override
    public void sample(float t) {
        if (getTarget() != null) {
            Vector2d res = new Vector2d(to);
            res.sub(from);
            res.mul(t);
            res.add(from);

            getTarget().setScale(res);
        }
    }

    Vector2d from;
    Vector2d to;
}
