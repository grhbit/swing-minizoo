package minizoo.c.action.easing;

import minizoo.c.action.Easing;
import minizoo.c.action.Finite;

public class EaseInOutSine extends Easing {
    public EaseInOutSine(Finite targetAction) {
        super(targetAction);
    }

    @Override
    public void sample(float t) {
        getTargetAction().sample(-0.5f*(float)(Math.cos(Math.PI * t) - 1f));
    }
}
