package minizoo.c.background;

import minizoo.App;
import minizoo.c.Entity;
import minizoo.c.Sprite;
import minizoo.c.action.*;

import java.util.ArrayList;
import java.util.Random;

public class Clouds extends Entity {
    public Clouds(String name) {
        super(name);

        Random rng = new Random();

        for (int i=0; i<5; ++i) {
            Sprite sprCloud = new Sprite("resources/cloud.png");
            sprCloud.setPosition(rng.nextInt(App.ScreenWidth), rng.nextInt(App.ScreenHeight) * 0.5f);
            sprCloud.setScale(rng.nextFloat() * 0.3f, rng.nextFloat() * 0.3f);

            sprCloud.runAction(Forever.c(Sequence.c(MoveBy.c(rng.nextFloat()*10f + 5f, 0, App.ScreenWidth), MoveBy.c(0, 0, 0))));

            clouds.add(sprCloud);
        }
    }

    ArrayList<Sprite> clouds = new ArrayList<Sprite>();
}
