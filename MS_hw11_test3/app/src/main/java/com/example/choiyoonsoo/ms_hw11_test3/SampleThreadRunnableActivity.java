package com.example.choiyoonsoo.ms_hw11_test3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Choiyoonsoo on 2017-11-17.
 */

public class SampleThreadRunnableActivity extends Activity {

    ProgressBar bar;
    TextView textView;
    boolean isRunning = false;
    Handler handler;
    ProgressRunnable runnable;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar=(ProgressBar)findViewById(R.id.progress);
        textView =(TextView)findViewById(R.id.textView);

        handler = new Handler();
        runnable = new ProgressRunnable();
    }
    public void onStart(){
        super.onStart();

        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i = 0; i < 20 && isRunning; i++){
                        Thread.sleep(1000);

                        handler.post(runnable);
                    }
                }catch (Exception ex){
                    Log.e("SampleThreadActivity", "Exception in processing message.",ex);
                }
            }
        });
        isRunning = true;
        thread1.start();
    }
    public void onStop(){
        super.onStop();
        isRunning = false;
    }

    public class ProgressRunnable implements Runnable{
        public void run(){
            bar.incrementProgressBy(5);

            if(bar.getProgress() == bar.getMax()){
                textView.setText("Runnable Done");

            }else{
                textView.setText("Runnable Working ..."+ bar.getProgress());
            }

        }
    }
}
