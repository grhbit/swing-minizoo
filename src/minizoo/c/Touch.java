package minizoo.c;

import minizoo.App;
import minizoo.c.Entity;
import minizoo.i.Collider;
import minizoo.i.TouchListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;
 
public class Touch implements MouseListener, MouseMotionListener {
	
	public final long DoubleClickElapse = 250;
	
	public void Update() {
		if (current == null) {
			return;
		}

		Entity _currHovered = null;
		for (Entity entity : Entity.list) {
			if (entity instanceof Collider) {
				Collider collider = (Collider)entity;
			
				if (collider.intersect(current)) {
					_currHovered = entity;
					break;
				}
			}
		}
		
		if (currHovered != _currHovered) {
			if ((currHovered!=null) && currHovered instanceof TouchListener) {
				((TouchListener)currHovered).Hover(false);
			}
			
			if ((_currHovered!=null) && _currHovered instanceof TouchListener) {
				((TouchListener)_currHovered).Hover(true);
			}
			
			if (_currHovered != null) {
				lastHovered = _currHovered;				
			}
			
			currHovered = _currHovered;
		}
	}
	
	Point2D current;
	
	Entity lastHovered;
	Entity currHovered;
	Entity currentDrag;
	boolean pressed;	
	boolean isWaitDoubleClick = false;
	
	void setCurrentTouchPosition(MouseEvent mouseEvent) {
		double ratioX = (double)App.Instance().GetCanvas().getWidth()/App.ScreenWidth;
		double ratioY = (double)App.Instance().GetCanvas().getHeight()/App.ScreenHeight;
		current = new Point2D.Double(mouseEvent.getX() / ratioX, mouseEvent.getY() / ratioY);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {		
		if (currHovered == null) {
			return;
		}
		
		if (isWaitDoubleClick) {
			isWaitDoubleClick = false;
			// Double Click
			if (currHovered!=null && currHovered instanceof TouchListener) {
				TouchListener touchListener = null;
				touchListener = (TouchListener)currHovered;
				touchListener.DoubleClick();
			}

		} else {
			isWaitDoubleClick = true;
			Timer t = new Timer("doubleClickTimer",false);
			t.schedule(new TimerTask() {

				@Override
				public void run() {
					if (isWaitDoubleClick) {
						// Just Click
						TouchListener touchListener = null;
						if (currHovered instanceof TouchListener) {
							touchListener = (TouchListener)currHovered;
						}
						
						if (currHovered == null && lastHovered != null && lastHovered instanceof TouchListener) {
							touchListener = (TouchListener)lastHovered;
						}
						
						if (touchListener != null) {
							touchListener.Click();
						}
					}
					isWaitDoubleClick = false;
				}
			}, DoubleClickElapse);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		setCurrentTouchPosition(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		setCurrentTouchPosition(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pressed = true;
		currentDrag = currHovered;
		
		setCurrentTouchPosition(arg0);		
		if (currentDrag != null && currentDrag instanceof TouchListener) {
			TouchListener touchListener = (TouchListener)currentDrag;
			touchListener.Press(true, current);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		pressed = false;
		currentDrag = null;

		setCurrentTouchPosition(arg0);
		if (currentDrag != null && currentDrag instanceof TouchListener) {
			TouchListener touchListener = (TouchListener)currentDrag;
			touchListener.Press(false, current);
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		setCurrentTouchPosition(arg0);
		if (currentDrag != null && currentDrag instanceof TouchListener) {
			TouchListener touchListener = (TouchListener)currentDrag;
			touchListener.Drag(current);
		}		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		setCurrentTouchPosition(arg0);
	}
}
