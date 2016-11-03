package sb15.tacoma.uw.edu.gameon;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "GamePanel";
    public static final int WIDTH = 1048;
    public static final int HEIGHT = 258;
    public static final int MOVESPEED = -3;
    private MainThread thread;
    private Background bg;
    private Player player;

    private Random rand = new Random();
    private boolean topDown = true;
    private boolean botDown = true;
    private boolean newGameCreated;
    private long startReset;
    private boolean reset;
    private boolean disappear;
    private boolean gameStarted;
    private boolean collision = false;
    private int currentHighScore;
    private int score;
    private AssetManager mAssets;
    private static final int LOOP = -1;
    private static final int PLAY_ONCE = 0;
    private SurfaceView surfaceView;
        private SurfaceHolder surfaceHolder;
        private Bitmap bmpIcon;

        public GamePanel(Context context) {
            super(context);
            init();
        }

        public GamePanel(Context context,
                             AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public GamePanel(Context context,
                             AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        private void init(){
            surfaceHolder = getHolder();
            bmpIcon = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.ic_launcher);
            surfaceHolder.addCallback(new SurfaceHolder.Callback(){

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    Canvas canvas = holder.lockCanvas(null);
//                    drawSomething(canvas);
                    holder.unlockCanvasAndPost(canvas);
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder,
                                           int format, int width, int height) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    // TODO Auto-generated method stub

                }});
        }

    public GamePanel(Context context, int currentHighScore) {
        super(context);

        getHolder().addCallback(this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        int counter = 0;
        while (retry && counter++ < 1000) {
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;
            } catch (InterruptedException ie) {
                Log.i(TAG, "surfaceDestroyed: Current thread has been interrupted", ie);
            }
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.citybackground1048x258));
        bg.setVector(-3);
        //first get the images
        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
//        ImageView img = (ImageView)findViewById(R.id.walk);
//        ImageView mImageViewFilling = (ImageView) findViewById(R.id.walk);
////        mImageViewFilling.getBackground();
//        Canvas canvas = holder.lockCanvas(null);
//        mImageViewFilling.draw(canvas);
////                    drawSomething(canvas);
//        holder.unlockCanvasAndPost(canvas);
//    /***************************************************/
//        ((AnimationDrawable) mImageViewFilling.getBackground()).start();
//        img.setBackgroundResource(R.drawable.walk);

        // Get the background, which has been compiled to an AnimationDrawable object.
//        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default).
//        frameAnimation.start();
//        player = new Player(100, 20, 3);
//                player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.wait130x100),
//                34, 100, 3);
//        player.resetScore();

        mAssets = getContext().getAssets();

//        topborder = new ArrayList<TopBorder>();
//        botborder = new ArrayList<BotBorder>();

        thread = new MainThread(getHolder(), this);
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
////        if (event.getAction() == MotionEvent.ACTION_DOWN) {
////            if (!player.getPlaying() && newGameCreated && reset) {
////                player.setPlaying(true);
////                player.setRight(true);
////            }
////            if (player.getPlaying()) {
////
////                if (!gameStarted)
////                    gameStarted = true;
////
////                reset = false;
////                player.setRight(true);
////            }
////            return true;
////        }
////        if(event.getAction()==MotionEvent.ACTION_UP) {
////            player.setRight(false);
////            return true;
////        }
//
//        return super.onTouchEvent(event);
//    }


    public void update() {
//        if (player.getPlaying()) {
//
            bg.update();
//            player.update();
            //calculate the threshold of height the border can have based on the score
            //max and min border height are updated, and the border switched direction when either max or
            //min is met

//            maxBorderHeight = 30 + player.getScore() / progressDenom;
//            //cap max border height so that borders can only take up a total of 1/2 the screen
//            if (maxBorderHeight > HEIGHT / 4) maxBorderHeight = HEIGHT / 4;
//            minBorderHeight = 5 + player.getScore() / progressDenom;

            //update borders
//            updateTopBorder();
//            updateBottomBorder();


        }


//        if (!reset) {
//            newGameCreated = false;
//            startReset = System.nanoTime();
//            reset = true;
//
//            if (collision) {
//                // startSound(mp3Explode,PLAY_ONCE);
//                collision = false;
//            }
//        }

//            explosion.update();
        long resetElapsed = (System.nanoTime() - startReset) / 1000000;
//
//        if (resetElapsed > 2500 && !newGameCreated) {
//            newGame();
//        }







    public boolean collision(GameObject a, GameObject b) {
        return Rect.intersects(a.getRectangle(), b.getRectangle());
    }


    @Override
    public void draw(Canvas canvas) {
        final float scaleFactorX = getWidth() / (WIDTH * 1.f);
        final float scaleFactorY = getHeight() / (HEIGHT * 1.f);

        if (canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
//            if (!disappear) {
//                player.draw(canvas);
//            }

            drawText(canvas);
            canvas.restoreToCount(savedState);
        }
    }


    public void newGame() {

        disappear = false;





//        player.resetDY();
//        player.setY(HEIGHT / 2);


        newGameCreated = true;
    }


    public void drawText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);


//        if (!player.getPlaying() && newGameCreated && reset) {
//            Paint paint1 = new Paint();
//            paint1.setTextSize(40);
//            paint1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
//            canvas.drawText("PRESS TO START", WIDTH / 2 - 50, HEIGHT / 2, paint1);
//        }
    }

}
