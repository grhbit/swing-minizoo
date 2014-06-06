package minizoo.c.action;

import minizoo.c.core.Vector2d;

public class ScaleTo extends Finite {

    public ScaleTo (float duration, Vector2d to) {
        this.duration = duration;
        this.to = to.clone();
    }
    public ScaleTo (float duration, float sx, float sy) {
        this(duration, new Vector2d(sx, sy));
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
