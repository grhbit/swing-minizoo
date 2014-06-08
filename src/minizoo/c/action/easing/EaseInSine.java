package minizoo.c.action.easing;

import minizoo.c.action.Easing;
import minizoo.c.action.Finite;

public class EaseInSine extends Easing {
    public static EaseInSine c(Finite targetAction) {
        return new EaseInSine(targetAction);
    }
    public EaseInSine(Finite targetAction) {
        super(targetAction);
    }

    @Override
    public void sample(float t) {
        getTargetAction().sample((float) Math.sin(t * (Math.PI/2.0)));
    }
}
