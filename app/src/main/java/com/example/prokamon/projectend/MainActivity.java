package com.example.prokamon.projectend;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    ImageView box, book1,chair, word1, word2, word3;
    Button btn_rigth;
    ImageView jantawee1, janta1, yotsawimon1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box = (ImageView) findViewById(R.id.box);
        book1 = (ImageView) findViewById(R.id.book1);
        jantawee1 = (ImageView) findViewById(R.id.jantawee1);
        janta1 = (ImageView) findViewById(R.id.janta1);
        chair = (ImageView) findViewById(R.id.chair);
        yotsawimon1 = (ImageView) findViewById(R.id.yotsawimon1);
        word1 = (ImageView) findViewById(R.id.word1);
        word2 = (ImageView) findViewById(R.id.word2);
        word3 = (ImageView) findViewById(R.id.word3);
        btn_rigth = (Button) findViewById(R.id.button);

        ((AnimationDrawable) jantawee1.getBackground()).start();
        jantawee1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) jantawee1.getBackground()).stop();
                    //change image view
                    jantawee1.setBackgroundResource(R.drawable.jantawee);
                    word1.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }
            }
        });

        ((AnimationDrawable) janta1.getBackground()).start();
        janta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) janta1.getBackground()).stop();
                    //change image view
                    janta1.setBackgroundResource(R.drawable.janta);
                    word2.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }
            }
        });

        ((AnimationDrawable) yotsawimon1.getBackground()).start();
        yotsawimon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) yotsawimon1.getBackground()).stop();
                    //change image view
                    yotsawimon1.setBackgroundResource(R.drawable.yotsawimon);
                    word3.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }
            }
        });

        final Intent i = new Intent(this, partTwo.class);
        btn_rigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_in_left);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
        ((AnimationDrawable) jantawee1.getBackground()).start();
        ((AnimationDrawable) janta1.getBackground()).start();
        ((AnimationDrawable) yotsawimon1.getBackground()).start();
    }
}
