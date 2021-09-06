package com.example.androidelementary.funnyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidelementary.R;

/**
 * Created by ypp on 2020/12/23
 */
public class CountDownView extends FrameLayout implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    public static final int NUM_4000 = 4000;
    private static final int NUM_1000 = 1000;
    private static final int TEXT_SIZE_60 = 60;

    private int mCountDown;
    private TextView mTextView;
    private Animation mAnimation;
    private GestureDetector mGestureDetector;

    public CountDownView(@NonNull Context context) {
        super(context);
        init(null, 0);
    }

    public CountDownView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CountDownView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        final TypedArray arr = getContext().obtainStyledAttributes(
                attrs, R.styleable.CountDownView, defStyleAttr, 0);
        mCountDown = arr.getInteger(R.styleable.CountDownView_count_down, NUM_4000);
        arr.recycle();
        mTextView = new TextView(getContext());
        mTextView.setTextColor(Color.WHITE);
        mTextView.setTextSize(TEXT_SIZE_60);
        mTextView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        addView(mTextView, layoutParams);
        mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.count_down);
        mGestureDetector = new GestureDetector(this);
        mGestureDetector.setIsLongpressEnabled(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean consume = mGestureDetector.onTouchEvent(event);
        return consume;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
