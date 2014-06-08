package minizoo.c.object;

import minizoo.c.Audio;
import minizoo.c.Entity;
import minizoo.c.Sprite;
import minizoo.c.action.ScaleTo;
import minizoo.c.action.easing.EaseInOutSine;
import minizoo.c.core.Vector2d;
import minizoo.i.TouchListener;

import java.awt.geom.Point2D;

public class MusicPlayer extends Entity implements TouchListener {
    public MusicPlayer(String name) {
        super(name);

        sprRadio = new Sprite("resources/audio_file.png");
        this.addChild(sprRadio);

        audio = new Audio("resources/bgm.wav");
        this.addChild(audio);
    }

    @Override
    public void Hover(boolean isHover) {
        if (isHover) {
            sprRadio.stopAction("hover:false");
            sprRadio.stopAction("press:true");
            sprRadio.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1.1f, 1.1f))), "hover:true");
        } else {
            sprRadio.stopAction("hover:true");
            sprRadio.stopAction("press:true");
            sprRadio.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1f, 1f))), "hover:false");
        }
    }

    @Override
    public void Drag(Point2D point) {

    }

    @Override
    public void Press(boolean isPress, Point2D point) {
        if (isPress) {
            sprRadio.stopAction("hover:true");
            sprRadio.runAction(new EaseInOutSine(new ScaleTo(0.2f, new Vector2d(1.05f, 1.05f))), "press:true");
        } else {
            this.Hover(true);
        }
    }

    @Override
    public void Click() {
        if (b) {
            audio.stop();
        } else {
            audio.play();
        }

        b = !b;
    }
    boolean b = false;

    @Override
    public void DoubleClick() {

    }

    Sprite sprRadio;
    Audio audio;
}
