package com.example.choiyoonsoo.ms_hw09_201302494;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SingerItemView extends LinearLayout{
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    ImageView imageView;

    public SingerItemView(Context context){
        super(context);

        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs){
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView)findViewById(R.id.Provider);
        textView2= (TextView)findViewById(R.id.Name);
        textView3 = (TextView)findViewById(R.id.Price);
        textView4 = (TextView)findViewById(R.id.Description);
        imageView = (ImageView) findViewById(R.id.Image);
    }

    public void setProduce(String produce){textView.setText(produce);}
    public void setNameofproduct(String nameofproduct){textView2.setText(nameofproduct);}
    public void setMoney(String money){textView3.setText(money);}
    public void setwhat(String what){textView4.setText(what);}
    public void setResid(int resId){imageView.setImageResource(resId);}


}
