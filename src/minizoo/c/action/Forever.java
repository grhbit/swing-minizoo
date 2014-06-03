package minizoo.c.action;

public class Forever extends Action {

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

        float remainTime = time - lastPerformTime;
        targetAction.update(remainTime);

        lastPerformTime = time;
    }
    float lastPerformTime = 0f;

    void setTargetAction(Finite targetAction) {
        this.targetAction = targetAction;
    }
    Finite getTargetAction() {
        return targetAction;
    }

    Finite targetAction;
}
