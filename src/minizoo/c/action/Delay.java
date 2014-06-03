package minizoo.c.action;

public class Delay extends Finite {

    public Delay(float duration) {
        this.duration = duration;
    }

    @Override
    public void sample(float t) { }
}
