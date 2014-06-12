package minizoo.c.action;

import minizoo.c.Entity;

public class Repeat extends Finite {

    public static Repeat c(int count, Finite targetAction) {
        return new Repeat(count, targetAction);
    }
    public Repeat(int count, Finite targetAction) {
        this.now = 0;
        this.count = count;
        setTargetAction(targetAction);
    }

    @Override
    public void clear() {
        super.clear();
        now = 0;
        getTargetAction().clear();
    }

    @Override
    public float getDuration() {
        return count * getTargetAction().getDuration();
    }

    @Override
    public void update(float elapsed) {
        super.update(elapsed);

        if (targetAction.getDuration() == 0) {
            return;
        }

        if (targetAction.getDuration() <= targetAction.time) {
            if (++now < count) {
                float remainder = targetAction.time % targetAction.getDuration();
                targetAction.update(targetAction.getDuration() - remainder);
                targetAction.clear();
                targetAction.update(remainder);
            }
        }

        targetAction.update(elapsed);
    }

    @Override
    public void sample(float t) {
        getTargetAction().sample(t);
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
    int now;
    int count;
}
