package minizoo.i;

import java.awt.geom.Point2D;

public interface TouchListener {
	public void Hover(boolean isHover);
	public void Drag(Point2D point);
	public void Press(boolean isPress, Point2D point);
	public void Click();
	public void DoubleClick();
    public boolean isNeededSupportingDoubleClicking();
}
