package minizoo.c.action;

import minizoo.c.Entity;
import minizoo.i.Task;

public abstract class Action implements Task {
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }
    String identifier;

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
    public float getTime() { return time; }
    float time = 0f;

    public Entity getTarget() {
        return target;
    }
    public void setTarget(Entity target) {
        this.target = target;
    }
    Entity target = null;
}
