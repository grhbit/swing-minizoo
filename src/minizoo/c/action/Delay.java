package minizoo.c.action;

public class Delay extends Finite {

    public static Delay c(float duration) {
        return new Delay(duration);
    }
    public Delay(float duration) {
        this.duration = duration;
    }

    @Override
    public void sample(float t) { }
}
