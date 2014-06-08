package minizoo.c.action;

import minizoo.c.Entity;

public class Forever extends Action {

    public static Forever c(Finite targetAction) {
        return new Forever(targetAction);
    }
    public Forever(Finite targetAction) {
        setTargetAction(targetAction);
    }

    @Override
    public void clear() {
        super.clear();
        getTargetAction().clear();
    }

    @Override
    public float getDuration() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);

        if (targetAction.getDuration() == 0) {
            return;
        }


        if (targetAction.getDuration() <= targetAction.time) {
            float remainder = targetAction.time % targetAction.getDuration();
            targetAction.update(targetAction.getDuration() - remainder);
            targetAction.clear();
            targetAction.update(remainder);
        }
        targetAction.update(elapsed);
    }

    @Override
    public void setTarget(Entity target) {
        getTargetAction().setTarget(target);
    }
    @Override
    public Entity getTarget() {
        return getTargetAction().getTarget();
    }

    public void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }
    public Finite getTargetAction() {
        return targetAction;
    }

    Finite targetAction;
}
