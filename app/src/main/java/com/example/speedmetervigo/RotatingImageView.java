package com.example.speedmetervigo;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class RotatingImageView extends AppCompatImageView {

    private float mRotation;
    private final Handler mHandler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    private final Runnable mRotateRunnable = new Runnable() {
        @Override
        public void run() {
            mRotation += 10;
            setRotation(mRotation);
            mHandler.notify();
        }
    };

    public RotatingImageView(Context context) {
        super(context);
        init();
    }

    public RotatingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotatingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setImageResource(R.drawable.arrow); // Ustaw tutaj swoje zdjęcie
        setScaleType(ScaleType.CENTER_CROP);
        mRotation = 0;
        mHandler.notify();
    }

}
