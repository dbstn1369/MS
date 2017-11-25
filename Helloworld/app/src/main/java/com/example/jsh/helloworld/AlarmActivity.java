package com.example.jsh.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jsh.helloworld.util.RecyclerViewAdapter;
import com.example.jsh.helloworld.util.VerticalSpaceItemDecoration;
import com.example.jsh.helloworld.vo.Event;

import java.util.ArrayList;

public class AlarmActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private VerticalSpaceItemDecoration decoration;

    private ArrayList<Event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        eventList = (ArrayList<Event>) getIntent().getSerializableExtra("eventList");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(AlarmActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        decoration = new VerticalSpaceItemDecoration(48);
        recyclerView.addItemDecoration(decoration);

        recyclerView.setAdapter(new RecyclerViewAdapter(AlarmActivity.this, eventList));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
