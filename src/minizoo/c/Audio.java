package minizoo.c;

import javazoom.jl.decoder.JavaLayerException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.player.Player;

public class Audio extends Entity {
    public Audio(String filename) {
        super("Audio:" + filename);
        this.filename = filename;
    }

    public void play() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

        new Thread() {
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void stop() {
        if (player!=null) {
            player.close();
        }
    }

    Player player;
    String filename;
}
