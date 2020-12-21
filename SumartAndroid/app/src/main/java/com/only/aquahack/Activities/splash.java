package com.only.aquahack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.only.aquahack.R;


public class splash extends AppCompatActivity {


    ImageView img;
    Animation text_anim;
    TextView bits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        bits = findViewById(R.id.bits);
        img = findViewById(R.id.logoImg);

        text_anim = AnimationUtils.loadAnimation(this , R.anim.text_anim);
        bits.setAnimation(text_anim);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent  = new Intent(splash.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
},1700);

    }
}
