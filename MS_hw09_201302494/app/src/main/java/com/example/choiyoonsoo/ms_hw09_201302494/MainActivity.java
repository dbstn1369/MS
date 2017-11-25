package com.example.choiyoonsoo.ms_hw09_201302494;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU =101;
    GridView gridView;
    SingerAdapter adapter;
    ActionBar abar;

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        public Object getItem(int position) {
            return items.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setProduce(item.getProduce());
            view.setNameofproduct(item.getNameofproduct());
            view.setMoney(item.getMoney());
            view.setwhat(item.getWhat());
            view.setResid(item.getResid());

            int numColumns = gridView.getNumColumns();
            int rowIndex = position / numColumns;
            int columnIndex = position % numColumns;
            d("SingerAdapter", "index : " + rowIndex + "," + columnIndex);

            return view;

        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abar = this.getSupportActionBar();
        abar.show();

        gridView = (GridView) findViewById(R.id.gridVeiw);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("[빈폴]", "롱 코트", "300,000", "기획상품", R.drawable.clothes1));
        adapter.addItem(new SingerItem("[나이키]", "운동화", "70,000", "특가상품", R.drawable.clothes2));
        adapter.addItem(new SingerItem("[폴로]", "남방", "150,000", "계절상품", R.drawable.clothes3));
        adapter.addItem(new SingerItem("[리바이스]", "모자", "40,000", "반짝상품", R.drawable.clothes4));
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택된 제품 : " + item.getNameofproduct() + "\n가격 : " + item.getMoney(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.plus) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, REQUEST_CODE_MENU);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_MENU){
                if(data != null) {
                    Bundle bundle = data.getExtras();
                    String produce = bundle.getString("produce");
                    String name = bundle.getString("name");
                    String price = bundle.getString("price");
                    String itemDescription = bundle.getString("itemDescription");

                    adapter.addItem(new SingerItem(produce, name, price, itemDescription, R.drawable.clothes5));
                    gridView.setAdapter(adapter);
                }

            }
        }
    }
}
