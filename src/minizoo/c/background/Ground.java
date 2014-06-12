package minizoo.c.background;

import minizoo.App;
import minizoo.c.Entity;
import minizoo.c.Sprite;

public class Ground extends Entity {
    public Ground(String name) {
        super(name);

        Sprite sprTile = new Sprite("resources/kenney/grassMid.png");
        sprTile.setPosition(0, App.ScreenHeight);
        sprTile.setAnchor(0, 1);

        int count = (int)Math.floor(App.ScreenWidth/sprTile.getContentSize().x);
        this.addChild(sprTile);

        for (int i=1; i<=count; ++i) {
            sprTile = new Sprite("resources/kenney/grassMid.png");
            sprTile.setPosition((float) sprTile.getContentSize().x * i, App.ScreenHeight);
            sprTile.setAnchor(0, 1);
            this.addChild(sprTile);
        }
    }
}
