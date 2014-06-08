package minizoo.c;

import minizoo.App;
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
		if (current == null || currentDrag != null) {
			return;
		}

		Entity _currHovered = null;
        Object[] entities = Entity.list.toArray();

        for (int i=entities.length-1; i>=0; --i) {
            if (entities[i] instanceof  Collider) {
                Collider collider = (Collider)entities[i];

                if (collider.intersect(current, null)) {
                    _currHovered = (Entity)entities[i];
                    break;
                }
            }
        }

        setCurrentHover(_currHovered);
	}

    public Point2D getCurrent() {
        return current;
    }
	Point2D current;

    public Entity getLastHovered() {
        return lastHovered;
    }
    public Entity getCurrentDrag() {
        return currentDrag;
    }
    public void setCurrentDrag(Entity _currentDrag) {
        if (pressed) {
            if (currentDrag != null && currentDrag instanceof TouchListener) {
                TouchListener touchListener = (TouchListener)currentDrag;
                touchListener.Press(false, current);
            }

            if (_currentDrag != null && _currentDrag instanceof TouchListener) {
                TouchListener touchListener = (TouchListener)_currentDrag;
                touchListener.Press(true, current);
            }

            currentDrag = _currentDrag;
        }
    }

    public Entity getCurrentHover() {
        return currHovered;
    }
    public void setCurrentHover(Entity currentHover) {
        if (currHovered != currentHover) {
            if ((currHovered!=null) && currHovered instanceof TouchListener) {
                ((TouchListener)currHovered).Hover(false);
            }

            if ((currentHover!=null) && currentHover instanceof TouchListener) {
                ((TouchListener)currentHover).Hover(true);
            }

            if (currentHover != null) {
                lastHovered = currentHover;
            }

            currHovered = currentHover;
        }
    }
	
	Entity lastHovered;
	Entity currHovered;
	Entity currentDrag;
	boolean pressed;	
	boolean isWaitDoubleClick = false;
	
	public void setCurrentTouchPosition(MouseEvent mouseEvent) {
		double ratioX = (double)App.Instance().getCanvas().getWidth()/App.ScreenWidth;
		double ratioY = (double)App.Instance().getCanvas().getHeight()/App.ScreenHeight;
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
				TouchListener touchListener;
				touchListener = (TouchListener)currHovered;
				touchListener.DoubleClick();
			}

		} else {
            if (currHovered!=null && currHovered instanceof TouchListener) {
                TouchListener touchListener;
                touchListener = (TouchListener)currHovered;
                if (touchListener.isNeededSupportingDoubleClicking() == false) {
                    touchListener.Click();
                    return;
                }
            }

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

		setCurrentTouchPosition(arg0);
		if (currentDrag != null && currentDrag instanceof TouchListener) {
			TouchListener touchListener = (TouchListener)currentDrag;
			touchListener.Press(false, current);
		}

        currentDrag = null;
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
