package minizoo.c.action;

import minizoo.c.Entity;

public class Instant extends Finite {

    public static Instant c(Finite targetAction) {
        return new Instant(targetAction);
    }
    public Instant(Finite targetAction) {
        setTargetAction(targetAction);
    }

    @Override
    public void clear() {
        super.clear();
        targetAction.clear();
    }

    @Override
    public float getDuration() {
        return getTargetAction().getDuration();
    }

    @Override
    public void setTarget(Entity target) {
        targetAction.setTarget(target);
    }
    @Override
    public Entity getTarget() {
        return targetAction.getTarget();
    }

    public Finite getTargetAction() {
        return targetAction;
    }
    public void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }

    Finite targetAction;

    @Override
    public void sample(float t) {
        if (t >= 1f) {
            getTargetAction().sample(1f);
        } else {
            getTargetAction().sample(0f);
        }
    }
}
