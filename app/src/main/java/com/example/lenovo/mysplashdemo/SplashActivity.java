package com.example.lenovo.mysplashdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jrummyapps.android.widget.AnimatedSvgView;

public class SplashActivity extends AppCompatActivity {

    private AnimatedSvgView mSvgView;
    private ImageView       mSplashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        mSplashText = (ImageView) findViewById(R.id.splash_text);

        mSplashText.setVisibility(View.INVISIBLE);

        mSvgView = (AnimatedSvgView) findViewById(R.id.animated_svg_view);


        mSvgView.postDelayed(new Runnable() {

            @Override
            public void run() {
                mSvgView.start();
            }
        }, 5000);


        mSvgView.setOnStateChangeListener(new AnimatedSvgView.OnStateChangeListener() {

            @Override
            public void onStateChange(int state) {
                if (state == AnimatedSvgView.STATE_FINISHED) {

                    mSplashText.setVisibility(View.VISIBLE);
                    final Animation anim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_anim);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);

                            finish();
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    mSplashText.startAnimation(anim);

                }
            }
        });
    }
}
