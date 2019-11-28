package Project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.net.URL;

/**
 * https://www.youtube.com/watch?v=TErboGLHZGA
 */
public class Music {

    // private URL musicUrl;
    private AudioInputStream audioInput;
    private Clip clip;
    private Boolean play;

    public Music() {
        play = false;
    }

    public void playMusic() {
        try {
            if (play = true) {
                // mp3 not supported
                audioInput = AudioSystem.getAudioInputStream(getClass().getResource("/Project/sound/Great White Shark (Jaws Music).wav"));
                // Clip gives us a lot of functionality
                // creates an extra thread
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }


        } catch (Exception MusicShallStop) {
            clip.stop();
        } /*catch (Exception ex) {
            ex.printStackTrace();
        }
        */
    }


    public void setPlay(Boolean play) throws MusicShallStop {
        this.play = play;
    }
}
