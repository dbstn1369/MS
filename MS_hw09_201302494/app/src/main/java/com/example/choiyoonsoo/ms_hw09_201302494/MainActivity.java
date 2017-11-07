package com.example.choiyoonsoo.ms_hw09_201302494;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    SingerAdapter adapter;

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public int getCount(){return items.size();}

        public void addItem(SingerItem item){items.add(item);}

        public Object getItem(int position){return items.get(position);}

        public long getItemId(int position){return position;}

        public View getView(int position, View convertView, ViewGroup viewGroup){
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setProduce(item.getProduce());
            view.setNameofproduct(item.getNameofproduct());
            view.setWhat(item.getWhat());
            view.setMoney(item.getMoney());
            view.setResid(item.getResid());

            int numColumns = gridView.getNumColumns();
            int rowIndex = position / numColumns;
            int columnIndex = position % numColumns;
            Log.d("SingerAdapter", "index : " + rowIndex + "," + columnIndex);

            return  view;

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridVeiw);

        adapter = new SingerAdapter();
    }
}
