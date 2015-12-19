package com.example.prokamon.projectend;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView box, book1, chair, word1, word2, word3;
    Button btn_rigth;
    ImageView jantawee1, janta1, yotsawimon1;
    private Button button2;
    private Button button1;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button1 = (Button) findViewById(R.id.button1);

        box = (ImageView) findViewById(R.id.box);
        book1 = (ImageView) findViewById(R.id.book1);
        jantawee1 = (ImageView) findViewById(R.id.jantawee1);
        janta1 = (ImageView) findViewById(R.id.janta1);
        chair = (ImageView) findViewById(R.id.chair);
        yotsawimon1 = (ImageView) findViewById(R.id.yotsawimon1);
        word1 = (ImageView) findViewById(R.id.word1);
        word2 = (ImageView) findViewById(R.id.word2);
        word3 = (ImageView) findViewById(R.id.word3);
        btn_rigth = (Button) findViewById(R.id.button2);

        ((AnimationDrawable) jantawee1.getBackground()).start();
        ((AnimationDrawable) janta1.getBackground()).start();
        ((AnimationDrawable) yotsawimon1.getBackground()).start();
        jantawee1.setOnClickListener(this);
        janta1.setOnClickListener(this);
        yotsawimon1.setOnClickListener(this);
        btn_rigth.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jantawee1:
                try {
                    ((AnimationDrawable) jantawee1.getBackground()).stop();
                    //change image view
                    jantawee1.setBackgroundResource(R.drawable.jantawee);
                    word1.setVisibility(View.VISIBLE);
                    mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
                    mediaPlayer.start();
                } catch (Exception e) {
                }
                break;
            case R.id.janta1:
                try {
                    ((AnimationDrawable) janta1.getBackground()).stop();
                    //change image view
                    janta1.setBackgroundResource(R.drawable.janta);
                    word2.setVisibility(View.VISIBLE);
                    mediaPlayer = MediaPlayer.create(this, R.raw.sound2);
                    mediaPlayer.start();
                } catch (Exception e) {
                }
                break;
            case R.id.yotsawimon1:
                try {
                    ((AnimationDrawable) yotsawimon1.getBackground()).stop();
                    //change image view
                    yotsawimon1.setBackgroundResource(R.drawable.yotsawimon);
                    word3.setVisibility(View.VISIBLE);
                    mediaPlayer = MediaPlayer.create(this, R.raw.sound3);
                    mediaPlayer.start();
                } catch (Exception e) {
                }
                break;
            case R.id.button2:
                final Intent i = new Intent(this, partTwo.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();

        try {
            ((AnimationDrawable) jantawee1.getBackground()).stop();
            ((AnimationDrawable) janta1.getBackground()).stop();
            ((AnimationDrawable) yotsawimon1.getBackground()).stop();
        } catch (Exception e) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();

        try {
            ((AnimationDrawable) jantawee1.getBackground()).stop();
            ((AnimationDrawable) janta1.getBackground()).stop();
            ((AnimationDrawable) yotsawimon1.getBackground()).stop();
        } catch (Exception e) {

        }
    }

}
