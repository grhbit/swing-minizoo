package minizoo.c.action;

import minizoo.c.core.Vector2d;

public class RotateBy extends Finite {

    public RotateBy(float duration, double rotation) {
        this.duration = duration;
        this.rotation = rotation;
    }
    
    @Override
    public void clear() {
        super.clear();
        prevT = 0f;
    }

    @Override
    public void sample(float t) {
        if (getTarget() != null) {
            double res = rotation;

            getTarget().setRotation((-0.2+t/5)*rotation);

            prevT = t;
        }
    }

    float prevT = 0f;
    double rotation;
}