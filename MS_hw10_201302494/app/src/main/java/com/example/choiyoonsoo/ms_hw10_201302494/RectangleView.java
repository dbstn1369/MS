package com.example.choiyoonsoo.ms_hw10_201302494;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Choiyoonsoo on 2017-11-09.
 */

public class RectangleView extends View {

    private Paint paint;
    int x = 100,y = 100;

    public RectangleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(x,y,x + 100, y + 100, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                x = (int) event.getX();
                y = (int) event.getY();
                invalidate();
        }
        return true;
    }
}
