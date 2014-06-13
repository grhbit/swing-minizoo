package minizoo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import minizoo.c.*;
import minizoo.c.animal.*;
import minizoo.c.background.Background;
import minizoo.c.animal.sheep.Sheep;
import minizoo.c.background.Ground;
import minizoo.c.core.Vector2d;
import minizoo.c.object.AnimalClear;
import minizoo.c.object.MusicPlayer;
import minizoo.c.object.ToggleBG;

public class App implements ActionListener {
	public final static String Title = "Our Mini Zoo!";
	public final static int ScreenWidth = 1280;
	public final static int ScreenHeight = 720;

    public static boolean isDancingTime = false;

    Background background = null;

    public void toggleBackground() {
        background.toggleBG();
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
		mainFrame.setSize(App.ScreenWidth/2, App.ScreenHeight/2);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainCanvas = new Canvas();
		mainCanvas.setSize(App.ScreenWidth, App.ScreenHeight);
		mainFrame.add(mainCanvas, BorderLayout.CENTER);

		mainLoopTimer = new Timer(0, this);

		mouse = new Touch();
		mainCanvas.addMouseListener(mouse);
		mainCanvas.addMouseMotionListener(mouse);

		background = new Background("Background");
		Entity.add(background, Integer.MIN_VALUE);

        Ground ground = new Ground("ground");
        Entity.add(ground, Integer.MIN_VALUE+1);

        Sheep sheep = new Sheep("Sheep Prototype");
        sheep.setPosition(new Vector2d(ScreenWidth/2.0, ScreenHeight/2.0));
        Entity.add(sheep);

        MusicPlayer musicPlayer = new MusicPlayer("");
        musicPlayer.setPosition(new Vector2d(ScreenWidth-100, 100));
        Entity.add(musicPlayer);

        ToggleBG toggleBG = new ToggleBG("");
        toggleBG.setPosition(ScreenWidth-100, 200);
        Entity.add(toggleBG);

        AnimalClear animalClear = new AnimalClear("");
        animalClear.setPosition(ScreenWidth-100, 300);
        Entity.add(animalClear);

        AnimalSpawnButton sheepSpawner = new AnimalSpawnButton(new SheepFactory());
        sheepSpawner.setPosition(new Vector2d(100, 100));
        Entity.add(sheepSpawner, 0);

        AnimalSpawnButton penguinSpanwer = new AnimalSpawnButton(new PenguinFactory());
        penguinSpanwer.setPosition(new Vector2d(200, 100));
        Entity.add(penguinSpanwer, 0);

        AnimalSpawnButton pandaSpanwer = new AnimalSpawnButton(new PandaFactory());
        pandaSpanwer.setPosition(new Vector2d(300, 100));
        Entity.add(pandaSpanwer, 0);

        AnimalSpawnButton bearSpanwer = new AnimalSpawnButton(new BearFactory());
        bearSpanwer.setPosition(new Vector2d(400, 100));
        Entity.add(bearSpanwer, 0);

        AnimalSpawnButton duckSpanwer = new AnimalSpawnButton(new DuckFactory());
        duckSpanwer.setPosition(new Vector2d(500, 100));
        Entity.add(duckSpanwer, 0);

        AnimalSpawnButton lionSpanwer = new AnimalSpawnButton(new LionFactory());
        lionSpanwer.setPosition(new Vector2d(600, 100));
        Entity.add(lionSpanwer, 0);

		//FPSTimer fpsTimer = new FPSTimer();
		//Entity.add(fpsTimer, Integer.MAX_VALUE);
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

    void Update(@SuppressWarnings("UnusedParameters") float elapsed) {
		if (mouse != null) {
			mouse.Update();
		}
	}

	public static void main (String []args) {
		App.Instance().run();
	}
	
	public Canvas getCanvas() {
		return mainCanvas;
	}

	long lastUpdateTime;
	JFrame mainFrame;
	Canvas mainCanvas;
	Timer mainLoopTimer;
	Touch mouse;
	public Touch getTouch() {
		return mouse;
	}

}
