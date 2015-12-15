package com.example.prokamon.projectend;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Prokamon on 10/12/2558.
 */
public class partTwo extends AppCompatActivity {
    ImageView box2, book2, trees, trees1,word4;
    ImageView jantawee3,oldmen1,oldwomen1;
    Button btn_left, btn_right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parttwo);

        box2 = (ImageView) findViewById(R.id.box2);
        book2 = (ImageView) findViewById(R.id.book2);
        trees = (ImageView) findViewById(R.id.trees);
        trees1 = (ImageView) findViewById(R.id.trees1);
        jantawee3 = (ImageView)findViewById(R.id.jantawee3);
        word4 = (ImageView)findViewById(R.id.word4);

        oldmen1 = (ImageView) findViewById(R.id.oldmen1);
        ((AnimationDrawable) oldmen1.getBackground()).start();
        oldmen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) oldmen1.getBackground()).stop();
                    //change image view
                   oldmen1.setBackgroundResource(R.drawable.oldmen);
                } catch (Exception e) {
                }
            }
        });
        oldwomen1 = (ImageView) findViewById(R.id.oldwomen1);
        ((AnimationDrawable) oldwomen1.getBackground()).start();
        oldwomen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) oldwomen1.getBackground()).stop();
                    //change image view
                    oldwomen1.setBackgroundResource(R.drawable.oldwomen);
                    word4.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }
            }
        });


        btn_left = (Button) findViewById(R.id.button1);
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_right = (Button) findViewById(R.id.button2);
        final Intent i = new Intent(this, partThree.class);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
