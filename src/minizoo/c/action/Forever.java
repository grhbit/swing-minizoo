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

    void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }
    Finite getTargetAction() {
        return targetAction;
    }

    Finite targetAction;
}
