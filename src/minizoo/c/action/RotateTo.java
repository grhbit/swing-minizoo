package minizoo.c.action;

public class RotateTo extends Finite {

    public RotateTo(float duration, float to) {
        this.duration = duration;
        this.to = to;
    }

    @Override
    public void clear() {
        super.clear();
        this.from = (float)getTarget().getRotation();
    }

    @Override
    public void sample(float t) {
        if (getTarget() != null) {
            getTarget().setRotation((to*t+from) % (2*Math.PI));
        }
    }

    float from = 0f;
    float to = 0f;
}
