package sb15.tacoma.uw.edu.gameon;


import android.graphics.drawable.AnimationDrawable;
import android.media.Image;

public class Animation extends AnimationDrawable {

    /*private static final String PREF_NAME = "pref_name";
    public static final String IS_STARTUP = "is_startup";

    private SharedPreferences settings;
    private Bitmap[] frames;


    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;
    private boolean isAnimated;*/

    /********************************************************************/
    /********************************************************************/

    public static final int ANIMATION_LOOPING = 0;
    public static final int ANIMATION_NONLOOPING = 1;

    private Image[] sprites;
    private float frameDuration ;

    public Animation(float frameDuration, Image... sprites){

        this.sprites =sprites;
        this.frameDuration = frameDuration;
    }

    //this function takes a the walking time of the animation
    public Image getKeyFrame(float stateTime , int mode){
        int frameNumber = (int) (stateTime/ frameDuration);

        if(mode == ANIMATION_NONLOOPING){
            frameNumber = Math.min( sprites.length , frameNumber);
        }
        else{
            frameNumber = frameNumber % sprites.length;
        }

        return sprites[frameNumber];
    }
    /**************************************************************/
    /**************************************************************/
    /**
     * You can use SharePreferences, to check a boolean value. If is true or not exists means is
     * first launch or you can animate app in onWindowFocusChange() method. Set it to false to never
     * animate again.
     */
/*    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        settings = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if (settings.getBoolean(IS_START_UP, true)) {
            test_text.startAnimation(test_anim);
            settings.edit().putBoolean(IS_START_UP, false).commit();
        }
    }*/
    /**In case you want to animate again when app starts next time, you can set the pref
     IS_START_UP to true when exit the application. */

 /*   if(!settings.getBoolean(IS_START_UP, false)){
        settings.edit().putBoolean(IS_START_UP, true).commit();
    }
*/
    /** The shared prefs work in every situation except when if the screen is rotated. In that
     * case the animation will repeat. It's like every time you rotate the screen, the
     * activity restarts from the beginning. */

    /** Use SharedPreference to store a boolean variable & make it to true immediately after first
     animation & check this each time before animation starts. */


/*

    public void setFrames(Bitmap[] frames) {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public void setDelay(long d) {
        delay = d;
    }

    public void setFrame(int i) {
        currentFrame = i;
    }

    public void update() {
        long elapsed = (System.nanoTime() - startTime) / 1000000;

        if (elapsed > delay) {
            currentFrame++;
            startTime = System.nanoTime();
            isAnimated = true;
        }
        if (currentFrame == frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
    }

    public Bitmap getImage() {
        return frames[currentFrame];
    }

    public int getFrame() {
        return currentFrame;
    }

    public boolean playedOnce() {
        return playedOnce;
    }

    public boolean isAnimatedAlready() {

            return isAnimated;

    }


    public boolean isPlayedOnce() {
        return playedOnce;
    }

    public void setPlayedOnce(boolean playedOnce) {
        this.playedOnce = playedOnce;
    }
*/

}