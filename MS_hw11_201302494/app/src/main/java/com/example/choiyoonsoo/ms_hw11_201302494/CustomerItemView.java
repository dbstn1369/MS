package com.example.choiyoonsoo.ms_hw11_201302494;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CustomerItemView extends LinearLayout {
    TextView itemView;
    TextView itemView2;
    TextView itemView3;
    ImageView imageView;

    public CustomerItemView(Context context) {
        super(context);

        init(context);
    }

    public CustomerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.customer_item, this, true);

        itemView = (TextView) findViewById(R.id.itemView);
        itemView2 = (TextView) findViewById(R.id.itemView2);
        itemView3 = (TextView) findViewById(R.id.itemView3);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name) {
        itemView.setText(name);
    }

    public void setMobile(String mobile) {
        itemView2.setText(mobile);
    }

    public void setAddress(String address) {
        itemView3.setText(address);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}