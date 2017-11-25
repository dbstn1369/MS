package com.example.choiyoonsoo.ms_hw10_test2;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
/**
 * Created by Choiyoonsoo on 2017-11-10.
 */

public class ColorPaletteDialog extends Activity {

    GridView grid;
    Button closeBtn;
    ColorDataAdapter adapter;

    public static OnColorSelectedListener listener;

    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.dialog);

        this.setTitle("Select Color");

        grid = (GridView) findViewById(R.id.colorGrid);
        closeBtn = (Button) findViewById(R.id.closeBtn);

        grid.setColumnWidth(14);
        grid.setBackgroundColor(Color.GRAY);
        grid.setVerticalSpacing(4);
        grid.setHorizontalSpacing(4);

        adapter = new ColorDataAdapter(this);
        grid.setAdapter(adapter);
        grid.setNumColumns(adapter.getNumColumns());

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

class ColorDataAdapter extends BaseAdapter{
    Context mContext;
    public static final int [] colors = new int[] {
            0xff000000,0xff00007f,0xff0000ff,0xff007f00,0xff007f7f,0xff00ff00,0xff00ff7f,
            0xff00ffff,0xff7f007f,0xff7f00ff,0xff7f7f00,0xff7f7f7f,0xffff0000,0xffff007f,
            0xffff00ff,0xffff7f00,0xffff7f7f,0xffff7fff,0xffffff00,0xffffff7f,0xffffffff
    };

    int rowCount, columnCount;

    public ColorDataAdapter(Context context){
        super();
        mContext = context;

        rowCount = 3;
        columnCount = 7;
    }

    public int getNumColumns() { return columnCount; }
    public int getCount(){ return rowCount * columnCount; }
    public Object getItem(int pos){ return colors[pos]; }
    public long getItemId(int pos){ return 0; }
    public View getView(int pos,  View view, ViewGroup group){
        int rowIndex = pos / rowCount;
        int columnIndex = pos % rowCount;

        GridView.LayoutParams params = new GridView.LayoutParams(
                GridView.LayoutParams.MATCH_PARENT,
                GridView.LayoutParams.MATCH_PARENT);
        Button aItem = new Button(mContext);
        aItem.setText(" ");
        aItem.setLayoutParams(params);
        aItem.setPadding(4, 4, 4, 4);
        aItem.setBackgroundColor(colors[pos]);
        aItem.setHeight(120);
        aItem.setTag(colors[pos]);

        aItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ColorPaletteDialog.listener != null){
                    ColorPaletteDialog.listener.onColorSelected(((Integer)v.getTag()).intValue());
                }
                ( (ColorPaletteDialog) mContext).finish();
            }
        });

        return aItem;
    }
}