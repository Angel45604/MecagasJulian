package julian.mecagas.julian;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Vector;

/**
 * Created by angel on 4/28/2018.
 */

public class DrawingView2 extends View {

    private float[] hsv = {(float) 0, 1, (float) 1};
    private float[] hsvo = {0, (float) 1, (float) 0};
    private int vertexNum = 5;
    private int margin = 200;
    private float hue = 0;
    private int width = getContext().getResources().getDisplayMetrics().widthPixels;
    private int height = getContext().getResources().getDisplayMetrics().heightPixels;
    private int paintWidth=5;
    private int U = width/20;
    Paint paint = new Paint();

    public DrawingView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DrawingView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        start();
    }

    public void start() {
        margin = 10;
        Vector v = new Vector();
    }

    public double[] angleTo(int x, int y, int angle, int length) {
        double[] xy = new double[2];
        xy[0] = (x + length * Math.sin(angle* Math.PI / 180));
        xy[1] = (y + length * Math.sin(angle* Math.PI / 180));
        return xy;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, width, height, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

        //Base
        canvas.drawLine(U*10, U*18, Float.parseFloat(angleTo(U*10, U*18, 30, U*6)[0]+""), Float.parseFloat(angleTo(U*10, U*18, 30, U*6)[1]+""), paint);
        Log.d("U", U+"");
        Log.d("START", "X "+ U*10 + " Y " + U*18);
        Log.d("END", "X " + angleTo(U*10, U*18, 210, U*6)[0] + " Y " + angleTo(U*10, U*18, 210, U*6)[1]);
        //Left
        canvas.drawLine(U*10, U*18, U*10, U*14, paint);
        //Right
        canvas.drawLine(Float.parseFloat(503.99999999999994 + ""), 1080, Float.parseFloat(503.99999999999994 + ""), Float.parseFloat(U*16.5 + ""), paint);

    }


}
