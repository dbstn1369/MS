package com.example.choiyoonsoo.ms_hw10_test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewDrawable myView = new CustomViewDrawable(this);
        setContentView(myView);

    }
}

