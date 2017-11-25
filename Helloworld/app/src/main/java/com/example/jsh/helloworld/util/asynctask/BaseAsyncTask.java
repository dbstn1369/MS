package com.example.jsh.helloworld.util.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.example.jsh.helloworld.util.RecyclerViewAdapter;
import com.example.jsh.helloworld.vo.Event;

import java.util.ArrayList;

public abstract class BaseAsyncTask extends AsyncTask<Void, Event, ArrayList<Event>> {

    private Context context;
    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;
    private ArrayList<Event> arrayList;

    public BaseAsyncTask() {
    }

    public BaseAsyncTask(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
        arrayList = new ArrayList<>();
    }

    @Override
    protected ArrayList<Event> doInBackground(Void... voids) {
        return parsingData(arrayList);
    }

    @Override
    protected void onPostExecute(ArrayList<Event> result) {
        super.onPostExecute(result);
        adapter = new RecyclerViewAdapter(context, result);
        recyclerView.setAdapter(adapter);
    }

    public abstract ArrayList<Event> parsingData(ArrayList<Event> arrayList);
}
