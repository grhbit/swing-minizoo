package minizoo.c.action;

import minizoo.c.core.Vector2d;

public class MoveBy extends Finite {

    public MoveBy(float duration, Vector2d relativePos) {
        this.duration = duration;
        this.relativePos = relativePos.clone();
    }
    public MoveBy(float duration, float rx, float ry) {
        this(duration, new Vector2d(rx, ry));
    }

    @Override
    public void clear() {
        super.clear();
        prevT = 0f;
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
    Vector2d relativePos;
}
