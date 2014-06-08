package minizoo.c.action;

import minizoo.c.Entity;

import java.util.ArrayList;

public class Spawn extends Finite {

    public static Spawn c(Finite... actions) {
        return new Spawn(actions);
    }
    public Spawn(Finite... actions) {
        this.actions = new ArrayList<Finite>();

        for (Finite action : actions) {
            this.actions.add(action);
        }
    }

    @Override
    public void setTarget(Entity target) {
        super.setTarget(target);
        for (Action action : actions) {
            action.setTarget(target);
        }
    }

    @Override
    public void clear() {
        super.clear();
        for (Finite action : actions) {
            action.clear();
        }
    }

    @Override
    public float getDuration() {
        float max = 0f;
        for (Finite action : actions) {
            max = Math.max(max, action.getDuration());
        }
        return max;
    }

    @Override
    public void update(float elapsed) {
        float prevTime = time;
        super.update(elapsed);

        for (Finite action : actions) {
            float duration = action.getDuration();

            if (time < duration || prevTime < duration) {
                action.update(elapsed);
            }
        }
    }

    @Override
    public void sample(float t) { }

    ArrayList<Finite> actions;
}
