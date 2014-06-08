package minizoo.c;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Audio extends Entity {
    public Audio(String filename) {
        super("Audio:" + filename);

        try {
            in = new FileInputStream(filename);
            as = new AudioStream(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.filename = filename;
    }

    public void play() {
        try {
            in = new FileInputStream(filename);
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        AudioPlayer.player.stop(as);
    }

    FileInputStream in;
    ContinuousAudioDataStream cas;
    AudioStream as;
    String filename;
}
