package sb15.tacoma.uw.edu.gameon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Game extends AppCompatActivity {
    private GamePanel panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        panel = new GamePanel(this, 0); //currentHighScore


        setContentView(panel);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
