package sb15.tacoma.uw.edu.gameon;

import android.graphics.Rect;

public interface GameObject {

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    int getHeight();

    int getWidth();

    Rect getRectangle();

}