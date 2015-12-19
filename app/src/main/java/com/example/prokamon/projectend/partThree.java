package com.example.prokamon.projectend;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Prokamon on 14/12/2558.
 */
public class partThree extends AppCompatActivity {
    ImageView box3, book3, trees, trees1;
    ImageView sungthong, chicken1, home1;
    Button btn_left, btn_right,btn_close;
    Dialog knowlesst;
    int pindex = 0;
    int[] resChiken = {R.drawable.bg, R.drawable.bg1, R.drawable.bg2};

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
                    knowlesst.show();
                } catch (Exception e) {
                }
            }
        });

        knowlesst = new Dialog(partThree.this);
        knowlesst.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog นำ layout chickenlayout มาแสดง
        knowlesst.setContentView(R.layout.chickenlaout);
        //dialog ให้สามารถปิิดได้
        knowlesst.setCancelable(true);

        final Button btnBack = (Button) knowlesst.findViewById(R.id.button1);
        final Button btnNext = (Button) knowlesst.findViewById(R.id.button);
        final ImageView bg = (ImageView) knowlesst.findViewById(R.id.bg);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pindex == resChiken.length - 1) {
                    bg.setImageResource(resChiken[0]);
                    pindex = 0;

                } else {
                    bg.setImageResource(resChiken[++pindex]);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pindex == 0) {
                    bg.setImageResource(resChiken[resChiken.length - 1]);
                    pindex = resChiken.length - 1;
                } else {
                    bg.setImageResource(resChiken[--pindex]);

                }
            }
        });
        //dialog เต็มหน้าจอ
        knowlesst.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        btn_close = (Button) knowlesst.findViewById(R.id.button3);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knowlesst.cancel();
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
