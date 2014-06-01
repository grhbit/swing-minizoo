package minizoo.i;

import java.awt.Graphics;

public interface Drawable {

	// save transform
	public void beforeDraw(Graphics g);
	
	public void Draw(Graphics g);
	
	// restore transform
	public void afterDraw(Graphics g);
}
