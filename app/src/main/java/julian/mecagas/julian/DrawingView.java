package julian.mecagas.julian;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.Vector;

/**
 * Created by angel on 4/28/2018.
 */

public class DrawingView extends View {

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

    public DrawingView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);

    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle) {
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
        paint.setColor(Color.GRAY);
        for(int i = 0; i < height; i+=U) {
            canvas.drawLine(0, i, width, i, paint);
        }
        for(int i = 0; i < width; i+=U) {
            canvas.drawLine(i, 0, i, height, paint);
        }
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, U*18, width, U*18, paint);
        canvas.drawLine(width/2, U*18, Float.parseFloat(angleTo(width, height, 45, U*11)[0]+""), 0, paint);

        //Sup Izq
            //Base
        canvas.drawLine(U, U*17, Float.parseFloat(U*7+""), U*17, paint);
            //Left
        canvas.drawLine(U, U*17, U, U*13, paint);
            //Sup
        canvas.drawLine(U, U*13, U*7, U*13, paint);
            //Mid
        canvas.drawLine(U*4, U*13, U*4, U*17, paint);
            //Right
        canvas.drawLine(U*7, U*13, U*7, U*17, paint);

        //Inf Izq
            //Sup
        canvas.drawLine(U, U*19, U*4, U*19, paint);
            //Left
        canvas.drawLine(U, U*19, U, U*22, paint);
            //Base
        canvas.drawLine(U, U*22, U*7, U*22, paint);
            //MidY
        canvas.drawLine(U*4, U*19, U*4, Float.parseFloat(U*20.5+""), paint);
            //MidX
        canvas.drawLine(U*4, Float.parseFloat(U*20.5+""), U*7, Float.parseFloat(U*20.5+""), paint);
            //Right
        canvas.drawLine(U*7, Float.parseFloat(U*20.5+""), U*7, U*22, paint);

        //InfDer
            //Base
        canvas.drawLine(U*11, U*22, U*15, U*22, paint);
            //Left
        canvas.drawLine(U*11, U*22, U*11, U*19, paint);
            //Mid
        canvas.drawLine(U*11, Float.parseFloat(U*20.5+""), U*15, Float.parseFloat(U*20.5+""), paint);
            //Sup
        canvas.drawLine(U*11, U*19, U*15, U*19, paint);
            //Right
        canvas.drawLine(U*15, U*22, U*15, U*19, paint);


        //canvas.drawLine();

    }


}
