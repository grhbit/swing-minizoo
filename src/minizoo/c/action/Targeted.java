package minizoo.c.action;

import minizoo.c.Entity;

public class Targeted extends Finite {
    public static Targeted c(Entity overrideTarget, Finite targetAction) {
        return new Targeted(overrideTarget, targetAction);
    }
    public Targeted(Entity overrideTarget, Finite targetAction) {
        setOverrideTarget(overrideTarget);
        setTargetAction(targetAction);
        getTargetAction().setTarget(getOverrideTarget());
    }

    @Override
    public void clear() {
        super.clear();
        getTargetAction().clear();
    }

    @Override
    public void setTarget(Entity target) {
        getTargetAction().setTarget(getOverrideTarget());
    }
    @Override
    public Entity getTarget() {
        return getOverrideTarget();
    }

    @Override
    public void update(float elapsed) {
        getTargetAction().update(elapsed);
    }

    @Override
    public void sample(float t) {
        getTargetAction().sample(t);
    }

    @Override
    public float getDuration() {
        return getTargetAction().getDuration();
    }

    public void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }
    public Finite getTargetAction() {
        return targetAction;
    }

    public void setOverrideTarget(Entity overrideTarget) {
        this.overrideTarget = overrideTarget;
    }
    public Entity getOverrideTarget() {
        return overrideTarget;
    }

    Entity overrideTarget;
    Finite targetAction;
}
