package com.example.choiyoonsoo.ms_hw08_201302494;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    ListView listView;
    SingerAdapter adapter;
    Button button;
    TextView numofcount;

    public class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }


        public void addItem(SingerItem item) {
            items.add(item);
        }

        public Object delete(int position) {return items.remove(position);}

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setBirth(item.getBirth());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numofcount = (TextView) findViewById(R.id.count);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);


        adapter = new SingerAdapter();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("안내");
                builder.setMessage("종료하시겠습니까?");

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        adapter.delete(position);
                        adapter.notifyDataSetChanged();

                        numofcount.setText(adapter.getCount() + "명");
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        return;
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText birth = (EditText) findViewById(R.id.birthDate);
                EditText phone = (EditText) findViewById(R.id.phoneNumber);

                adapter.addItem(new SingerItem(name.getText().toString(), birth.getText().toString(), phone.getText().toString(), R.drawable.customer));

                numofcount.setText(adapter.getCount() + " 명");

                name.setText("");
                birth.setText("");
                phone.setText("");

            }
        });
    }


}
