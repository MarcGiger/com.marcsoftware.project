package Project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 * This class demonstrates the power of the Shark by playing the white Shark music.
 *
 * help: https://www.youtube.com/watch?v=TErboGLHZGA
 */
public class Music {

    private AudioInputStream audioInput;
    private Clip clip;


    /**
     * Create the Music object.
     */
    public Music() {

    }

    /**
     * This method shall play the music.
     */
    public void playMusic() {
        try {

            // mp3 not supported
            audioInput = AudioSystem.getAudioInputStream(getClass().getResource("/Project/Sound/Great White Shark (Jaws Music).wav"));
            // Clip gives us a lot of functionality
            // creates an extra thread
            this.clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

//                clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method shall stop the music.
     */
    public void stopMusic() {
        try {
            this.clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
