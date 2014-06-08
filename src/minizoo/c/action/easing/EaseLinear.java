package minizoo.c.action.easing;

import minizoo.c.action.Finite;
import minizoo.c.action.Easing;

public class EaseLinear extends Easing {

    public static EaseLinear c(Finite targetAction) {
        return new EaseLinear(targetAction);
    }
    public EaseLinear(Finite targetAction) {
        super(targetAction);
    }

    @Override
    public void sample(float t) {
        getTargetAction().sample(t);
    }
}
