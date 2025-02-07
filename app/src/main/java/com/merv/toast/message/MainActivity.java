package com.merv.toast.message;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.button.MaterialButton;
import com.merv.toast.library.MervToastMessage;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatTextView materialButton = findViewById(R.id.button);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MervToastMessage.with(MainActivity.this)
                        .setToastType(MervToastMessage.MERV__TYPE_WARNING)
                        .setText("Warning Toast Message!")
                        .setTextSize(15f)
                        .setTextColor(getColor(R.color.white))
                        .setFont(R.font.poppins)
                        .setGravity(MervToastMessage.MERV__GRAVITY_CENTER)
                        .setAnimation(MervToastMessage.MERV_FADE_ANIMATION)
                        .setAnimationDuration(500)
                        .setScreenTime(2000)
                        .setRadius(20)
                        .setMargin(50, 0, 50, 0)
                        .setMervShow();
            }
        });



    }
}