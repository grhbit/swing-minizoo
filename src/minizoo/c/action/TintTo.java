package minizoo.c.action;

import java.awt.*;

public class TintTo extends Finite {

    public static TintTo c(float duration, Color to) {
        return new TintTo(duration, to);
    }
    public TintTo(float duration, Color to) {
        this.duration = duration;
        this.to = to;
    }

    public static int clamp(int val, int min, int max) {
        return Math.min(max, Math.max(min, val));
    }

    @Override
    public void clear() {
        super.clear();
        from = getTarget().getTint();
    }

    @Override
    public void sample(float t) {
        if (getTarget() != null) {
            getTarget().setTint(new Color(
                    clamp((int)((to.getRed()-from.getRed())*t) + from.getRed(), 0, 255),
                    clamp((int)((to.getBlue()-from.getBlue())*t) + from.getBlue(), 0, 255),
                    clamp((int)((to.getGreen()-from.getGreen())*t) + from.getGreen(), 0, 255),
                    clamp((int)((to.getAlpha()-from.getAlpha())*t) + from.getAlpha(), 0, 255)));
        }
    }

    Color from;
    Color to;
}
