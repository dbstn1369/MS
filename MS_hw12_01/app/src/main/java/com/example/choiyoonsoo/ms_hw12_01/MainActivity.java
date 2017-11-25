package com.example.choiyoonsoo.ms_hw12_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText input01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input01 = (EditText) findViewById(R.id.input01);

        Button button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String addr = input01.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        public void run() {
            try {
                int port = 5001;

                Socket sock = new Socket(hostname, port);
                ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
                outStream.writeObject("모바일소프트웨어설계");
                outStream.flush();

                ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
                String obj = (String) instream.readObject();
                Log.d("MainActivity", "서버에서 받은 메시지 : " + obj);
                sock.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
