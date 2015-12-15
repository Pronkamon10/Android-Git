package com.example.prokamon.projectend;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Prokamon on 14/12/2558.
 */
public class partThree extends AppCompatActivity {
    ImageView box3, book3, trees, trees1;
    ImageView sungthong, chicken1, home1;
    Button btn_left, btn_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partthree);

        box3 = (ImageView) findViewById(R.id.box3);
        book3 = (ImageView) findViewById(R.id.book3);
        trees = (ImageView) findViewById(R.id.trees);
        trees1 = (ImageView) findViewById(R.id.trees1);
        sungthong = (ImageView) findViewById(R.id.sungthong);
        chicken1 = (ImageView) findViewById(R.id.chicken1);
        home1 = (ImageView) findViewById(R.id.home1);

        chicken1 = (ImageView) findViewById(R.id.chicken1);
        ((AnimationDrawable) chicken1.getBackground()).start();
        chicken1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) chicken1.getBackground()).stop();
                    //change image view
                    chicken1.setBackgroundResource(R.drawable.oldwomen);
                } catch (Exception e) {
                }
            }
        });

        home1 = (ImageView) findViewById(R.id.home1);
        ((AnimationDrawable) chicken1.getBackground()).start();
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((AnimationDrawable) home1.getBackground()).stop();
                    //change image view
                    home1.setBackgroundResource(R.drawable.oldwomen);
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
        final Intent i = new Intent(this, partFour.class);
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
}
