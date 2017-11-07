package com.example.choiyoonsoo.ms_hw08_test3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    GridView gridView;
    SingerAdapter adapter;

    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public int getCount(){return items.size();}

        public void addItem(SingerItem item){items.add(item);}

        public Object getItem(int position){return items.get(position);}

        public long getItemId(int position){return position;}

        public  View getView(int position, View convertView, ViewGroup viewGroup){
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

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
        adapter.addItem(new SingerItem("소녀시대","010-1000-1000",2007,R.drawable.girlsgeneration));
        adapter.addItem(new SingerItem("에이핑크","010-2000-2000",2011,R.drawable.apink));
        adapter.addItem(new SingerItem("여자친구","010-3000-3000",2015,R.drawable.girlfriend));
        adapter.addItem(new SingerItem("레드벨벳","010-4000-4000",2014,R.drawable.redvelvet));
        adapter.addItem(new SingerItem("AOA","010-5000-5000", 2012, R.drawable.aoa));
        adapter.addItem(new SingerItem("트와이스","010-6000-6000",2015,R.drawable.twice));

        gridView.setAdapter(adapter);

        editText = (EditText)findViewById(R.id.editText);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view , int position, long id){
                SingerItem item = (SingerItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }
    }

