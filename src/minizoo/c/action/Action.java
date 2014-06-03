package minizoo.c.action;

import minizoo.c.Entity;
import minizoo.i.Task;

public abstract class Action implements Task {
    public float getDuration() {
        return duration;
    }
    float duration = 0f;

    public void clear() {
        time = 0f;
    }

    public void update(float elapsed) {
        time += elapsed;
    }
    float time = 0f;

    public Entity getTarget() {
        return target;
    }
    public void setTarget(Entity target) {
        this.target = target;
    }
    Entity target = null;
}
