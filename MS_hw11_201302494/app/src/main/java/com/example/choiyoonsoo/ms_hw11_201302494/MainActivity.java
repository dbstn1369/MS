package com.example.choiyoonsoo.ms_hw11_201302494;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout container;


    CustomerItemView view;
    CustomerItemView view2;
    CustomerItemView view3;
    TransThread thread;
    int selected = 0;

    boolean running = false;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.container);

        view = new CustomerItemView(this);
        view.setName("김준수");
        view.setMobile("010-2000-2000");
        view.setAddress("서울시");
        container.addView(view);

        view2 = new CustomerItemView(this);
        view2.setName("이희선");
        view2.setMobile("010-3000-3000");
        view2.setAddress("부산시");


        view3 = new CustomerItemView(this);
        view3.setName("최미선");
        view3.setMobile("010-3000-3000");
        view3.setAddress("대전시");

        thread = new TransThread();
        thread.start();
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });

    }

    class TransThread extends Thread {
        public void run() {
            while (true) {
                try {
                    if (running) {
                        handler.post(new Runnable() {
                            public void run() {
                                if (selected == 0) {
                                    container.removeView(view3);
                                } else if (selected == 1) {
                                    container.addView(view2);
                                } else if(selected ==2) {
                                    container.removeView(view2);
                                    container.addView(view3);
                                }
                                selected += 1;
                                if (selected > 2) {
                                    selected = 0;
                                }

                            }

                        });

                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                }

            }
        }
    }
}
