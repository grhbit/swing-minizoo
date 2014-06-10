package minizoo.c.action;

@SuppressWarnings("UnusedDeclaration")
public class RandomDelay extends Finite {

    public static RandomDelay c(float min, float max) {
        return new RandomDelay(min, max);
    }
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
