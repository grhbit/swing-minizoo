package minizoo.c.action;

public abstract class Finite extends Action {
    @Override
    public void update(float elapsed) {
        super.update(elapsed);

        sample(Math.max(0f, Math.min(time/getDuration(), 1f)));
    }

    public abstract void sample(float t);
}
