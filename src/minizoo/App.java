package minizoo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import minizoo.c.Animal;
import minizoo.c.Background;
import minizoo.c.Entity;
import minizoo.c.FPSTimer;
import minizoo.c.Touch;
import minizoo.c.animal.sheep.Sheep;
import minizoo.c.core.Vector2d;

public class App implements ActionListener {
	public final static String Title = "Our Mini Zoo!";
	public final static int ScreenWidth = 1280;
	public final static int ScreenHeight = 720;
	
	public static Vector2d getActualSize() {
		return new Vector2d(Instance().mainFrame.getWidth(),
				Instance().mainFrame.getHeight());
	}

	public static App Instance() {
		if (instance == null) {
			instance = new App();
		}
		return instance;
	}
	private static App instance;

	public void init() {
		if (mainFrame != null) {
			System.err.println("Already Application initialized.");
			return;
		}

		mainFrame = new JFrame();
		mainFrame.setTitle(App.Title);
		mainFrame.setSize(App.ScreenWidth, App.ScreenHeight);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainCanvas = new Canvas();
		mainCanvas.setSize(App.ScreenWidth, App.ScreenHeight);
		mainFrame.add(mainCanvas, BorderLayout.CENTER);

		mainLoopTimer = new Timer(0, this);

		mouse = new Touch();
		mainCanvas.addMouseListener(mouse);
		mainCanvas.addMouseMotionListener(mouse);

		Background background = new Background("Background");
		Entity.add(background, Integer.MIN_VALUE);

		Animal animal = new Animal("Animal");
        animal.setPosition(new Vector2d(400, 400));
		animal.setContentSize(new Vector2d(100, 100));
		Entity.add(animal, 2);

        Sheep sheep = new Sheep("Sheep Prototype");
        sheep.setPosition(new Vector2d(ScreenWidth/2.0, ScreenHeight/2.0));
        Entity.add(sheep);

		FPSTimer fpsTimer = new FPSTimer();
		Entity.add(fpsTimer, Integer.MAX_VALUE);
	}

	public void run() {
		init();

        mainLoopTimer.setRepeats(true);
		mainLoopTimer.start();
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		long currUpdateTime = System.currentTimeMillis();

		if ((currUpdateTime-lastUpdateTime) < 1000) {
			this.MainLoop((currUpdateTime-lastUpdateTime)*0.001f);
		}
		lastUpdateTime = currUpdateTime;
	}

	void MainLoop(float elapsed) {
		this.Update(elapsed);

		mainCanvas.update(elapsed);
		mainCanvas.repaint();
	}

	void Update(float elapsed) {
		if (mouse != null) {
			mouse.Update();
		}
	}

	public static void main (String []args) {
		App.Instance().run();
	}
	
	public Canvas GetCanvas() {
		return mainCanvas;
	}

	long lastUpdateTime;
	JFrame mainFrame;
	Canvas mainCanvas;
	Timer mainLoopTimer;
	Touch mouse;
	public Touch GetTouchSystem() {
		return mouse;
	}

}
