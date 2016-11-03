package sb15.tacoma.uw.edu.gameon;

/**
 * Created by Sally Budack on 10/30/2016.
 */




public class Player {

    float walkingTime = 0;

    int xpos;
    int ypos;
    int xspeed;

    public Player(int xpos, int ypos, int xspeed) {

        this.xpos = xpos;
        this.ypos = ypos;
        this.xspeed = xspeed;//movementPerSecond in the x axis for example -3
    }

    //deltaTime is the time elapsed in milliseconds
    public void update(float deltaTime) {


        xpos += xspeed * (deltaTime / 1000.0);
        walkingTime += deltaTime;
    }
}


/*
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Player implements GameObject {
    private int x;
    private int y;
    private int dy;
    private int dx;
    private int width;
    private int score;
    private boolean up;
    private boolean right;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;
    private Bitmap verticalSprites;
    private int height;


    public Player(Bitmap verticalSprites, int width, int height, int numFrames) {
        x = 100;
        y = GamePanel.HEIGHT / 4;
        this.width = width;
        this.height = height;
        dx = 0;
        dy = 0;
        score = 0;

        Bitmap[] bitmaps = new Bitmap[numFrames];
        for (int i = 0; i < numFrames; i++) {
            bitmaps[i] = Bitmap.createBitmap(verticalSprites, i * width, 0, width, height);
        }

        animation.setFrames(bitmaps);
        animation.setDelay(10);
        startTime = System.nanoTime();
    }


    public void update() {
        long elapsed = (System.nanoTime() - startTime) / 1000000;
        if (elapsed > 100) {
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        if (up) {
            dy -= 1;
        } else {
            dy += 1;
        }

        if (right) {
            dx -= 1;
        } else {
            dx += 1;
        }

        if (dy > 14) dy = 14;
        if (dy < -14) dy = -14;

        y += dy;
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }


    public void setUp(boolean b) {
        up = b;
    }

    public void setRight(boolean b) {
        right = b;
    }

    public void resetDY() {
        dy = 0;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public boolean getPlaying() {
        return playing;
    }

    public void setPlaying(boolean b) {
        playing = b;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rect getRectangle() {
        return new Rect(x, y, x + width, y + height);
    }
}*/
