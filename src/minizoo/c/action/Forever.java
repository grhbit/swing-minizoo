package minizoo.c.action;

public class Forever extends Action {

    public Forever(Finite targetAction) {
        setTargetAction(targetAction);
    }

    @Override
    public float getDuration() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public void update(float elapsed) {
        if (targetAction.getDuration() == 0) {
            return;
        }

        super.update(elapsed);

        if (targetAction.getDuration() <= targetAction.time) {
            while (targetAction.getDuration() <= targetAction.time) {
                targetAction.time -= targetAction.getDuration();
            }
            targetAction.clear();
            targetAction.update(targetAction.time + elapsed);
        } else {
            targetAction.update(elapsed);
        }
    }

    void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }
    Finite getTargetAction() {
        return targetAction;
    }

    Finite targetAction;
}
