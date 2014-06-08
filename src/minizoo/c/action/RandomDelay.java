package minizoo.c.action;

public class RandomDelay extends Finite {

    public RandomDelay(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void clear() {
        super.clear();

        this.duration = (float)Math.random() * (max-min) + min;
    }

    @Override
    public void sample(float t) { }

    float min;
    float max;
}
