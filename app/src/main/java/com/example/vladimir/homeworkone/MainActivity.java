package com.example.vladimir.homeworkone;

import android.animation.ValueAnimator;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class MainActivity extends AppCompatActivity {

    private View mFirstAnimatedView;
    private ValueAnimator mAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstAnimatedView = findViewById(R.id.first_animated_view);

        mAnimator = ValueAnimator.ofInt(0, 10000);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(1000);
        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                Integer value = (Integer) animation.getAnimatedValue();
                mFirstAnimatedView.getBackground().setLevel(value);
            }
        });
        mAnimator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mAnimator.cancel();
        mAnimator.removeAllUpdateListeners();
        mAnimator = null;
    }
}