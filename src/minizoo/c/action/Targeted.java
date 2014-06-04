package minizoo.c.action;

import minizoo.c.Entity;

public class Targeted extends Finite {
    public Targeted(Entity target, Action applyingAction) {
        this.otherTarget = target;
        this.applyingAction = applyingAction;

        setTarget(target);
    }

    @Override
    public void setTarget(Entity target) {
        this.target = target;
        applyingAction.setTarget(otherTarget);
    }

    @Override
    public void update(float elapsed) {
        applyingAction.update(elapsed);
    }

    @Override
    public void sample(float t) { }

    @Override
    public float getDuration() {
        return applyingAction.getDuration();
    }

    Entity otherTarget;
    Action applyingAction;

}
