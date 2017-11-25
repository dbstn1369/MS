package com.example.choiyoonsoo.ms_hw11_test1;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    public  static  int spacing = -45;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoverFlow coverFlow = (CoverFlow) findViewById(R.id.coverflow);
        ImageAdapter coverImageAdapter = new ImageAdapter(this);
        coverFlow.setAdapter(coverImageAdapter);

        coverFlow.setSpacing(spacing);
        coverFlow.setSelection(2, true);
        coverFlow.setAnimationDuration(3000);
    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        private  Integer[] mImageIds = {R.drawable.item01, R.drawable.item02,R.drawable.item03,R.drawable.item04,R.drawable.item05};

        private ImageView[] mImages;

        public ImageAdapter(Context c){
            mContext = c;
            mImages = new ImageView[mImageIds.length];
        }

        public  int getCount(){return mImageIds.length;}
        public  Object getItem(int position){return position;}
        public long getItemId(int position){return  position;}

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView img = new ImageView(mContext);
            img.setImageResource(mImageIds[position]);
            img.setLayoutParams(new CoverFlow.LayoutParams(500,280));
            img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            BitmapDrawable drawable = (BitmapDrawable)img.getDrawable();
            drawable.setAntiAlias(true);

            return img;
        }
    }
}
