package com.example.appbanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Animation in,out;
    ViewFlipper viewFlipper;
    Button btnPre,btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         viewFlipper=findViewById(R.id.viewFlipper);
         btnNext=findViewById(R.id.btnnext);
         btnPre=findViewById(R.id.btnPre);

         in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
         out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
         viewFlipper.setInAnimation(in);
         viewFlipper.setOutAnimation(out);
         viewFlipper.setFlipInterval(5000);
         viewFlipper.setAutoStart(true);
         btnPre.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(viewFlipper.isAutoStart()){
                     viewFlipper.stopFlipping();
                     viewFlipper.showPrevious();
                     viewFlipper.startFlipping();
                     viewFlipper.setAutoStart(true);
                 }
             }
         });
         btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
    }
}
