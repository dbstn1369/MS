package com.example.choiyoonsoo.ms_hw09_201302494;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageView = (ImageView) findViewById(R.id.image);
        editText1 = (EditText) findViewById(R.id.Provider);
        editText2 = (EditText) findViewById(R.id.Name);
        editText3 = (EditText) findViewById(R.id.Price);
        editText4 = (EditText) findViewById(R.id.Description);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(editText1.getText().length()==0||editText2.getText().length()==0||editText3.getText().length()==0||editText4.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"값을 입력하세요.", Toast.LENGTH_LONG).show();
                   return;
                }else{
                    NumberFormat nf = NumberFormat.getInstance();
                    String price = nf.format(Integer.parseInt(editText3.getText().toString()) );
                    intent.putExtra("produce", "[" + editText1.getText().toString() + "]");
                    intent.putExtra("name", editText2.getText().toString());
                    intent.putExtra("price",price);
                    intent.putExtra("itemDescription", editText4.getText().toString());

                    setResult(RESULT_OK, intent);

                    finish();
                }
            }
        });

    }
}
