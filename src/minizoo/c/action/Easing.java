package minizoo.c.action;

import minizoo.c.Entity;

public abstract class Easing extends Finite {

    public Easing(Finite targetAction) {
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
}
