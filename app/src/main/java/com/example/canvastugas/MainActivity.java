package com.example.canvastugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaint2 = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mRect = new Rect();
    private Rect mDinding = new Rect();
    private Rect mPintu = new Rect();
    private Rect mBingkai = new Rect();
    private Rect mKaca = new Rect();

    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;
    private static final int COUNT = 0;
    private int count = COUNT;

    private int mColorBackground;
    private int mColorRumput;
    private int mColorDinding;
    private int mColorBingkai;
    private int mColorKaca;
    private int mColorAtap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBackground = ResourcesCompat.getColor(getResources(),
                R.color.colorLangit,null);
        mColorRumput = ResourcesCompat.getColor(getResources(),
                R.color.colorRumput,null);
        mColorDinding= ResourcesCompat.getColor(getResources(),
                R.color.colorDinding,null);
        mColorKaca = ResourcesCompat.getColor(getResources(),
                R.color.colorKaca,null);
        mColorBingkai = ResourcesCompat.getColor(getResources(),
                R.color.colorBingkai,null);
        mColorAtap = ResourcesCompat.getColor(getResources(),
                R.color.colorAtap,null);

        mPaint.setColor(mColorBackground);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black,null));
        mPaintText.setTextSize(70);

        mImageView = findViewById(R.id.myimageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view);
            }
        });
    }

    public void drawSomething(View view){
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;

            if (mOffset == OFFSET){
                mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
                mImageView.setImageBitmap(mBitmap);
                mCanvas = new Canvas(mBitmap);
                mCanvas.drawColor(mColorBackground);
                count += 1;
                mOffset += OFFSET;
            }
            else {
                if (count ==1){
                    mPaint.setColor(mColorRumput);
                    mRect.set(0, halfHeight,vWidth,vHeight);
                    mCanvas.drawRect(mRect, mPaint);
                    count += 1;
                    mOffset += OFFSET;
                }
                else if (count == 2) {
                    mPaint.setColor(mColorDinding);
                    mDinding.set(halfWidth-350, halfHeight-150,halfWidth+350,halfHeight+350);
                    mCanvas.drawRect(mDinding, mPaint);
                    count += 1;
                    mOffset += OFFSET;
                }
                else if (count == 3) {
                    mPaint.setColor(mColorBingkai);
                    mPintu.set(halfWidth+25, halfHeight-25,halfWidth+250,halfHeight+350);
                    mCanvas.drawRect(mPintu, mPaint);
                    count += 1;
                    mOffset += OFFSET;
                }
                else if (count == 4) {
                    mPaint.setColor(mColorBingkai);
                    mBingkai.set(halfWidth-250, halfHeight,halfWidth-75,halfHeight+200);
                    mCanvas.drawRect(mBingkai, mPaint);
                    count += 1;
                    mOffset += OFFSET;
                }
                else if (count == 5) {
                    mPaint.setColor(mColorKaca);
                    mKaca.set(halfWidth-225, halfHeight+25,halfWidth-100,halfHeight+175);
                    mCanvas.drawRect(mKaca, mPaint);
                    count += 1;
                    mOffset += OFFSET;
                }
                else if (count == 6){
                    mPaint2.setColor(mColorAtap);
                    Point a = new Point(halfWidth, halfHeight - 450);
                    Point b = new Point(halfWidth - 400, halfHeight -150);
                    Point c = new Point(halfWidth + 400, halfHeight -150);

                    Path path = new Path();
                    path.setFillType(Path.FillType.EVEN_ODD);
                    path.lineTo(a.x,a.y);
                    path.lineTo(b.x,b.y);
                    path.lineTo(c.x,c.y);
                    path.lineTo(a.x,a.y);
                    path.close();

                    mCanvas.drawPath(path,mPaint2);
                    count += 1;
                    mOffset += OFFSET;
                }

            }


        view.invalidate();
    }

}