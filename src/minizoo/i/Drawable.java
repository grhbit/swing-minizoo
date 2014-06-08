package minizoo.i;

import java.awt.*;

public interface Drawable {
    public void setTint(Color tint);
    public Color getTint();
	public void draw(Graphics g);
}
