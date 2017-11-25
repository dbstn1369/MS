package com.example.jsh.helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jsh.helloworld.adapter.ViewPagerAdapter;
import com.example.jsh.helloworld.fragment.FestFragment;
import com.example.jsh.helloworld.fragment.NewsFragment;
import com.example.jsh.helloworld.vo.Event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//@startuml
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private List<Fragment> fragmentList;

    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        eventList = new ArrayList<>();

        fragmentList = new ArrayList<>();

        tabLayout.addTab(tabLayout.newTab().setText("공모전"));
        fragmentList.add(new NewsFragment());

        tabLayout.addTab(tabLayout.newTab().setText("축제"));
        fragmentList.add(new FestFragment());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alarmButton:
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                intent.putExtra("eventList", (Serializable) eventList);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO 임시 메소드
    public void addToList(Event event) {
        eventList.add(event);
    }
}
//@enduml